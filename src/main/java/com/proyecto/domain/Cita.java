package com.proyecto.domain;

@Data
@Entity
@Table(name= "cita")
public class Cita implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    
    private long idCita;
    private long idClienteCita; //FK pero toma el valor del formulario de registro, el cliente debe de estar registrado y tener una membresia activa
    //Exportar nombre, correo y telefono del cliente con id y auto-rellenar campos del formulario
    private long idEntrenamientoCita; //FK pero toma el valor del formulario de registro, con id para hacer un dropdown de los entrenamientos disponibles
    private String horarioCita; //FK pero toma el valor del formulario de registro, de acuerdo con los horarios disponibles para el entrenamiento seleccionado
    
    public Cita() {
        
    }
    
    public Cita(long idCita, long idClienteCita, long idEntrenamientoCita, String horarioCita) {
        this.idCita = idCita;
        this.idClienteCita = idClienteCita;
        this.idEntrenamientoCita = idEntrenamientoCita;
        this.horarioCita = horarioCita;
    }
}
