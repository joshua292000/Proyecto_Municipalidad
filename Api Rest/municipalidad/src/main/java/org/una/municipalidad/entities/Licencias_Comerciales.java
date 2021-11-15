package org.una.municipalidad.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "licencias_comerciales")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Licencias_Comerciales implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_comercio", length = 100)
    private String nombreComercio;

    @Column(name = "telefono_comercio")
    private Long telefonoComercio;

    @Column(name = "correo_comercio", length = 100)
    private String correoComercio;

    @Column(name = "distrito_comercio", length = 100)
    private String distritoComercio;

    @Column(name = "fecha_registrocomercio", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistrocomercio;

    @Column(name = "ultima_actualizacioncomercio", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date ultima_Actualizacioncomercio;

    @Column(name = "codigo_comercio", length = 100)
    private String codigoComercio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "licenciacomercial")
    private List<Declaraciones> declaraciones = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "licenciascomerciales")
    private List<Cobros> cobros = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "licenciascomerciales")
    private List<Contribuyentes_Licencias_Comerciales> contribuyentes_licencias_comerciales = new ArrayList<>();


    @Column(name = "estado", length = 100)
    private String estado;


    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {

        fechaRegistrocomercio = new Date();
        ultima_Actualizacioncomercio = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        ultima_Actualizacioncomercio = new Date();
    }

}
