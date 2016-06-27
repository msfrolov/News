package com.epam.msfrolov.exception;

/**
 * Web module exceptions wrappers
 */
public class WebModuleException extends RuntimeException {

    public WebModuleException(String message) {
        super(message);
    }

    public WebModuleException(String message, Throwable cause) {
        super(message, cause);
    }

}
