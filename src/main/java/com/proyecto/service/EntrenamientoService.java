package com.proyecto.service;
package com.proyecto.domain.Entrenamiento;
import java.util.List;

public class EntrenamientoService {
    public List<Entrenamiento> getEntrenamiento();
    
    public Entrenamiento getEntrenamiento(Entrenamiento entrenamiento);
    
    public void save(Entrenamiento entrenamiento);

    public void delete(Entrenamiento entrenamiento);
}
