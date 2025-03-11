package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "estado_membresia")
public class EstadoMembresia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_membresia")
    private long idEstadoMembresia;
    private String nombre;

    public EstadoMembresia() {}

    public EstadoMembresia(String nombre) {
        this.nombre = nombre;
    }
}
