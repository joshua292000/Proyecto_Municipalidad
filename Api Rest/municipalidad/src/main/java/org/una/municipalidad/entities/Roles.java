package org.una.municipalidad.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Roles implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_rol", length = 100)
    private String nombreRol;

    @Column(name = "descripcion_rol", length = 200)
    private String descripcionRol;


    @Column
    private boolean estado;


    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
    }
}