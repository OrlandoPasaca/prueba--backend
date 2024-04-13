package com.example.orquestador.service;

import org.apache.coyote.BadRequestException;

import com.example.orquestador.dto.TbEmpleadoDto;

public interface TbEmpladoService {
    TbEmpleadoDto save(TbEmpleadoDto empleadoDto);
}
