package org.una.municipalidad.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Usuarios implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "Usuario", length = 100)
    private String Usuario;

    @Column(length = 100, name = "Clave")
    private String Clave;


    @Column
    private boolean estado;

    //@ManyToOne
    //@JoinColumn(name="departamentos_id")
    //private Long departamento;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
    }

    @PreUpdate
    public void preUpdate() {
       // fechaModificacion = new Date();
    }
}
