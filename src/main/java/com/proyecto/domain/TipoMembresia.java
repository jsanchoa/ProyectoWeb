package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "TiposMembresia")
public class TipoMembresia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipoMembresia")
    private Long idTipoMembresia;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_estadoBDD")
    private EstadoBDD estadoBDD;

    private int cantidadDias;

    public TipoMembresia() {}

    public TipoMembresia(String nombre, int cantidadDias) {
        this.nombre = nombre;
        this.cantidadDias = cantidadDias;
    }
}
