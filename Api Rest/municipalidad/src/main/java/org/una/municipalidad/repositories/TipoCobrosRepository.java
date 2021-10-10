package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.municipalidad.entities.TipoCobros;

import java.util.Optional;

public interface TipoCobrosRepository extends JpaRepository<TipoCobros, Long> {
    public Optional<TipoCobros> findByNombreTipoCobro(String nombreTipoCobro);
}
