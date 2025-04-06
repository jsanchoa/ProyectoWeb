package com.proyecto.dao;

import com.proyecto.domain.Rol;
import com.proyecto.domain.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioDao extends JpaRepository<TipoUsuario, Long> {

    public TipoUsuario findByidTipoUsuario(Long idTipoUsuario);

}
