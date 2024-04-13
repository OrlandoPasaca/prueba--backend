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
@Builder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TbTipoDocumentoDto {
    
    private Long idTipoDocumento;

    private String codigo;

    private String nombre;
    
}
