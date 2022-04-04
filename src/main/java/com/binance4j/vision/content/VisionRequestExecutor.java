package com.binance4j.vision.content;

import java.io.IOException;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * Request executor for the public data endpoint
 */
public interface VisionRequestExecutor<T> {

    /**
     * Downloads the zip file
     * 
     * @return The zip file
     */
    public ZipInputStream getZip();

    /**
     * Downloads the zip file and returns the data in the csv as a list of string
     * arrays
     * 
     * @return The deserialized data
     * @throws IOException
     */
    public List<String[]> getCSV() throws IOException;

    /**
     * Downloads the zip file and returns the data in the csv as a list of objects
     * 
     * @return The deserialized data
     * @throws IOException
     */
    public List<T> getData() throws IOException;
}
