package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Cobros;

import java.util.Optional;

@Repository
public interface CobrosRepository extends JpaRepository<Cobros, Long> {
    public Optional<Cobros> findByCobrosPeriodo(String cobrosPeriodo);
    public Optional<Cobros> findByCobrosMonto(Long cobrosMonto);
}
