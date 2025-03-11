package com.proyecto.dao;
package com.proyecto.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

// Conector entre el codigo y la base de datos
public interface ClienteDao extends JpaRepository<Cliente, int> {

}

