package org.una.municipalidad.services;

import org.una.municipalidad.dto.Contribuyentes_Licencias_ComercialesDTO;
import java.util.Optional;

public interface Contribuyentes_Lic_ComercialesService {
    public Optional<Contribuyentes_Licencias_ComercialesDTO> findByPorcentajeLicencia(Long porcentajeLicencia);

    public Optional<Contribuyentes_Licencias_ComercialesDTO> create(Contribuyentes_Licencias_ComercialesDTO contLicComDTO);

    public Optional<Contribuyentes_Licencias_ComercialesDTO> update(Contribuyentes_Licencias_ComercialesDTO contLicComDTO);

    public void deleteAll();
}
