package com.proyecto.service.impl;

import com.proyecto.dao.EntrenadorDao;
import com.proyecto.dao.EntrenamientoDao;
import com.proyecto.domain.Entrenador;
import com.proyecto.domain.Entrenamiento;
import com.proyecto.service.EntrenadorService;
import java.util.List;
import com.proyecto.dao.EntrenadorDao;
import com.proyecto.service.EntrenamientoService;
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
        if (activos) {
            lista.removeIf(e -> e.getEstado().getIdEstado() == 2);
        }
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
}