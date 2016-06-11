package com.epam.msfrolov.exception;

public class ServiceModuleException extends RuntimeException {

    public ServiceModuleException(String message) {
        super(message);
    }

    public ServiceModuleException(String message, Throwable cause) {
        super(message, cause);
    }

}
