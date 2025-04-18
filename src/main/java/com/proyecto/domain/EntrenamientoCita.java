package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EntrenamientosCitas")
public class EntrenamientoCita {

    @EmbeddedId
    private EntrenamientoCitaId id;

    @ManyToOne
    @MapsId("entrenamiento")
    @JoinColumn(name = "id_entrenamiento")
    private Entrenamiento entrenamiento;

    @ManyToOne
    @MapsId("cita")
    @JoinColumn(name = "id_cita")
    private Cita cita;

    public EntrenamientoCita() {}

    public EntrenamientoCita(Entrenamiento entrenamiento, Cita cita) {
        this.entrenamiento = entrenamiento;
        this.cita = cita;
        this.id = new EntrenamientoCitaId(entrenamiento.getIdEntrenamiento(), cita.getIdCita());
    }
}