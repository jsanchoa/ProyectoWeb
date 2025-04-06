package com.proyecto.service;

import com.proyecto.domain.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsuarioService {

    @Transactional(readOnly = true)
    public List<Usuario> findByTipoUsuario_IdTipoUsuario(int tipoUsuario);

    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios(boolean activo);
    
    public Usuario getUsuario(Usuario usuario);
    
    public void save(Usuario usuario);

    public void delete(Usuario usuario);
}
