package com.binance4j.vision.exception;

/**
 * Exception thrown when a date is invalid
 */
public class InvalidDateException extends Exception {
    /**
     * Constructor
     */
    public InvalidDateException() {
        super("The given date is invalid");
    }
}