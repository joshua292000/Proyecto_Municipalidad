package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TipoCobros")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TipoCobros implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_tipoCobro", length = 100)
    private String nombreTipoCobro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipocobros")
    private List<Cobros> cobros = new ArrayList<>();
}
