package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "especialidad")
public class Especialidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private int idEspecialidad;
    private String nombre;

    public Especialidad() {
    }

    public Especialidad(String nombre) {
        this.nombre = nombre;
    }


}
