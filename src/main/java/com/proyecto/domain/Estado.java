package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "estado")
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private long idEstado;
    private String nombre;

    public Estado() {}

    public Estado(String nombre) {
        this.nombre = nombre;
    }
}