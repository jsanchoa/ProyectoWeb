package com.proyecto.dao;

import com.proyecto.domain.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

// Conector entre el codigo y la base de datos
public interface EntrenadorDao extends JpaRepository<Entrenador, Long> {

}



