package com.proyecto.service;
package com.proyecto.domain.Cliente;
import java.util.List;

public class ClienteService {
    
    public List<Cliente> getCliente();
    
    public Cliente getCliente(Cliente cliente);
    
    public void save(Cliente cliente);

    public void delete(Cliente cliente);
}
