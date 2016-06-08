package com.epam.msfrolov.exception;

public class DatabaseModuleException extends RuntimeException {

    public DatabaseModuleException(String message) {
        super(message);
    }

    public DatabaseModuleException(String message, Throwable cause) {
        super(message, cause);
    }

}
