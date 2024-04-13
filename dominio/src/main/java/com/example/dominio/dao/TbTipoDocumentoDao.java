package com.example.dominio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dominio.entity.TbTipoDocumento;

public interface TbTipoDocumentoDao extends JpaRepository<TbTipoDocumento, Long> {

    
}