package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Cobros;
import org.una.municipalidad.entities.FechasCobros;

@Repository
public interface FechasCobrosRepository extends JpaRepository<FechasCobros, Long> {
}
