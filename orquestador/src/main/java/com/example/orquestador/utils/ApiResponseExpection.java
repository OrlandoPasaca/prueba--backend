package com.example.orquestador.utils;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Generated
@Data
@Builder
@AllArgsConstructor
public class ApiResponseExpection extends RuntimeException{
    
    private String mensaje;
    private HttpStatus status = HttpStatus.OK;

    public ApiResponseExpection() {
        super();
    }
}
