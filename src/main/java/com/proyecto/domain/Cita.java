package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name= "cita")
public class Cita implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    
    private long idCita;
    private long idCliente; //FK pero toma el valor del formulario de registro, el cliente debe de estar registrado y tener una membresia activa
    //Exportar nombre, correo y telefono del cliente con id y auto-rellenar campos del formulario
    private long idEntrenamiento; //FK pero toma el valor del formulario de registro, con id para hacer un dropdown de los entrenamientos disponibles
    
    @ManyToMany
    @JoinColumn(name = "id_entrenamiento")
    private Entrenamiento entrenamiento;
    
    @ManyToMany
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    public Cita() {
        
    }
    
    public Cita(long idCliente, long idEntrenamiento) {
        this.idCliente = idCliente;
        this.idEntrenamiento = idEntrenamiento;
    }
}
