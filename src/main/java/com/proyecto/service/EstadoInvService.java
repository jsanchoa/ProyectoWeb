package com.proyecto.service;

import com.proyecto.domain.EstadoBDD;
import com.proyecto.domain.EstadoInventario;

import java.util.List;

public interface EstadoInvService {

    public List<EstadoInventario> getListaEstadosInventario();
}
