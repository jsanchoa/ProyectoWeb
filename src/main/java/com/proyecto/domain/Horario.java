package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;

@Data
@Entity
@Table(name= "Horarios")
public class Horario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private int idHorario;

    private LocalTime horaInicio;
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "id_estadoBDD")
    private EstadoBDD estadoBDD;

    public Horario() {
    }

    public Horario(LocalTime horaInicio, LocalTime horaFin) {}



}

