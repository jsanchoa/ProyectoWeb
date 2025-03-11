package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "membresia")
public class Membresia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_membresia")
    private Long idMembresia;
    private String nombre;
    
    public Membresia() {
    }
    
    public Membresia(String nombre) {
        this.nombre = nombre;
    }
}
