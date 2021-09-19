package org.una.municipalidad.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "permisos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Permisos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_permiso", length = 100)
    private String nombrePermiso;

    @Column(name = "tipo_permiso", length = 200)
    private String tipoPermiso;

    @Column(name = "descripcion_permiso", length = 200)
    private String descripcionPermiso;

    @Column(name = "categoria_permiso", length = 200)
    private String categoriaPermiso;

    private static final long serialVersionUID = 1L;

}
