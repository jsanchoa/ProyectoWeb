package com.proyecto.service.impl;

import com.proyecto.dao.EspecialidadDao;
import com.proyecto.domain.Especialidad;
import com.proyecto.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadDao especialidadDao;

    @Override
    @Transactional(readOnly = true)
    public List<Especialidad> getListaEspecialidades() {
        var lista = especialidadDao.findAll();
        return lista;
    }
}
