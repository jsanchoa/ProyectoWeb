
package com.proyecto.service;

import com.proyecto.domain.Usuario;
import java.util.List;

public interface AccesoService {
    
List<Usuario> buscarClientesPorNombre(String nombre, int idTipoUsuario);

Usuario buscarClientePorId(Long id);

}
