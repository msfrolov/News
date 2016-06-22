package com.epam.msfrolov.exception;

/**
 * Service module exceptions wrappers
 */
public class ServiceModuleException extends RuntimeException {

    public ServiceModuleException(String message) {
        super(message);
    }

    public ServiceModuleException(String message, Throwable cause) {
        super(message, cause);
    }

}
