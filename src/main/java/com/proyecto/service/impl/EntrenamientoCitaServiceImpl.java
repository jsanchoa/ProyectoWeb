package com.proyecto.service.impl;

import com.proyecto.dao.EntrenamientoCitaDao;
import com.proyecto.domain.EntrenamientoCita;
import com.proyecto.domain.EntrenamientoCitaId;
import com.proyecto.service.EntrenamientoCitaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntrenamientoCitaServiceImpl implements EntrenamientoCitaService {

    @Autowired
    private EntrenamientoCitaDao entrenamientoCitaDao;

    @Override
    @Transactional(readOnly = true)
    public List<EntrenamientoCita> getAll() {
        return entrenamientoCitaDao.findAll();
    }

    @Override
    @Transactional
    public void save(EntrenamientoCita entrenamientoCita) {
        entrenamientoCitaDao.save(entrenamientoCita);
    }

    @Override
    @Transactional
    public void delete(EntrenamientoCita entrenamientoCita) {
        entrenamientoCitaDao.delete(entrenamientoCita);
    }

    @Override
    @Transactional(readOnly = true)
    public EntrenamientoCita getById(EntrenamientoCitaId id) {
        return entrenamientoCitaDao.findById(id).orElse(null);
    }
}
