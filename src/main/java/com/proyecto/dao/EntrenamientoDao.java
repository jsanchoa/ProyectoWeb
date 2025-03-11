
package com.proyecto.dao;
import com.proyecto.domain.Entrenamiento;\
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author naoal
 */
// Conector entre el codigo y la base de datos

public interface EntrenamientoDao extends JpaRepository<Entrenamiento, Long>{

}
