package com.proyecto.service;

import com.proyecto.domain.Entrenador;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EntrenadorService {

    @Transactional(readOnly = true)
    public List<Entrenador> getEntrenador(boolean activos);
    
    public Entrenador getEntrenador(Entrenador entrenador);
    
    public void save(Entrenador entrenador);

    public void delete(Entrenador entrenador);

}
