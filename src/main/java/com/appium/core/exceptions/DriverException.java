package com.appium.core.exceptions;

public class DriverException extends RuntimeException{
    public DriverException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DriverException(final String message){
        super(message);
    }
}
