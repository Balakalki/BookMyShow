package com.balakalkialuri.BookMyShow.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.HttpStatus.valueOf;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> handleAppException(AppException ex, HttpServletRequest request) {
        log.error("App error:", ex);
        return createErrorResponse(ex, request.getRequestURI());
    }

    private ResponseEntity<QErrorResponse> createErrorResponse(AppException ex, String path) {
        Error error = new Error(ex, path);
        QErrorResponse errorResponse = QErrorResponse.fromError(error);
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), valueOf(errorResponse.getError().getStatus()));
    }

}
