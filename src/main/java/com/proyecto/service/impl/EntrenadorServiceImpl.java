package com.proyecto.service.impl;
package com.proyecto.dao.EntrenadorDao;
package com.proyecto.domain.Entrenador;
package com.proyecto.service.EntrenadorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntrenadorServiceImpl implements EntrenadorService{
    @Autowired
    private Entrenador entrenadorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Entrenador> getEntrenador(boolean activos) {
        var listaEntrenadores = entrenadorDao.findAll();
        if (activos) {
            listaEntrenadores.removeIf(e -> !e.isActivo());
        }
        return listaEntrenadores;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Entrenador getEntrenador(Entrenador entrenador) {
        return entrenadorDao.findById(acceso.getIdEntrenador()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Entrenador entrenador) {
        entrenadorDao.save(entrenador);
    }

    @Override
    @Transactional
    public void delete(Entrenador entrenador) {
        entrenadorDao.delete(entrenador);
    }
}