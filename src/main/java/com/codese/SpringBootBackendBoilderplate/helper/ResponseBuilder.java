package com.codese.SpringBootBackendBoilderplate.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBuilder<T> {
    private int code;
    private String message;
    private T data;

    public static <T> ResponseBuilder<T> buildResponse(T data) {
        ResponseBuilder<T> response = new ResponseBuilder<T>();
        response.data = data;
        response.code = 200;
        response.message = "ok";
        return response;
    }

    public static <T> ResponseBuilder<T> buildCustomResponse(T data, int code, String message) {
        ResponseBuilder<T> response = new ResponseBuilder<T>();
        response.data = data;
        response.code = code;
        response.message = message;
        return response;
    }

}
