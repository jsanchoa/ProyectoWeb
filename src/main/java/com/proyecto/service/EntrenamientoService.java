package com.proyecto.service;

import com.proyecto.domain.Entrenamiento;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EntrenamientoService {

    @Transactional(readOnly = true)
    List<Entrenamiento> getEntrenamiento(boolean activos);

    public Entrenamiento getEntrenamiento(Entrenamiento entrenamiento);
    
    public void save(Entrenamiento entrenamiento);

    public void delete(Entrenamiento entrenamiento);
}
