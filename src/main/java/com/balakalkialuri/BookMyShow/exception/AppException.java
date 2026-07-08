package com.balakalkialuri.BookMyShow.exception;

import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

@Getter
public class AppException extends RuntimeException{
    private final ErrorType type;
    private Map<String, Object> data;

    public AppException(ErrorType type, String message, Map<String, Object> data) {
        super(message);
        this.type = type;
        this.data = data;
    }

    public AppException(ErrorType type, String message, Map<String, Object> data, Throwable cause) {
        super(message, cause);
        this.type = type;
        this.data = data;
    }

    public AppException(ErrorType type, String message) {
        super(message);
        this.type = type;
    }

    public AppException(ErrorType type, String message, Throwable cause) {
        super(message, cause);
        this.type = type;
    }

    public AppException(ErrorType type, String message, Object... keyValues) {
        super(message);
        this.type = type;

        if (keyValues.length %2 != 0) {
            throw new IllegalArgumentException("key-value pairs must be even");
        }

        this.data = new HashMap<>();

        for (int i = 0; i < keyValues.length; i++) {
            data.put((String)keyValues[i], keyValues[++i]);
        }
    }
}
