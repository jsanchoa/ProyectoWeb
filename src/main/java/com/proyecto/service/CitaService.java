package com.proyecto.service;
package com.proyecto.domain.Cita;
import java.util.List;

public class CitaService {
    public List<Cita> getCita();
    
    public Cita getCita(Cita cita);
    
    public void save(Cita cita);

    public void delete(Cita cita);
}