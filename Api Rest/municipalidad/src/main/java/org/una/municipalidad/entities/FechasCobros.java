package org.una.municipalidad.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fechasCobros")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FechasCobros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechasCobros_Impuesto", length = 100)
    private String FechasCobrosImpuestos;

    @Column(name = "fechasCobros_Periodo")
    private Long FechasCobrosPeriodo;

    @Column(name = "fechasCobros_Fecha1", updatable = true)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date FechasCobrosFecha1;

    @Column(name = "fechasCobros_Fecha2", updatable = true)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date FechasCobrosFecha2;

    @Column(name = "fechasCobros_Fecha3", updatable = true)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date FechasCobrosFecha3;

    @Column(name = "fechasCobros_Fecha4", updatable = true)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date FechasCobrosFecha4;

    @Column(name = "fechasCobros_Fecha5", updatable = true)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date FechasCobrosFecha5;

    @Column(name = "fechasCobros_Fecha6", updatable = true)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date FechasCobrosFecha6;

    @Column(name = "fechasCobros_Fecha7", updatable = true)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date FechasCobrosFecha7;

    @Column(name = "fechasCobros_Fecha8", updatable = true)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date FechasCobrosFecha8;

    @Column(name = "fechasCobros_Fecha9", updatable = true)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date FechasCobrosFecha9;

    @Column(name = "fechasCobros_Fecha10", updatable = true)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date FechasCobrosFecha10;

    @Column(name = "fechasCobros_Fecha11", updatable = true)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date FechasCobrosFecha11;

    @Column(name = "fechasCobros_Fecha12", updatable = true)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date FechasCobrosFecha12;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {

    }

    @PreUpdate
    public void preUpdate() {

    }
}
