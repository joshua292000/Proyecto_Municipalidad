package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.TipoCobros;

import java.util.Optional;

@Repository
public interface TipoCobrosRepository extends JpaRepository<TipoCobros, Long> {
    public Optional<TipoCobros> findByNombreTipoCobro(String nombreTipoCobro);
}
