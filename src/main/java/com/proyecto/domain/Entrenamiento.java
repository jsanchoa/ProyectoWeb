package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "Entrenamientos")
public class Entrenamiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrenamiento")
    private Long idEntrenamiento;

    @ManyToOne
    @JoinColumn(name = "id_tipoRutina")
    private TipoRutina idTipoRutina;

    @Column(name = "capacidad")
    private int capacidadEntrenamiento;

    @ManyToOne
    @JoinColumn(name = "id_horario")
    private Horario horario;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_estadoInv")
    private EstadoInventario estadoinv;

    @ManyToOne
    @JoinColumn(name = "id_estadoBDD")
    private EstadoBDD estado;
    
    public Entrenamiento() {
    }
    
    public Entrenamiento(int capacidadEntrenamiento) {
        this.capacidadEntrenamiento = capacidadEntrenamiento;
    }
    
}