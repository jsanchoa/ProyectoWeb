package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "TiposUsuarios")
public class TipoUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoUsuario")
    private Long idTipoUsuario;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_estadoBDD")
    private EstadoBDD estadoBDD;

    public TipoUsuario() {}

    public TipoUsuario(String nombre) {
        this.nombre = nombre;
    }
}
