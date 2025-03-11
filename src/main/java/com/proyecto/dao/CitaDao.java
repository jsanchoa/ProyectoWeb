package com.proyecto.dao;
package com.proyecto.domain.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

// Conector entre el codigo y la base de datos
public interface CitaDao extends JpaRepository<Cita, int> {

}


