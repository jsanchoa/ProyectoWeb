package com.proyecto.service.impl;
import com.proyecto.domain.Cita;
import com.proyecto.service.CitaService;
import java.util.List;        
import com.proyecto.dao.CitaDao;
import com.proyecto.domain.Entrenamiento;
import com.proyecto.service.EntrenamientoCitaService;
import com.proyecto.domain.EntrenamientoCita;
import com.proyecto.domain.EntrenamientoCitaId;
import com.proyecto.service.EntrenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitaServiceImpl implements CitaService{
    @Autowired
    private CitaDao citaDao;
    
    @Autowired
    private EntrenamientoService entrenamientoService;

    @Autowired
    private EntrenamientoCitaService entrenamientoCitaService;
    
    @Override
    @Transactional(readOnly = true)
    public List<Cita> getCita() {
        var lista = citaDao.findAll();
        return lista;
    }
    @Override
    @Transactional(readOnly = true)
    public Cita getCita(Cita cita) {

        return citaDao.findById(cita.getIdCita()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Cita cita) {
        citaDao.save(cita); 

        if (cita.getEntrenamientoId() != null) {
            Entrenamiento entrenamiento = entrenamientoService.findById(cita.getEntrenamientoId())
                    .orElseThrow(() -> new IllegalArgumentException("Entrenamiento no encontrado"));

            EntrenamientoCita entrenamientoCita = new EntrenamientoCita();
            entrenamientoCita.setCita(cita);
            entrenamientoCita.setEntrenamiento(entrenamiento);
            entrenamientoCita.setId(new EntrenamientoCitaId(entrenamiento.getIdEntrenamiento(), cita.getIdCita()));

            entrenamientoCitaService.save(entrenamientoCita); // Este servicio debe guardar la relación
        }
    }

    @Override
    @Transactional
    public void delete(Cita cita) {
        citaDao.delete(cita);
    }
    
}
