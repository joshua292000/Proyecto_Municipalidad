package org.una.municipalidad.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Contribuyentes_Locales_Comerciales")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contribuyentes_Locales_Mercado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "porcentaje_locales")
    private Long porcentajeLocales;

    @ManyToOne
    @JoinColumn(name="contribuyente_id")
    private Contribuyentes contribuyente;

    @ManyToOne
    @JoinColumn(name="locales_id")
    private Locales_Mercado localesmercado;

    private static final long serialVersionUID = 1L;
}
