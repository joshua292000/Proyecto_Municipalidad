package org.una.municipalidad.services;

import org.una.municipalidad.dto.Contribuyentes_Locales_MercadoDTO;

import java.util.Optional;

public interface Contribuyentes_Loc_MercadoService {
    public Optional<Contribuyentes_Locales_MercadoDTO> findByPorcentajeLicencia(Long porcentajeLicencia);

    public Optional<Contribuyentes_Locales_MercadoDTO> create(Contribuyentes_Locales_MercadoDTO contLicComDTO);

    public Optional<Contribuyentes_Locales_MercadoDTO> update(Contribuyentes_Locales_MercadoDTO contLicComDTO);

    public void deleteAll();
}
