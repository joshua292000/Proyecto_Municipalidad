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
    private String parametrosLlaves;

    @Column(name = "parametros_valor", length = 150)
    private String parametrosValor;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {

    }

    @PreUpdate
    public void preUpdate() {

    }

}
