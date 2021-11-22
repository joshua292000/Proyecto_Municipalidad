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
    private int FechasCobrosPeriodo;

    @Column(name = "fechasCobros_Fecha1", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date FechasCobrosFecha1;

    @Column(name = "fechasCobros_Fecha2", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date FechasCobrosFecha2;

    @Column(name = "fechasCobros_Fecha3", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date FechasCobrosFecha3;

    @Column(name = "fechasCobros_Fecha4", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date FechasCobrosFecha4;

    @Column(name = "fechasCobros_Fecha5", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date FechasCobrosFecha5;

    @Column(name = "fechasCobros_Fecha6", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date FechasCobrosFecha6;

    @Column(name = "fechasCobros_Fecha7", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date FechasCobrosFecha7;

    @Column(name = "fechasCobros_Fecha8", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date FechasCobrosFecha8;

    @Column(name = "fechasCobros_Fecha9", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date FechasCobrosFecha9;

    @Column(name = "fechasCobros_Fecha10", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date FechasCobrosFecha10;

    @Column(name = "fechasCobros_Fecha11", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date FechasCobrosFecha11;

    @Column(name = "fechasCobros_Fecha12", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date FechasCobrosFecha12;

    private static final long serialVersionUID = 1L;
}
