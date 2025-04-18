package com.proyecto.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class EntrenamientoCitaId implements Serializable {

    private Long entrenamiento;
    private Long cita;

    public EntrenamientoCitaId() {}

    public EntrenamientoCitaId(Long entrenamiento, Long cita) {
        this.entrenamiento = entrenamiento;
        this.cita = cita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntrenamientoCitaId)) return false;
        EntrenamientoCitaId that = (EntrenamientoCitaId) o;
        return Objects.equals(entrenamiento, that.entrenamiento) &&
                Objects.equals(cita, that.cita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entrenamiento, cita);
    }
}