package com.epam.msfrolov.exception;

public class DbModuleException extends RuntimeException {

    public DbModuleException(String message) {
        super(message);
    }

    public DbModuleException(String message, Throwable cause) {
        super(message, cause);
    }

}
