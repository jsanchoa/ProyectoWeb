package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "Roles")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol")
    private Long idRol;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_estadoBDD")
    private EstadoBDD estadoBDD;

    public Rol() {}

    public Rol(String nombre) {
        this.nombre = nombre;
    }
}
