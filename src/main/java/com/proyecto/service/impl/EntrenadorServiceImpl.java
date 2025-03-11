package com.proyecto.service.impl;

import com.proyecto.dao.EntrenadorDao;
import com.proyecto.domain.Entrenador;
import com.proyecto.service.EntrenadorService;
import java.util.List;
import com.proyecto.dao.EntrenadorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntrenadorServiceImpl implements EntrenadorService{

    @Autowired
    private EntrenadorDao entrenadorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Entrenador> getEntrenador(boolean activos) {
        var lista = entrenadorDao.findAll();
        if (activos) {
            lista.removeIf(e -> e.getEstado().getIdEstado() == 2);
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Entrenador getEntrenador(Entrenador entrenador) {
        return entrenadorDao.findById(entrenador.getIdEntrenador()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Entrenador entrenador) {
        entrenadorDao.save(entrenador);
    }

    @Override
    @Transactional
    public void delete(Entrenador entrenador) {
        entrenadorDao.delete(entrenador);
    }
}