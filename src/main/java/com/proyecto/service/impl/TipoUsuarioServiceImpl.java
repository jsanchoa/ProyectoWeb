package com.proyecto.service.impl;

import com.proyecto.dao.TipoUsuarioDao;
import com.proyecto.domain.TipoUsuario;
import com.proyecto.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    @Autowired
    private TipoUsuarioDao tipoUsuarioDao;

    @Override
    @Transactional(readOnly = true)
    public TipoUsuario findByidTipoUsuario(int idTipoUsuario) {
        return tipoUsuarioDao.findByidTipoUsuario((long) idTipoUsuario);
    }
}
