package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Cobros;
import org.una.municipalidad.entities.Contribuyentes;

import java.util.List;
import java.util.Optional;


@Repository
public interface ContribuyentesRepository  extends JpaRepository<Contribuyentes, Long> {
    public Optional<Contribuyentes> findByNombreContribuyente(String nombreContribuyente);
    public Optional<Contribuyentes> findByCedulaContribuyente(String cedulaContribuyente);
}
