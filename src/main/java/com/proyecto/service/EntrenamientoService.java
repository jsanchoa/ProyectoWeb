package com.proyecto.service;

import com.proyecto.domain.Entrenamiento;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface EntrenamientoService {

    @Transactional(readOnly = true)
    List<Entrenamiento> getEntrenamiento(boolean activos);

    public Entrenamiento getEntrenamiento(Entrenamiento entrenamiento);
    
    public void save(Entrenamiento entrenamiento);

    public void delete(Entrenamiento entrenamiento);
    
    Optional<Entrenamiento> findById(Long id);
}
