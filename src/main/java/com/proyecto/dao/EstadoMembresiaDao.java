package com.proyecto.dao;

import com.proyecto.domain.EstadoMembresia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoMembresiaDao extends JpaRepository<EstadoMembresia, Long> {

    public EstadoMembresia findByidEstadoMembresia(int idEstadoMembresia);

}
