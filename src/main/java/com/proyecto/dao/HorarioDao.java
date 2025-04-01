package com.proyecto.dao;

import com.proyecto.domain.EstadoMembresia;
import com.proyecto.domain.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioDao extends JpaRepository<Horario, Long> {

}
