package com.proyecto.service;

import com.proyecto.domain.Cita;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CitaService {

    @Transactional(readOnly = true)
    public List<Cita> getCita();
    
    public Cita getCita(Cita cita);
    
    public void save(Cita cita);

    public void delete(Cita cita);
}