package com.binance4j.vision.executor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

import com.binance4j.core.callback.ApiCallback;
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
            return responseToZip(execute());
        } catch (ApiException e) {
            throw new RuntimeException("Unable to download file");
        }
    }

    public void getZip(ApiCallback<ZipInputStream> callback) {
        then(new ApiCallback<ResponseBody>() {
            @Override
            public void onFailure(ApiException exception) {
                callback.onFailure(exception);
            }

            @Override
            public void onInternalError() {
                callback.onInternalError();
            }

            @Override
            public void onRateLimitBan() {
                callback.onRateLimitBan();
            }

            @Override
            public void onRateLimitBreak() {
                callback.onRateLimitBreak();
            }

            @Override
            public void onWAFLimit() {
                callback.onWAFLimit();
            }

            @Override
            public void onResponse(ResponseBody res) {
                callback.onResponse(responseToZip(res));

            }
        });
    }

    public ZipInputStream responseToZip(ResponseBody res) {
        return new ZipInputStream(res.byteStream());
    }

    public List<String[]> zipToCSV(ZipInputStream zis) throws IOException {
        List<String[]> data = new LinkedList<>();
        Scanner sc = new Scanner(zis);

        zis.getNextEntry();

        while (sc.hasNextLine()) {
            data.add(sc.nextLine().split(","));
        }

        sc.close();
        return data;
    }

    public List<String[]> getCSV() throws IOException {
        return zipToCSV(getZip());
    }

    public void getCSV(ApiCallback<List<String[]>> callback) {
        then(new ApiCallback<ResponseBody>() {
            @Override
            public void onResponse(ResponseBody res) {
                try {
                    callback.onResponse(zipToCSV(responseToZip(res)));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            public void onFailure(ApiException exception) {
                callback.onFailure(exception);
            }

            @Override
            public void onInternalError() {
                callback.onInternalError();
            }

            @Override
            public void onRateLimitBan() {
                callback.onRateLimitBan();
            }

            @Override
            public void onRateLimitBreak() {
                callback.onRateLimitBreak();
            }

            @Override
            public void onWAFLimit() {
                callback.onWAFLimit();
            }

        });
    }
}
