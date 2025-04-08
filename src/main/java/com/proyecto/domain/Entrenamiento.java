package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
    private TipoRutina tipoRutina;

    @Column(name = "capacidad")
    private int capacidadEntrenamiento;

    @ManyToOne
    @JoinColumn(name = "id_horario")
    private Horario horario;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario entrenador;

    @ManyToOne
    @JoinColumn(name = "id_estadoInv")
    private EstadoInventario estadoInventario;

    @ManyToOne
    @JoinColumn(name = "id_estadoBDD")
    private EstadoBDD estadoBDD;

    @ManyToMany(mappedBy = "entrenamientos")
    private List<Cita> citas;
    
    public Entrenamiento() {
    }
    
    public Entrenamiento(int capacidadEntrenamiento) {
        this.capacidadEntrenamiento = capacidadEntrenamiento;
    }
    
}