package com.codese.SpringBootBackendBoilderplate.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorMessage {
    private int code;
    private String message;
}