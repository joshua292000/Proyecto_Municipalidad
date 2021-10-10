package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.BitacoraCambios;

import java.util.Optional;

@Repository
public interface BitacoraRepository extends JpaRepository<BitacoraCambios, Long> {
    public Optional<BitacoraCambios> findByBitacoraTabla(String bitacoraTabla);
    public Optional<BitacoraCambios> findByBitacoraDescripcion(String bitacoraDescripcion);
}
