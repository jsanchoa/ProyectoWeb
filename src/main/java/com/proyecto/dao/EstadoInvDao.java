package com.proyecto.dao;

import com.proyecto.domain.EstadoInventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoInvDao extends JpaRepository<EstadoInventario, Long> {
}
