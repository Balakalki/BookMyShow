package com.balakalkialuri.BookMyShow.test;

import com.balakalkialuri.BookMyShow.exception.AppException;
import com.balakalkialuri.BookMyShow.exception.ErrorType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/test/bad-request")
    public String badRequest() {
        throw new AppException(
                ErrorType.BAD_REQUEST,
                "Invalid request"
        );
    }

    @GetMapping("/test/authentication")
    public String authentication() {
        throw new AppException(
                ErrorType.AUTHENTICATION_FAILED,
                "Authentication failed"
        );
    }

    @GetMapping("/test/access-denied")
    public String accessDenied() {
        throw new AppException(
                ErrorType.ACCESS_DENIED,
                "Access denied"
        );
    }

    @GetMapping("/test/not-found")
    public String notFound() {
        throw new AppException(
                ErrorType.NOT_FOUND,
                "Resource not found"
        );
    }

    @GetMapping("/test/user-not-found")
    public String userNotFound() {
        throw new AppException(
                ErrorType.USER_NOT_FOUND,
                "User not found",
                "userId", 101
        );
    }

    @GetMapping("/test/conflict")
    public String conflict() {
        throw new AppException(
                ErrorType.CONFLICT,
                "Resource already exists"
        );
    }

    @GetMapping("/test/system-error")
    public String systemError() {
        throw new AppException(
                ErrorType.SYSTEM_ERROR,
                "Unexpected system error"
        );
    }

    @GetMapping("/test/runtime")
    public String runtime() {
        throw new RuntimeException("Unexpected RuntimeException");
    }

    @GetMapping("/test/map")
    public String mapException() {
        throw new AppException(
                ErrorType.BAD_REQUEST,
                "Validation failed",
                Map.of(
                        "field", "email",
                        "reason", "already exists"
                )
        );
    }
}