package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Contribuyentes_Propiedades;

import java.util.Optional;

@Repository
public interface Contribuyentes_PropiedadesRepository extends JpaRepository<Contribuyentes_Propiedades, Long> {
    public Optional<Contribuyentes_Propiedades> findByPorcentajePropiedad(Long porcentajePropiedad);
}
