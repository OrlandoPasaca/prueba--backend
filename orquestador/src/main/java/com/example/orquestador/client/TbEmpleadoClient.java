package com.example.orquestador.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.orquestador.dto.TbEmpleadoDto;
import com.example.orquestador.utils.ApiResponse;

import org.springframework.http.MediaType;


@FeignClient(name = "tbEmpleadoClient", url = "http://localhost:8080/tbempleado")
public interface TbEmpleadoClient {
    
    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<TbEmpleadoDto> save(TbEmpleadoDto empleadoDto);
}
