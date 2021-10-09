package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.Parametros;

import java.util.Optional;

@Repository
public interface ParametrosRepository extends JpaRepository<Parametros, Long> {
    public Optional<Parametros> findByParametrosLlaves(String parametrosLlaves);
    public Optional<Parametros> findByParametrosValor(String parametrosValor);
}

