package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Facturas;

import java.util.Date;
import java.util.Optional;

@Repository
public interface FacturasRepository extends JpaRepository<Facturas, Long> {
    public Optional<Facturas> findByFechaPago(Date fechapago);
}
