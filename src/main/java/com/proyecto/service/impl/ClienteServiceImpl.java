package com.proyecto.service.impl;
import com.proyecto.dao.ClienteDao;
import com.proyecto.domain.Cliente;
import com.proyecto.service.ClienteService;
import java.util.List;
import com.proyecto.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteDao clienteDao;


    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getCliente() {
        var lista = clienteDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
}
