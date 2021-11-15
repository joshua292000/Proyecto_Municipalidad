package org.una.municipalidad.entities;

import lombok.*;
import org.springframework.data.jpa.repository.query.Procedure;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cobros")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Cobros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cobros_periodo", length = 100)
    private String cobrosPeriodo;

    @Column(name = "cobros_monto")
    private double cobrosMonto;

    @Column(name = "cobros_fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date cobrosFechaCreacion;

    @Column(name = "cobros_fecha_vencimiento", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date cobrosFechaVencimiento;

    @Column(name = "estado", length = 100)
    private String estado;

    @Column(name = "cobros_fecha_pago", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date cobrosFechaPago;


    @ManyToOne
    @JoinColumn(name="facturas_id")
    private Facturas facturas;

   @ManyToOne
    @JoinColumn(name="tipo_cobros_id")
    private TipoCobros tipocobros;

    @ManyToOne
    @JoinColumn(name="locales_mercado_id")
    private Locales_Mercado localesmercado;

    @ManyToOne
    @JoinColumn(name="licencias_comerciales_id")
    private Licencias_Comerciales licenciacomercial;

    @ManyToOne
    @JoinColumn(name="propiedades_id")
    private Propiedades propiedades;

    private static final long serialVersionUID = 1L;

    /*@Procedure
    "CREATE DEFINER=`Kevin`@`localhost` PROCEDURE `Cobrosmasivos`(IN `FechaInicio` DATE,IN `FechaFin` DATE)"+
            "LANGUAGE SQL NOT DETERMINISTIC CONTAINS SQL SQL SECURITY DEFINER COMMENT '' BEGIN "+
            "UPDATE cobros SET estado = 'Pagado' WHERE cobros_fecha_creacion Between FechaInicio AND FechaFin AND estado='Pendiente'; END "
    */@PrePersist
    public void prePersist() {
        cobrosFechaCreacion = new Date();
        cobrosFechaVencimiento = new Date();
        cobrosFechaPago = new Date();
    }

    @PreUpdate
    public void preUpdate() {

    }
}
