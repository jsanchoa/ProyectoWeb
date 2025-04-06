package com.proyecto.service.impl;
import com.proyecto.dao.UsuarioDao;
import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.Usuario;
import com.proyecto.service.UsuarioService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findByTipoUsuario_IdTipoUsuario(int tipoUsuario) {
        return usuarioDao.findByTipoUsuario_IdTipoUsuario(tipoUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios(boolean activos) {
        var lista = usuarioDao.findAll();
        if (activos) {
            lista.removeIf(e -> e.getEstadoBDD().getIdEstado() != 2);
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}
