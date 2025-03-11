package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "entrenador")
public class Entrenador implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrenador")
    private Long idEntrenador; //Cédula
    private String cedula;
    private String nombre;
    private String correo;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
    
    public Entrenador() {
    }
    
    public Entrenador(String cedula, String nombre, String correo, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }
}
