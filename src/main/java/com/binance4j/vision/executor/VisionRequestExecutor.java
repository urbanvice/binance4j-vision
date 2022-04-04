package com.binance4j.vision.executor;

import java.io.IOException;
import java.util.List;
import java.util.zip.ZipInputStream;

import com.binance4j.core.callback.ApiCallback;

/**
 * Request executor for the public data endpoint
 */
public interface VisionRequestExecutor<T> {

    /**
     * Converts the raw data into an object
     * 
     * @param input The data as a list of string arrays
     * @return The data as a list of objects
     */
    List<T> csvToObject(List<String[]> input);

    /**
     * Downloads the zip file synchronously
     * 
     * @return The zip file
     */
    ZipInputStream getZip();

    /**
     * Downloads the zip file asynchronously
     * 
     * @param callback The callback handling the deserialized data and the API
     *                 response error
     */
    void getZip(ApiCallback<ZipInputStream> callback);

    /**
     * Downloads the zip file synchronously and returns the data in the csv as a
     * list of string
     * arrays
     * 
     * @return The deserialized data
     * @throws IOException
     */
    List<String[]> getCSV() throws IOException;

    /**
     * Downloads the zip file asynchronously and returns the data in the csv as a
     * list of string
     * arrays
     * 
     * @param callback The callback handling the deserialized data and
     *                 the API response error
     */
    void getCSV(ApiCallback<List<String[]>> callback);

    /**
     * Downloads the zip file synchronously and returns the data in the csv as a
     * list of objects
     * 
     * @return The deserialized data
     * @throws IOException
     */
    List<T> getData() throws IOException;

    /**
     * Downloads the zip file asynchronously and returns the data in the csv as a
     * list of objects
     * 
     * @param callback The callback handling the deserialized data and
     *                 the API response error
     */
    void getData(ApiCallback<List<T>> callback);
}
