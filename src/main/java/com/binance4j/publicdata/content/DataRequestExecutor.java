package com.binance4j.publicdata.content;

import java.io.IOException;
import java.util.List;
import java.util.zip.ZipInputStream;

public interface DataRequestExecutor<T> {

    /**
     * Downloads the zip file
     * 
     * @return The zip file
     */
    public ZipInputStream getZip();

    /**
     * Downloads the zip file and deserializes the data in the compressed .csv file
     * into a list of string arrays
     * 
     * @return The deserialized data
     * @throws IOException
     */
    public List<String[]> getCSV() throws IOException;

    /**
     * Downloads the zip file and deserializes the data in the compressed .csv file
     * into a list of objects
     * 
     * @return The deserialized data
     * @throws IOException
     */
    public List<T> getData() throws IOException;
}
