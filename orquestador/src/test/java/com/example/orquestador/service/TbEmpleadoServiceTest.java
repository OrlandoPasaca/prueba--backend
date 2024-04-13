package com.example.orquestador.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Objects;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.example.orquestador.client.TbEmpleadoClient;
import com.example.orquestador.dto.TbEmpleadoDto;
import com.example.orquestador.dto.TbTipoDocumentoDto;
import com.example.orquestador.service.impl.TbEmpleadoServiceImpl;
import com.example.orquestador.utils.ApiResponse;
import com.example.orquestador.utils.ApiResponseExpection;

@ExtendWith(MockitoExtension.class)
public class TbEmpleadoServiceTest {

    @Mock
    TbEmpleadoClient empleadoClient;
    @InjectMocks
    TbEmpleadoServiceImpl empladoService;

    @Nested
    class TbEmpleadoSave {
        static Stream<Arguments> dataEmpleados() {
            return Stream.of(Arguments.of(
                    TbEmpleadoDto.builder()
                            .nombres(null)
                            .build()),
                    Arguments.of(TbEmpleadoDto.builder()
                            .nombres("Jose")
                            .apellidos(null)
                            .build()),
                    Arguments.of(TbEmpleadoDto.builder()
                            .nombres("Jose")
                            .apellidos("Campos")
                            .tbTipoDocumento(TbTipoDocumentoDto.builder().build())
                            .build()),
                    Arguments.of(TbEmpleadoDto.builder()
                            .nombres("Jose")
                            .apellidos("Campos")
                            .tbTipoDocumento(TbTipoDocumentoDto.builder().idTipoDocumento(1L).build())
                            .build()));
        }

        @ParameterizedTest
        @MethodSource("dataEmpleados")
        @DisplayName("Prueba validaciones")
        void save_01(TbEmpleadoDto empleadoDto) {
            assumingThat(StringUtils.isBlank(empleadoDto.getNombres()),
                    () -> assertThrows(ApiResponseExpection.class, () -> empladoService.save(empleadoDto)));
            assumingThat(StringUtils.isBlank(empleadoDto.getApellidos()),
                    () -> assertThrows(ApiResponseExpection.class, () -> empladoService.save(empleadoDto)));
            assumingThat(Objects.isNull(empleadoDto.getTbTipoDocumento()),
                    () -> assertThrows(ApiResponseExpection.class, () -> empladoService.save(empleadoDto)));
            assumingThat(
                    Objects.nonNull(empleadoDto.getTbTipoDocumento())
                            && Objects.isNull(empleadoDto.getTbTipoDocumento().getIdTipoDocumento()),
                    () -> assertThrows(ApiResponseExpection.class, () -> empladoService.save(empleadoDto)));
        }

        @Test
        @DisplayName("Probar validacion respuesta dominio")
        void save_02() {
            when(empleadoClient.save(any(TbEmpleadoDto.class))).thenReturn(ApiResponse.<TbEmpleadoDto>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build());
            assertThrows(ApiResponseExpection.class, () -> empladoService.save(TbEmpleadoDto.builder()
                    .nombres("Jose")
                    .apellidos("Campos")
                    .tbTipoDocumento(TbTipoDocumentoDto.builder()
                            .idTipoDocumento(1l)
                            .build())
                    .build()));
        }

        @Test
        @DisplayName("Probar respuesta metodo save")
        void save_03() {
            TbEmpleadoDto empleado = TbEmpleadoDto.builder()
                    .nombres("Jose")
                    .apellidos("Campos")
                    .tbTipoDocumento(TbTipoDocumentoDto.builder()
                            .idTipoDocumento(1l)
                            .build())
                    .build();
            when(empleadoClient.save(any(TbEmpleadoDto.class))).thenReturn(ApiResponse.<TbEmpleadoDto>builder()
                    .data(empleado)
                    .status(HttpStatus.OK)
                    .build());
            TbEmpleadoDto response = empladoService.save(empleado);
            assertEquals(empleado, response);
         }
    }
}
