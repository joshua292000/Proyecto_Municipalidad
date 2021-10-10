package org.una.municipalidad.entities;

import lombok.*;

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
    private Long cobrosMonto;

    @Column(name = "cobros_fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date cobrosFechaCreacion;

    @Column(name = "cobros_fecha_vencimiento", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date cobrosFechaVencimiento;

    @Column
    private boolean Estado;

    @Column(name = "cobros_fecha_pago", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date cobrosFechaPago;

    @JoinColumn(name="licencias_comerciales_id")
    private Licencias_Comerciales licenciacomercial;

    /*@ManyToOne
    @JoinColumn(name="facturas_id")
    private Facturas facturas;

    @ManyToOne
    @JoinColumn(name="tipo_cobros_id")
    private TipoCobros tcobros;*/

    @ManyToOne
    @JoinColumn(name="locales_mercado_id")
    private Locales_Mercado localesmercado;

    @ManyToOne
    @JoinColumn(name="propiedades_id")
    private Propiedades propiedades;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        Estado=true;
        cobrosFechaCreacion = new Date();
        cobrosFechaVencimiento = new Date();
        cobrosFechaPago = new Date();
    }

    @PreUpdate
    public void preUpdate() {

    }
}