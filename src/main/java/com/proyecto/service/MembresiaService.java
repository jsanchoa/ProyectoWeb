package com.proyecto.service;

import com.proyecto.domain.Cita;
import com.proyecto.domain.Membresia;

import java.util.List;

public interface MembresiaService {
    public List<Membresia> getListaMembresias();

    public void save(Membresia membresia);

    public void delete(Membresia membresia);
}
