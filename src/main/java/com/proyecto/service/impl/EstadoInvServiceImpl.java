package com.proyecto.service.impl;

import com.proyecto.dao.EstadoInvDao;
import com.proyecto.domain.EstadoInventario;
import com.proyecto.service.EstadoInvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoInvServiceImpl implements EstadoInvService {

    @Autowired
    private EstadoInvDao estadoInvDao;

    @Override
    public List<EstadoInventario> getListaEstadosInventario() {
        return estadoInvDao.findAll();
    }

}
