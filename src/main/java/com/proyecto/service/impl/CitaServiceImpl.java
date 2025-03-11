/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyecto.service.impl;
import com.proyecto.dao.CitaDao;
import com.proyecto.domain.Cita;
import com.proyecto.service.CitaService;
import java.util.List;        
import com.proyecto.dao.CitaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author naoal
 */
public class CitaServiceImpl implements CitaService{
    @Autowired
    private CitaDao citaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Cita> getCita(boolean activos) {
        var lista = citaDao.findAll();
        if (activos) {
            lista.removeIf(e -> e.getEstado().getIdEstado() == 2);
        }
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
    }

    @Override
    @Transactional
    public void delete(Cita cita) {
        citaDao.delete(cita);
    }
    
}
