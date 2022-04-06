package com.binance4j.vision.executor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
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
public abstract class VisionRequestExecutor<T> extends RequestExecutor<ResponseBody> {

    /**
     * The default constructor
     * 
     * @param call The retrofit call
     */
    protected VisionRequestExecutor(List<Call<ResponseBody>> call) {
        super(call);
    }

    protected VisionRequestExecutor(Call<ResponseBody> call) {
        super(call);
    }

    /**
     * Downloads the zip file synchronously
     * 
     * @return The zip file
     */
    public ZipInputStream getZip() {
        try {
            return responseToZip(execute());
        } catch (ApiException e) {
            throw new RuntimeException("Unable to download file");
        }
    }

    /**
     * Downloads the zip file asynchronously
     * 
     * @param callback The callback handling the deserialized data and the API
     *                 response error
     */
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

    /**
     * Downloads the zip file synchronously and returns the data in a csv style (2d
     * list)
     * 
     * @return The deserialized data
     * @throws IOException
     */
    public List<List<String>> getCSV() throws IOException {
        return extractCSV(getZip());
    }

    /**
     * Downloads the zip file asynchronously and returns the data in a csv style
     * (2d list)
     * 
     * @param callback The callback handling the deserialized data and
     *                 the API response error
     */
    public void getCSV(ApiCallback<List<List<String>>> callback) {
        then(new ApiCallback<ResponseBody>() {
            @Override
            public void onResponse(ResponseBody res) {
                try {
                    callback.onResponse(extractCSV(responseToZip(res)));
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

    /**
     * Downloads the zip file synchronously and returns the data in the csv as a
     * list of objects
     * 
     * @return The deserialized data
     * @throws IOException
     */
    public List<T> getData() throws IOException {
        return csvToObject(getCSV());
    }

    /**
     * Downloads the zip file asynchronously and returns the data in the csv as a
     * list of objects
     * 
     * @param callback The callback handling the deserialized data and
     *                 the API response error
     */
    public void getData(ApiCallback<List<T>> callback) {
        then(new ApiCallback<ResponseBody>() {

            @Override
            public void onResponse(ResponseBody res) {
                try {
                    callback.onResponse(csvToObject(extractCSV(responseToZip(res))));
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

    /**
     * Converts the responseBody into a zip stream
     * 
     * @param res The responseBody
     * @return The zip stream
     */
    protected ZipInputStream responseToZip(ResponseBody res) {
        return new ZipInputStream(res.byteStream());
    }

    /**
     * Extracts the csv from the zip
     * 
     * @param zis the zip stream
     * @return The data as a list of string arrays
     */
    protected List<List<String>> extractCSV(ZipInputStream zis) throws IOException {
        List<List<String>> data = new LinkedList<>();
        Scanner sc = new Scanner(zis);

        zis.getNextEntry();

        while (sc.hasNextLine()) {
            data.add(Arrays.asList(sc.nextLine().split(",")));
        }

        sc.close();
        return data;
    }

    /**
     * Converts the csv into a list of the desired type
     *
     * @param input The data as a list of string arrays
     * @return The data as a list of objects
     */
    protected List<T> csvToObject(Class<T> clazz,
            List<List<String>> input) {
        return input.stream()
                .map(csv -> {
                    try {
                        // The class must have a constructor that accepts a 2d list
                        return clazz.getConstructor(List.class).newInstance(csv);
                    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                            | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }

    /**
     * The child class method to convert the csv list into a list of the generic
     * type
     * 
     * @param input The csv input
     * @return A list of
     */
    protected abstract List<T> csvToObject(List<List<String>> input);
}