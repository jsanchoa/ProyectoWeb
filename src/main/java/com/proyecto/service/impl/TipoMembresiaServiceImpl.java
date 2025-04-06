package com.proyecto.service.impl;

import com.proyecto.dao.TipoMembresiaDao;
import com.proyecto.dao.TipoUsuarioDao;
import com.proyecto.domain.TipoMembresia;
import com.proyecto.service.TipoMembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMembresiaServiceImpl implements TipoMembresiaService {

    @Autowired
    private TipoMembresiaDao tipoMembresiaDao;

    @Override
    public List<TipoMembresia> getTipoMembresia() {
        return tipoMembresiaDao.findAll();
    }


}
