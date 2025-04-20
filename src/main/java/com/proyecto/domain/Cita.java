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

    @OneToMany(mappedBy = "cita", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntrenamientoCita> entrenamientoCitas;
    
    @Transient //Solamente se almacena en memoria y no desde la bdd
    private String tipoRutinaNombre;
    
    @Transient 
    private Long entrenamientoId;
    
    public Entrenamiento getEntrenamiento() {
        if (entrenamientoCitas != null && !entrenamientoCitas.isEmpty()) {
            return entrenamientoCitas.get(0).getEntrenamiento();
        }
        return null;
    }

    public Cita() {
    }

}
