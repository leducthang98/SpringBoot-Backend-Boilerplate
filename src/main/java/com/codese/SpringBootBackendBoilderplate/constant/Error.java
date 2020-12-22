package com.codese.SpringBootBackendBoilderplate.constant;

public enum Error {
    UNKNOWN(400, "Unknown error"),
    INVALID_INPUT_PARAMS(400, "Invalid input params"),
    USER_NOTFOUND(400, "User not found"),
    BAD_STRUCTURE(400, "Bad structure"),
    UNAUTHORIZED(401, "Unauthorized"),
    INVALID_USERNAME_OR_PASSWORD(400, "Username or password incorrect"),
    NOTHING_CHANGED(502, "Nothing changed"),
    TOKEN_REQUIRED(403, "Token required"),
    TOKEN_INVALID(400, "Invalid token");

    private int code;
    private String message;

    private Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}