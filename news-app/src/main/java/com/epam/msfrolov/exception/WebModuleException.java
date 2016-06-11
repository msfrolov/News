package com.epam.msfrolov.exception;

public class WebModuleException extends RuntimeException {

    public WebModuleException(String message) {
        super(message);
    }

    public WebModuleException(String message, Throwable cause) {
        super(message, cause);
    }

}
