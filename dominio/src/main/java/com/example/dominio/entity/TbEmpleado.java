package com.example.dominio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_empleado")
public class TbEmpleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;
    
    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    private Integer edad;

    private String direccion;

    @JoinColumn(name = "id_tipo_documento", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private TbTipoDocumento tbTipoDocumento;
}
