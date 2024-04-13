package com.example.orquestador.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orquestador.dto.TbEmpleadoDto;
import com.example.orquestador.service.TbEmpladoService;
import com.example.orquestador.utils.ApiResponse;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tbempleado")
public class TbEmpleadoController {

    TbEmpladoService empladoService;

    public TbEmpleadoController(@Autowired TbEmpladoService empladoService) {
        this.empladoService = empladoService;
    }

    @PostMapping("save")
    public ResponseEntity<ApiResponse<TbEmpleadoDto>> save(@RequestBody TbEmpleadoDto entity)
            throws BadRequestException {
        return ResponseEntity.ok(ApiResponse.<TbEmpleadoDto>builder().data(empladoService.save(entity)).build());
    }

}