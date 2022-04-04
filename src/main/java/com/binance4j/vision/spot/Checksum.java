package com.binance4j.vision.spot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The representation of a checksum
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Checksum {
    /**
     * @return The MD5 checksum
     * @param checksum The new value
     */
    private String checksum;

    /**
     * @return The file name
     * @param fileName The new value
     */
    private String fileName;
}
