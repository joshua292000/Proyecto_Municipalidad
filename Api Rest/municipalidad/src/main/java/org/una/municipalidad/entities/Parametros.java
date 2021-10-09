package org.una.municipalidad.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "parametros")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Parametros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "paramentros_llaves", length = 100)
    private String parametros_Llaves;

    @Column(name = "parametros_valor", length = 150)
    private String parametros_Valor;

    @PrePersist
    public void prePersist() {

    }

    @PreUpdate
    public void preUpdate() {

    }

}
