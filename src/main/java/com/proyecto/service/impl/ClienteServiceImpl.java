package com.proyecto.service.impl;
package com.proyecto.dao.ClienteDao;
package com.proyecto.domain.Cliente;
package com.proyecto.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getCliente(boolean activos) {
        var listaClientes = clienteDao.findAll();
        if (activos) {
            listaClientes.removeIf(e -> !e.isActivo());
        }
        return listaClientes;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(acceso.getIdCliente()).orElse(null);
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