package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "tipo_entrenamiento")
public class TipoEntrenamiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_entrenamiento")
    private int idTipoEntrenamiento;
    private String nombre;

    public TipoEntrenamiento() {
    }

    public TipoEntrenamiento(String nombre) {
        this.nombre = nombre;
    }

}