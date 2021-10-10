package org.una.municipalidad.services;


import org.una.municipalidad.dto.Contribuyentes_PropiedadesDTO;

import java.util.Optional;

public interface Contribuyentes_PropiedadesService {

    public Optional<Contribuyentes_PropiedadesDTO> findByPorcentajePropiedades(Long porcentajePropiedad);

    public Optional<Contribuyentes_PropiedadesDTO> create(Contribuyentes_PropiedadesDTO contProDTO);

    public Optional<Contribuyentes_PropiedadesDTO> update(Contribuyentes_PropiedadesDTO contProDTO);

    public void deleteAll();
}
