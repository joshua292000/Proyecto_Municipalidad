package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bitacora_cambios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BitacoraCambios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bitacora_tabla", length = 100)
    private String bitacora_Tabla;

    @Column(name = "bitacora_descripcion", length = 500)
    private String bitacora_Descripcion;

    @Column(name = "bitacora_usuario", length = 100)
    private String bitacora_Usuario;

    @Column(name = "bitacora_fecha", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date bitacora_Fecha;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuarios usuario;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        bitacora_Fecha = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        bitacora_Fecha = new Date();
    }
}
