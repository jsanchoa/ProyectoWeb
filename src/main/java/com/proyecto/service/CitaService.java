package com.proyecto.service;

import com.proyecto.domain.Cita;
import java.util.List;

public interface CitaService {
    public List<Cita> getCita();
    
    public Cita getCita(Cita cita);
    
    public void save(Cita cita);

    public void delete(Cita cita);
}