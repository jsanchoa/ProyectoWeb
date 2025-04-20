package com.proyecto.service;

import com.proyecto.domain.EntrenamientoCita;
import com.proyecto.domain.EntrenamientoCitaId;
import java.util.List;

public interface EntrenamientoCitaService {
    
    List<EntrenamientoCita> getAll();
    
    void save(EntrenamientoCita entrenamientoCita);
    
    void delete(EntrenamientoCita entrenamientoCita);
    
    EntrenamientoCita getById(EntrenamientoCitaId id);
}
