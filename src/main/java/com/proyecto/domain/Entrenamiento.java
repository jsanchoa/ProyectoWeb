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

    private long idEntrenamiento;
    private long idTipoEntrenamiento;
    private long idHorario; //Ejemplo: Lunes (9:00a.m - 11:00a.m)
    private int capacidadEntrenamiento;
    private long idEntrenador; //FK pero toma el valor del formulario de registro, el entrenador debe de estar registrado
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_entrenamiento")
    private TipoEntrenamiento tipoEntrenamiento;

    @ManyToOne
    @JoinColumn(name = "id_horario")
    private Horario horario;
    
    @ManyToOne
    @JoinColumn(name = "id_entrenador")
    private Entrenador entrenador;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
    
    public Entrenamiento() {
    }
    
    public Entrenamiento(long idTipoEntrenamiento, long idHorario, int capacidadEntrenamiento, long idEntrenador) {
        this.idTipoEntrenamiento = idTipoEntrenamiento;
        this.idHorario = idHorario;
        this.capacidadEntrenamiento = capacidadEntrenamiento;
        this.idEntrenador = idEntrenador; 
    }
    
}