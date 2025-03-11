package com.proyecto.domain;

@Data
@Entity
@Table(name= "cliente")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    
    private long idCliente; //Cédula
    private String nombreCliente;
    private String correoCliente;
    private String telefonoCliente;
    private String tipoMembresia;
    private boolean estadoMembresia;
    
    public Cliente() {
    }
    
    public Cliente(long idCliente, String nombreCliente, String correoCliente, String telefonoCliente, String tipoMembresia, boolean estadoMembresia) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
        this.telefonoCliente = telefonoCliente;
        this.tipoMembresia = tipoMembresia;
        this.estadoMembresia = estadoMembresia;
    }
}