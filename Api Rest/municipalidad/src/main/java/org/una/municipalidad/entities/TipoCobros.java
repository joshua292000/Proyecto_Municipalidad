package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
}
