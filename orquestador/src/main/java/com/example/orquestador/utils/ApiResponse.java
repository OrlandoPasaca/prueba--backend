package com.example.orquestador.utils;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Generated
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    
    private T data;
    private String mensaje;
    @Builder.Default
    private HttpStatus status = HttpStatus.OK;
}
