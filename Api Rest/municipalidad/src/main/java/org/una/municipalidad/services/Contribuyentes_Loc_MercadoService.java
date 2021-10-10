package org.una.municipalidad.services;

import org.una.municipalidad.dto.Contribuyentes_Locales_MercadoDTO;

import java.util.Optional;

public interface Contribuyentes_Loc_MercadoService {
    public Optional<Contribuyentes_Locales_MercadoDTO> findByPorcentajeLocales(Long porcentajeLocales);

    public Optional<Contribuyentes_Locales_MercadoDTO> create(Contribuyentes_Locales_MercadoDTO contriLocMercDTO);

    public Optional<Contribuyentes_Locales_MercadoDTO> update(Contribuyentes_Locales_MercadoDTO contriLocMercDTO);

    public void deleteAll();
}
