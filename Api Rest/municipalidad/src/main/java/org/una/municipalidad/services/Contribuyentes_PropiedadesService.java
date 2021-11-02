package org.una.municipalidad.services;


import org.springframework.data.repository.query.Param;
import org.una.municipalidad.dto.Contribuyentes_Locales_MercadoDTO;
import org.una.municipalidad.dto.Contribuyentes_PropiedadesDTO;

import java.util.List;
import java.util.Optional;

public interface Contribuyentes_PropiedadesService {

    public Optional<Contribuyentes_PropiedadesDTO> findByPorcentajePropiedad(Long porcentajePropiedad);

    public Optional<List<Contribuyentes_PropiedadesDTO>> findContribuyentes_PropiedadesByCedula(@Param("cedulaContribuyente") String cedulaContribuyente);

    public Optional<Contribuyentes_PropiedadesDTO> create(Contribuyentes_PropiedadesDTO contProDTO);

    public Optional<Contribuyentes_PropiedadesDTO> update(Contribuyentes_PropiedadesDTO contProDTO);

    public void deleteAll();
}
