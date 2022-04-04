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

/**
 * Base executor implementation for the public data enpoint
 */
public abstract class BaseVisionRequestExecutor<T> extends RequestExecutor<ResponseBody>
        implements VisionRequestExecutor<T> {

    /**
     * The default constructor
     * 
     * @param call The retrofit call
     */
    protected BaseVisionRequestExecutor(Call<ResponseBody> call) {
        super(call);
    }

    public ZipInputStream getZip() {
        try {
            return new ZipInputStream(execute().byteStream());
        } catch (ApiException e) {
            throw new RuntimeException("Unable to download file");
        }
    }

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
