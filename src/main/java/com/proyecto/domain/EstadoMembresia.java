package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "EstadosMembresia")
public class EstadoMembresia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadoMemb")
    private long idEstadoMembresia;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_estadoBDD")
    private EstadoBDD estadoBDD;

    public EstadoMembresia() {}

    public EstadoMembresia(String nombre) {
        this.nombre = nombre;
    }
}
