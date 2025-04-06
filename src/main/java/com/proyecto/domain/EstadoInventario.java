package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "EstadosInventario")
public class EstadoInventario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadoInv")
    private long idEstadoInv;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_estadoBDD")
    private EstadoBDD estadoBDD;

    public EstadoInventario() {}

    public EstadoInventario(String nombre) {
        this.nombre = nombre;
    }
}
