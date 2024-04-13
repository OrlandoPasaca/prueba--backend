package com.example.dominio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dominio.entity.TbEmpleado;

public interface TbEmpleadoDao extends JpaRepository<TbEmpleado, Long> {

    
}