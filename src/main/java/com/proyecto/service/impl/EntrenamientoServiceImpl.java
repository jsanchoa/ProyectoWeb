package com.proyecto.service.impl;

import com.proyecto.dao.EntrenamientoDao;
import com.proyecto.domain.Entrenamiento;

import java.util.List;
import com.proyecto.service.EntrenamientoService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntrenamientoServiceImpl implements EntrenamientoService {

    @Autowired
    private EntrenamientoDao entrenamientoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Entrenamiento> getEntrenamiento(boolean activos) {
        var lista = entrenamientoDao.findAll();
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Entrenamiento getEntrenamiento(Entrenamiento entrenamiento) {
        return entrenamientoDao.findById(entrenamiento.getIdEntrenamiento()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Entrenamiento entrenamiento) {
        entrenamientoDao.save(entrenamiento);
    }

    @Override
    @Transactional
    public void delete(Entrenamiento entrenamiento) {
        entrenamientoDao.delete(entrenamiento);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Entrenamiento> findById(Long id) {
        return entrenamientoDao.findById(id);
    }
}