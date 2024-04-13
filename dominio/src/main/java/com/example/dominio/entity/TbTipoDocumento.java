package com.example.dominio.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_tipo_documento")
public class TbTipoDocumento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoDocumento;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nombre;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tbTipoDocumento")
    private List<TbEmpleado> tbEmpleados = new ArrayList<>();
}
