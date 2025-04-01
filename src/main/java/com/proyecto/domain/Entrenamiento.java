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

    private int capacidadEntrenamiento;
    
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
    
    public Entrenamiento(int capacidadEntrenamiento) {
        this.capacidadEntrenamiento = capacidadEntrenamiento;
    }
    
}