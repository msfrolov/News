package com.epam.msfrolov.exception;

/**
 * DataBase module exceptions wrappers
 */
public class DbModuleException extends RuntimeException {

    public DbModuleException(String message) {
        super(message);
    }

    public DbModuleException(String message, Throwable cause) {
        super(message, cause);
    }

}
