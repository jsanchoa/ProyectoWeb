package com.proyecto.service.impl;
import com.proyecto.dao.MembresiaDao;
import com.proyecto.domain.Cita;
import com.proyecto.domain.Membresia;
import com.proyecto.service.MembresiaService;
import java.util.List;
import com.proyecto.dao.MembresiaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MembresiaServiceImpl implements MembresiaService{
    @Autowired
    private MembresiaDao membresiaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Membresia> getListaMembresias() {
        var lista = membresiaDao.findAll();
        return lista;
    }

    @Override
    public void save(Membresia membresia) {
        membresiaDao.save(membresia);
    }

    @Override
    public void delete(Membresia membresia) {
        membresiaDao.delete(membresia);
    }
}
