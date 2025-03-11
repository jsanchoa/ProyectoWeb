package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "cliente")
public class Cliente implements Serializable{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long idCliente; //Cédula
    private String cedula;
    private String nombre;
    private String correo;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_membresia")
    private Membresia membresia;

    @ManyToOne
    @JoinColumn(name = "id_estado_membresia")
    private EstadoMembresia estadoMembresia;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
    
    public Cliente() {
    }
    
    public Cliente(String cedula, String nombre, String correo, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }
}