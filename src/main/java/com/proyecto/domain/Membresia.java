package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table(name= "Membresias")
public class Membresia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_membresia")
    private Long idMembresia;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;

    @ManyToOne
    @JoinColumn(name = "id_tipoMembresia")
    private TipoMembresia tipoMembresia;

    @ManyToOne
    @JoinColumn(name = "id_estadoMemb")
    private EstadoMembresia estadoMembresia;

    @ManyToOne
    @JoinColumn(name = "id_estadoBDD")
    private EstadoBDD estadoBDD;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFinal;

    
    public Membresia() {
    }
    
    public Membresia(LocalDate fechaInicio, LocalDate fechaFinal) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }
}
