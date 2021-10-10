package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contribuyentes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Contribuyentes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_contribuyente", length = 100)
    private String nombreContribuyente;

    @Column(name = "apellido_contribuyente", length = 100)
    private String apellidoContribuyente;

    @Column(name = "cedula_contribuyente")
    private Long cedulaContribuyente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contribuyente")
    private List<Contribuyentes_Locales_Mercado> contribuyentes_locales_mercados = new ArrayList<>();

   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "contribuyente")
   // private List<Contribuyentes_Propiedades> contribuyentes_Propiedades = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contribuyente")
    private List<Contribuyentes_Licencias_Comerciales> contribuyentes_licencias_comerciales = new ArrayList<>();
}
