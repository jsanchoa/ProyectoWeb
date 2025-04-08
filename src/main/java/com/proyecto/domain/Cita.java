package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name= "Citas")
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long idCita;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_estadoBDD")
    private EstadoBDD estadoBDD;

    @ManyToMany
    @JoinTable(
            name = "EntrenamientosCitas",
            joinColumns = @JoinColumn(name = "id_cita"),
            inverseJoinColumns = @JoinColumn(name = "id_entrenamiento")
    )
    private List<Entrenamiento> entrenamientos;

    public Cita() {
    }

}
