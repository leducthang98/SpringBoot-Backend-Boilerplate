package com.codese.SpringBootBackendBoilderplate.exception;

public class ApiException extends Exception {
    public ApiException(String message) {
        super(message);
    }
}
