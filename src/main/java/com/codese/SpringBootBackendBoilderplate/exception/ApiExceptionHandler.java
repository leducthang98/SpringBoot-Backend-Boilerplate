package com.codese.SpringBootBackendBoilderplate.exception;

import com.codese.SpringBootBackendBoilderplate.constant.Error;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage UnknownException(Exception ex, WebRequest request) {
        return new ErrorMessage(Error.UNKNOWN.getCode(), ex.getMessage());
    }

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage ApiException(ApiException ex, WebRequest request) {
        return new ErrorMessage(Error.UNKNOWN.getCode(), ex.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage BadCredentialsException(Exception ex, WebRequest request) {
        return new ErrorMessage(Error.INVALID_USERNAME_OR_PASSWORD.getCode(), Error.INVALID_USERNAME_OR_PASSWORD.getMessage());
    }

    @ExceptionHandler(InterruptedException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage InterruptedException(Exception ex, WebRequest request) {
        return new ErrorMessage(Error.BAD_STRUCTURE.getCode(), ex.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage MissingServletRequestParameterException(Exception ex, WebRequest request) {
        return new ErrorMessage(Error.INVALID_INPUT_PARAMS.getCode(), Error.INVALID_INPUT_PARAMS.getMessage());
    }

}
