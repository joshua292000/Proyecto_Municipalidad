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
@Builder
public class BitacoraCambios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bitacora_tabla", length = 100)
    private String bitacoraTabla;

    @Column(name = "bitacora_descripcion", length = 500)
    private String bitacoraDescripcion;

    @Column(name = "bitacora_usuario", length = 100)
    private String bitacoraUsuario;

    @Column(name = "bitacora_fecha", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date bitacoraFecha;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuarios usuarios;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        bitacoraFecha = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        bitacoraFecha = new Date();
    }
}
