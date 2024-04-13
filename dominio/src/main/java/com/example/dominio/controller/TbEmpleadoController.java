package com.example.dominio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dominio.entity.TbEmpleado;
import com.example.dominio.services.TbEmpleadoService;
import com.example.dominio.utils.ApiResponse;

@RestController
@RequestMapping("/tbempleado")
public class TbEmpleadoController {

    TbEmpleadoService empleadoService;

    public TbEmpleadoController(@Autowired TbEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("save")
    public ResponseEntity<ApiResponse<TbEmpleado>> postMethodName(@RequestBody TbEmpleado empleado) {
        return ResponseEntity
                .ok(ApiResponse.<TbEmpleado>builder().data(empleadoService.save(empleado)).mensaje("Empleado creado")
                        .build());
    }

}
