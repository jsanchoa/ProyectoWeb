package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "entrenamientos")
public class Entrenamiento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrenamiento")

    private long idEntrenamiento;
    private String tipoEntrenamiento;
    private String horarioEntrenamiento; //Ejemplo: Lunes (9:00a.m - 11:00a.m)
    private int capacidadEntrenamiento;
    private String nombreEntrenadorEntrenamiento; //FK pero toma el valor del formulario de registro, el entrenador debe de estar registrado
    
    public Entrenamiento() {
    }
    
    public Entrenamiento(long idEntrenamiento, String tipoEntrenamiento, String horarioEntrenamiento, int capacidadEntrenamiento, String nombreEntrenadorEntrenamiento) {
        this.idEntrenamiento = idEntrenamiento;
        this.tipoEntrenamiento = tipoEntrenamiento;
        this.horarioEntrenamiento = horarioEntrenamiento;
        this.capacidadEntrenamiento = capacidadEntrenamiento;
        this.nombreEntrenadorEntrenamiento = nombreEntrenadorEntrenamiento; 
    }
    
}