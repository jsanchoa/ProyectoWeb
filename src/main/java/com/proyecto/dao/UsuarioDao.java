package com.proyecto.dao;
import com.proyecto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    public List<Usuario> findByTipoUsuario_IdTipoUsuario(int tipoUsuario);

}
