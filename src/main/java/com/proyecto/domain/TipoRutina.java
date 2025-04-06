package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "TiposRutinas")
public class TipoRutina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoRutina")
    private int idTipoEntrenamiento;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_estadoBDD")
    private EstadoBDD estadoBDD;

    public TipoRutina() {
    }

    public TipoRutina(String nombre) {
        this.nombre = nombre;
    }

}