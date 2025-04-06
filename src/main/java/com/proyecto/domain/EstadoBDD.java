package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "EstadosBDD")
public class EstadoBDD implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadoBDD")
    private long idEstado;
    private String nombre;

    public EstadoBDD() {}

    public EstadoBDD(String nombre) {
        this.nombre = nombre;
    }
}