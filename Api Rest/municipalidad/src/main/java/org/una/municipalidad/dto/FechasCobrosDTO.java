package org.una.municipalidad.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FechasCobrosDTO {
    private Long id;
    private String FechasCobrosImpuestos;
    private Long FechasCobrosPeriodo;
    private Date FechasCobrosFecha1;
    private Date FechasCobrosFecha2;
    private Date FechasCobrosFecha3;
    private Date FechasCobrosFecha4;
    private Date FechasCobrosFecha5;
    private Date FechasCobrosFecha6;
    private Date FechasCobrosFecha7;
    private Date FechasCobrosFecha8;
    private Date FechasCobrosFecha9;
    private Date FechasCobrosFecha10;
    private Date FechasCobrosFecha11;
    private Date FechasCobrosFecha12;
}
