package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propiedades")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Propiedades implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propiedades_id;

    @Column(name = "propiedad_provincia", length = 100)
    private String propiedadProvincia;

    @Column(name = "propiedad_canton ", length = 100)
    private String propiedadCanton;

    @Column(name = "propiedad_distrito", length = 100)
    private String propiedadDistrito;

    @Column(name = "propiedad_direccion", length = 100)
    private String propiedadDireccion;

    @Column(name = "propiedad_geolocalizacion", length = 100)
    private String propiedadGeolocalizacion;

    @Column(name = "propiedad_area")
    private Long propiedadArea;

    @Column(name = "propiedad_plano", length = 100)
    private String propiedadPlano;

    @Column(name = "propiedad_metros_frente")
    private Long propiedadAMetrosFrente;

    @Column(name = "propiedad_valor_terreno")
    private Long propiedadValorTerreno;

    @Column(name = "propiedad_valor_construccion")
    private Long propiedadValorConstruccion;

    @Column(name = "propiedad_otros_valores")
    private Long propiedadOtrosValores;

    @Column
    private boolean PerteneceEstado;

    @Column(name = "propiedad_zona", length = 100)
    private String propiedadZona;

    @Column
    private boolean Estado;

    @Column(name = "propiedad_fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date propiedad_fecha_Registro;

    @Column(name = "propiedad_ultima_actualizacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date propiedad_ultima_Actualizacion;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propiedades")
    private List<Cobros> cobros = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propiedades")
    private List<Contribuyentes_Propiedades> contribuyentes_propiedades = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        Estado=true;
        propiedad_fecha_Registro = new Date();
        propiedad_ultima_Actualizacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        propiedad_ultima_Actualizacion = new Date();
    }

}
