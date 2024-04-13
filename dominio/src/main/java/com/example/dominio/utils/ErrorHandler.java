package com.example.dominio.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(HttpMessageNotReadableException ex,
            WebRequest request) {
        return new ResponseEntity<>(ApiResponse.builder()
                .mensaje(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApiResponseExpection.class)
    public ResponseEntity<Object> apiResponseException(ApiResponseExpection ex, WebRequest request) {
        return new ResponseEntity<>(ApiResponse.builder()
                .mensaje(ex.getMensaje())
                .status(ex.getStatus())
                .build(), ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ApiResponse.builder()
                .mensaje(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
