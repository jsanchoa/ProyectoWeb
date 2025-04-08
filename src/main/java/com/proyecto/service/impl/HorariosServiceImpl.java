package com.proyecto.service.impl;

import com.proyecto.dao.HorarioDao;
import com.proyecto.domain.Horario;
import com.proyecto.service.HorariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HorariosServiceImpl implements HorariosService {

    @Autowired
    private HorarioDao horarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Horario> getListaHorarios() {
        return horarioDao.findAll();
    }
}
