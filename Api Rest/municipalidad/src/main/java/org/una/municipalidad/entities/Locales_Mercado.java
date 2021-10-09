package org.una.municipalidad.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "locales_mercado")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Locales_Mercado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_local", length = 100)
    private String nombreComercio;

    @Column(name = "telefono_local")
    private Long telefonoComercio;

    @Column(name = "correo_local", length = 100)
    private String correoComercio;

    @Column
    private boolean estado;

    @Column(name = "Monto_Alquiler_Local")
    private Long Monto_Alquiler_Local;

    @Column(name = "fecha_registrolocal", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistrolocal;

    @Column(name = "ultima_actualizacionlocal", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date ultima_Actualizacionlocal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localesmercado")
    private List<Cobros> cobros = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
        fechaRegistrolocal = new Date();
        ultima_Actualizacionlocal = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        ultima_Actualizacionlocal = new Date();
    }



}
