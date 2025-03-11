package com.proyecto.domain;

@Data
@Entity
@Table(name= "entrenador")
public class Entrenador implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrenador")
    
    private long idEntrenador; //Cédula
    private String nombreEntrenador;
    private String correoEntrenador;
    private String telefonoEntrenador;
    private String especialidadEntrenador;
    
    public Entrenador() {
    }
    
    public Entrenador(long idEntrenador, String nombreEntrenador, String correoEntrenador, String telefonoEntrenador, String especialidadEntrenador) {
        this.idEntrenador = idEntrenador;
        this.nombreEntrenador = nombreEntrenador;
        this.correoEntrenador = correoEntrenador;
        this.telefonoEntrenador = telefonoEntrenador;
        this.especialidadEntrenador = especialidadEntrenador;
    }
}
