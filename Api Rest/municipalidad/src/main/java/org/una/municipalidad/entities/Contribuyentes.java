package org.una.municipalidad.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Contribuyentes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contribuyentes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_contribuyente", length = 100)
    private String nombreContribuyente;

    @Column(name = "apellido_contribuyente", length = 100)
    private String apellidoContribuyente;

    @Column(name = "cedula_contribuyente")
    private Long cedulaContribuyente;

}
