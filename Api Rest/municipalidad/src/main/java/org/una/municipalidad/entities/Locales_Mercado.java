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
//@Builder
public class Locales_Mercado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_local", length = 100)
    private String nombreLocal;

    @Column(name = "ubicacion_local", length = 100)
    private String ubicacionLocal;

    @Column(name = "telefono_local")
    private Long telefonoLocal;

    @Column(name = "correo_local", length = 100)
    private String correoLocal;

    @Column(name = "estado", length = 100)
    private String estado;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localesmercado")
    private List<Contribuyentes_Locales_Mercado> contribuyentes_locales_mercados = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        fechaRegistrolocal = new Date();
        ultima_Actualizacionlocal = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        ultima_Actualizacionlocal = new Date();
    }



}
