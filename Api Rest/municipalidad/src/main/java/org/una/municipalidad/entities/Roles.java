package org.una.municipalidad.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private List<Usuarios> usuarios = new ArrayList<>();

    @Column
    private boolean estado;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
    }
}
