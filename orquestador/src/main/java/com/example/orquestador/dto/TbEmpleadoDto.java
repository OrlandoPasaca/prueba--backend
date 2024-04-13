package com.example.orquestador.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Generated
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TbEmpleadoDto {
    
    private Long idEmpleado;
    
    private String nombres;

    private String apellidos;

    private Integer edad;

    private String direccion;

    private TbTipoDocumentoDto tbTipoDocumento;
}
