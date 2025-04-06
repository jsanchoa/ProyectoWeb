package com.proyecto.dao;

import com.proyecto.domain.EstadoBDD;
import org.springframework.data.jpa.repository.JpaRepository;

// Conector entre el codigo y la base de datos
public interface EstadoDao extends JpaRepository<EstadoBDD, Long> {

}



