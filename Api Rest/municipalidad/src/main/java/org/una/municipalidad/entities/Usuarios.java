package org.una.municipalidad.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Usuarios implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_usuario", length = 100)
    private String nombreUsuario;

    @Column(length = 100, name = "clave_encriptado")
    private String claveEncriptado;

    @Column(length = 25, unique = true)
    private String cedula;

    @ManyToOne
    @JoinColumn(name="roles_id")
    private Roles roles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<BitacoraCambios> bitacoraCambios = new ArrayList<>();

    @Column
    private boolean estado;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
    }

}
