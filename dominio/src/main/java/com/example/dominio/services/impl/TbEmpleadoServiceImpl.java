package com.example.dominio.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dominio.dao.TbEmpleadoDao;
import com.example.dominio.entity.TbEmpleado;
import com.example.dominio.services.TbEmpleadoService;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;

@Service
@Transactional
@NoArgsConstructor
public class TbEmpleadoServiceImpl implements TbEmpleadoService {
    
    @Autowired
    TbEmpleadoDao empleadoDao;

    @Override
    public TbEmpleado save(TbEmpleado empleado) {
        return empleadoDao.save(empleado);   
    }
}
