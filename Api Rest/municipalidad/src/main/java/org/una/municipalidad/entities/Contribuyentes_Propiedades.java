package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "contribuyentes_propiedades")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Contribuyentes_Propiedades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "porcentaje_propiedad")
    private Long porcentajePropiedad;

    @ManyToOne
    @JoinColumn(name="contribuyente_id")
    private Contribuyentes contribuyente;

    @ManyToOne
    @JoinColumn(name="propiedades_id")
    private Propiedades propiedades;

    private static final long serialVersionUID = 1L;
}
