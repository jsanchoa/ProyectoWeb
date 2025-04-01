package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "entrenamiento")
public class Entrenamiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrenamiento")
    private Long idEntrenamiento;

    @Column(name = "capacidad")
    private int capacidadEntrenamiento;
    
    @ManyToOne
    @JoinColumn(name = "id_entrenador")
    private Entrenador entrenador;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
    
    public Entrenamiento() {
    }
    
    public Entrenamiento(int capacidadEntrenamiento) {
        this.capacidadEntrenamiento = capacidadEntrenamiento;
    }
    
}