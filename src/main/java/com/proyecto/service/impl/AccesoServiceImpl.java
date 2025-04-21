
package com.proyecto.service.impl;

import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.Usuario;
import com.proyecto.service.AccesoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccesoServiceImpl implements AccesoService {

@Autowired
private UsuarioDao usuarioDao;

@Override
public List<Usuario> buscarClientesPorNombre(String nombre, int idTipoUsuario) {
    return usuarioDao.findByNombreAndTipoUsuario_IdTipoUsuario(nombre, idTipoUsuario);
 }

@Override
public Usuario buscarClientePorId(Long id) {
    return usuarioDao.findById(id).orElse(null);
}
}