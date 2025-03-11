package com.proyecto.service.impl;
package com.proyecto.dao.EntrenamientoDao;
package com.proyecto.domain.Entrenamiento;
package com.proyecto.service.EntrenamientoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntrenamientoServiceImpl implements EntrenamientoService{
    @Autowired
    private Entrenamiento entrenamientoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Entrenamiento> getEntrenamiento(boolean activos) {
        var listaEntrenamientos = entrenamientoDao.findAll();
        if (activos) {
            listaEntrenamientos.removeIf(e -> !e.isActivo());
        }
        return listaEntrenamientos;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Entrenamiento getEntrenamiento(Entrenamiento entrenamiento) {
        return entrenamientoDao.findById(acceso.getIdEntrenamiento()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Entrenamiento entrenamiento) {
        entrenamientoDao.save(entrenamiento);
    }

    @Override
    @Transactional
    public void delete(Entrenamiento entrenamiento) {
        entrenamientoDao.delete(entrenamiento);
    }
}
