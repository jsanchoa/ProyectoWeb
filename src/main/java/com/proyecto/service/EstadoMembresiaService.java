package com.proyecto.service;
import java.util.List;

import com.proyecto.domain.EstadoMembresia;

public interface EstadoMembresiaService {
    public List<EstadoMembresia> getListaEstadoMembresias();

    public EstadoMembresia getEstadoMembresia(int idEstadoMembresia);
}
