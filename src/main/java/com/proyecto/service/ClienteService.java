package com.proyecto.service;

import com.proyecto.domain.Cliente;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClienteService {

    @Transactional(readOnly = true)
    public List<Cliente> getClientes(boolean activo);
    
    public Cliente getCliente(Cliente cliente);
    
    public void save(Cliente cliente);

    public void delete(Cliente cliente);
}
