package com.example.orquestador.service.impl;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.orquestador.client.TbEmpleadoClient;
import com.example.orquestador.dto.TbEmpleadoDto;
import com.example.orquestador.service.TbEmpladoService;
import com.example.orquestador.utils.ApiResponse;
import com.example.orquestador.utils.ApiResponseExpection;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class TbEmpleadoServiceImpl implements TbEmpladoService {

    @Autowired TbEmpleadoClient empleadoClient;

    @Override
    public TbEmpleadoDto save(TbEmpleadoDto empleadoDto) {
        if (StringUtils.isBlank(empleadoDto.getNombres())) {
            throw ApiResponseExpection.builder()
                    .mensaje("El nombre es requerido")
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
        if (StringUtils.isBlank(empleadoDto.getApellidos())) {
            throw ApiResponseExpection.builder()
                    .mensaje("El apellido es requerido")
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
        if (Objects.isNull(empleadoDto.getTbTipoDocumento())
                || Objects.isNull(empleadoDto.getTbTipoDocumento().getIdTipoDocumento())) {
            throw ApiResponseExpection.builder()
                    .mensaje("El tipo documento es requerido")
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
        ApiResponse<TbEmpleadoDto> response = empleadoClient.save(empleadoDto);
        if (!response.getStatus().equals(HttpStatus.OK)) {
            throw ApiResponseExpection.builder()
                    .mensaje(response.getMensaje())
                    .status(response.getStatus())
                    .build();
        }
        return response.getData();
    }
}
