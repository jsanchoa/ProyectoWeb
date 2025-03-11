package com.proyecto.dao;

import com.proyecto.domain.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

// Conector entre el codigo y la base de datos
public interface EspecialidadDao extends JpaRepository<Especialidad, Long> {

}



