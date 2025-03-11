package com.proyecto.service.impl;
package com.proyecto.dao.CitaDao;
package com.proyecto.domain.Cita;
package com.proyecto.service.CitaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitaServiceImpl implements CitaService{

    @Autowired
    private CitaDao citaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> getCita(boolean activos) {
        var listaCitas = citaDao.findAll();
        if (activos) {
            listaCitas.removeIf(e -> !e.isActivo());
        }
        return listaCitas;
    }

    @Override
    @Transactional(readOnly = true)
    public Cita getCita(Cita cita) {
        return citaDao.findById(acceso.getIdCita()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cita cita) {
        citaDao.save(cita);
    }

    @Override
    @Transactional
    public void delete(Cita cita) {
        citaDao.delete(cita);
    }
}
