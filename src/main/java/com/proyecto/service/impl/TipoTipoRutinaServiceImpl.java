package com.proyecto.service.impl;

import com.proyecto.dao.RutinaDao;
import com.proyecto.domain.TipoRutina;
import com.proyecto.service.TipoRutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoTipoRutinaServiceImpl implements TipoRutinaService {

    @Autowired
    private RutinaDao rutinaDao;

    @Override
    @Transactional(readOnly = true)
    public List<TipoRutina> getTipoRutina() {
        var lista = rutinaDao.findAll();
        return lista;
    }
}
