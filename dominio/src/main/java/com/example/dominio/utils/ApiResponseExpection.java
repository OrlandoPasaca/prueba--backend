package com.example.dominio.utils;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ApiResponseExpection extends RuntimeException {

    private String mensaje;
    private HttpStatus status = HttpStatus.OK;

    public ApiResponseExpection() {
        super();
    }
}
