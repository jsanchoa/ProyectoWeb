package com.proyecto.dao;

import com.proyecto.domain.TipoRutina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEntrenamientoDao extends JpaRepository<TipoRutina, Long> {

}
