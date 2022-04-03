package com.binance4j.vision.content;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.request.RequestExecutor;

import okhttp3.ResponseBody;
import retrofit2.Call;

public abstract class BaseDataRequestExecutor<T> extends RequestExecutor<ResponseBody>
        implements DataRequestExecutor<T> {

    protected BaseDataRequestExecutor(Call<ResponseBody> call) {
        super(call);
    }

    /**
     * Calls {@link RequestExecutor#execute()} and wraps the responseBody in a
     * {@link ZipInputStream}
     * 
     * @return The zip file
     */
    public ZipInputStream getZip() {
        try {
            return new ZipInputStream(execute().byteStream());
        } catch (ApiException e) {
            throw new RuntimeException("Unable to download file");
        }
    }

    /**
     * Calls {@link BaseDataRequestExecutor#getZip()} and extracts the CSV into a
     * list
     * of arrays
     * 
     * @return
     * @throws IOException
     * @throws CsvException
     */
    public List<String[]> getCSV() throws IOException {
        ZipInputStream zis = getZip();
        List<String[]> data = new LinkedList<>();
        Scanner sc = new Scanner(zis);

        zis.getNextEntry();

        while (sc.hasNextLine()) {
            data.add(sc.nextLine().split(","));
        }

        sc.close();
        return data;
    }
}
