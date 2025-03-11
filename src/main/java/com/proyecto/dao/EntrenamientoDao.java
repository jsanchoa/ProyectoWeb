package com.proyecto.dao;
package com.proyecto.domain.Entrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

// Conector entre el codigo y la base de datos
public interface EntrenamientoDao extends JpaRepository<Entrenamiento, int> {

}
