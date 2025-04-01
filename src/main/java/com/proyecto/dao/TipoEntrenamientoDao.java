package com.proyecto.dao;

import com.proyecto.domain.EstadoMembresia;
import com.proyecto.domain.TipoEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEntrenamientoDao extends JpaRepository<TipoEntrenamiento, Long> {

}
