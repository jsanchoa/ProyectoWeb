package com.proyecto.dao;
import com.proyecto.domain.EntrenamientoCita;
import com.proyecto.domain.EntrenamientoCitaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenamientoCitaDao extends JpaRepository<EntrenamientoCita, EntrenamientoCitaId> {
    
}
