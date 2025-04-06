package com.proyecto.service;

import com.proyecto.domain.EstadoBDD;

import java.util.List;

public interface EstadoService {

    public List<EstadoBDD> getListaEstados();

    public EstadoBDD getEstadoBDD(int idEstadoBDD);
}
