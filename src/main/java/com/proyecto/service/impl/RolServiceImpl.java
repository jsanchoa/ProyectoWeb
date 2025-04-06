package com.proyecto.service.impl;

import com.proyecto.dao.RolDao;
import com.proyecto.domain.Rol;
import com.proyecto.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public Rol findByidRol(int idRol) {
        return rolDao.findByidRol((long) idRol);
    }
}
