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
public class Cobros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cobros_periodo", length = 100)
    private String cobros_Periodo;

    @Column(name = "cobros_monto")
    private String cobros_Monto;

    @Column(name = "cobros_fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date cobros_Fecha_Creacion;

    @Column(name = "cobros_fecha_vencimiento", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date cobros_Fecha_Vencimiento;

    @Column
    private boolean Estado;

    @Column(name = "cobros_fecha_pago", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date cobros_Fecha_Pago;

    @JoinColumn(name="licencias_comerciales_id")
    private Licencias_Comerciales licenciacomerciales;

    /*@ManyToOne
    @JoinColumn(name="facturas_id")
    private Facturas facturas;

    @ManyToOne
    @JoinColumn(name="tipo_cobros_id")
    private Cobros cobros;*/

    @ManyToOne
    @JoinColumn(name="locales_comerciales_id")
    private Locales_Mercado localescomerciales;

    @ManyToOne
    @JoinColumn(name="propiedades_id")
    private Propiedades propiedades;
}
