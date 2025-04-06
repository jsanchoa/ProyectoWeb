package com.proyecto.service.impl;
import com.proyecto.dao.EstadoMembresiaDao;
import com.proyecto.domain.EstadoMembresia;
import com.proyecto.service.EstadoMembresiaService;
import java.util.List;
import com.proyecto.dao.EstadoMembresiaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoMembresiaServiceImpl implements EstadoMembresiaService{
    @Autowired
    private EstadoMembresiaDao estadoMembresiaDao;

    @Override
    @Transactional(readOnly = true)
    public List<EstadoMembresia> getListaEstadoMembresias() {
        var lista = estadoMembresiaDao.findAll();
        return lista;
    }

    @Override
    public EstadoMembresia getEstadoMembresia(int idEstadoMembresia) {
        return estadoMembresiaDao.findByidEstadoMembresia(idEstadoMembresia);
    }
}