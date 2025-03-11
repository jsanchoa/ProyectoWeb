package com.proyecto.service.impl;

import com.proyecto.dao.EstadoDao;
import com.proyecto.domain.Estado;
import com.proyecto.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoDao estadoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Estado> getListaEstados() {
        var lista = estadoDao.findAll();
        return lista;
    }
}
