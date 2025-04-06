package com.proyecto.dao;

import com.proyecto.domain.TipoRutina;
import org.springframework.data.jpa.repository.JpaRepository;

// Conector entre el codigo y la base de datos
public interface RutinaDao extends JpaRepository<TipoRutina, Long> {

}



