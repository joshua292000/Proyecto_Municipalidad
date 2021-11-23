package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.municipalidad.entities.Cobros;
import org.una.municipalidad.entities.FechasCobros;

public interface FechasCobrosRepository extends JpaRepository<FechasCobros, Long> {
}
