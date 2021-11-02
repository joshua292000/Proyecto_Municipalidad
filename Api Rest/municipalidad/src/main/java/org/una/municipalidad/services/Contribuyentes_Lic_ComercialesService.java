package org.una.municipalidad.services;

import org.springframework.data.repository.query.Param;
import org.una.municipalidad.dto.Contribuyentes_Licencias_ComercialesDTO;
import org.una.municipalidad.entities.Contribuyentes_Licencias_Comerciales;

import java.util.List;
import java.util.Optional;

public interface Contribuyentes_Lic_ComercialesService {
    public Optional<Contribuyentes_Licencias_ComercialesDTO> findByPorcentajeLicencia(Long porcentajeLicencia);

    public Optional<List<Contribuyentes_Licencias_ComercialesDTO>> findContribuyentes_Licencias_ComercialesByCedula(@Param("cedulaContribuyente") String cedulaContribuyente);

    public Optional<Contribuyentes_Licencias_ComercialesDTO> create(Contribuyentes_Licencias_ComercialesDTO contLicComDTO);

    public Optional<Contribuyentes_Licencias_ComercialesDTO> update(Contribuyentes_Licencias_ComercialesDTO contLicComDTO);


    public void deleteAll();
}
