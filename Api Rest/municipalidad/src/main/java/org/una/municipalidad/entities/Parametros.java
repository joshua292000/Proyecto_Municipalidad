package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "parametros")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Parametros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "llave_parametro", length = 100)
    private String llaveParametro;

    @Column(name = "valor_parametro", length = 150)
    private String valorParametro;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {

    }

    @PreUpdate
    public void preUpdate() {

    }

}
