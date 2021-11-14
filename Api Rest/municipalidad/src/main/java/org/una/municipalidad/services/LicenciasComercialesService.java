package org.una.municipalidad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.una.municipalidad.dto.Contribuyentes_Licencias_ComercialesDTO;
import org.una.municipalidad.dto.LicenciasComercialesDTO;
import org.una.municipalidad.entities.Licencias_Comerciales;

public interface LicenciasComercialesService {

    public Optional<List<LicenciasComercialesDTO>> findAll();

    public Optional<LicenciasComercialesDTO> findById(Long id);

    public Optional<LicenciasComercialesDTO> findByCodigoComercio(String codigoComercio);

    public Optional<LicenciasComercialesDTO> findByNombreComercio(String nombreComercio);

    public Optional<List<LicenciasComercialesDTO>> findByEstado(String Estado);

    public Optional<LicenciasComercialesDTO> create(LicenciasComercialesDTO licenciacomercialDTO);

    public Optional<LicenciasComercialesDTO> update(LicenciasComercialesDTO licenciacomercialDTO, Long id);

    public Optional<List<LicenciasComercialesDTO>> findLicencias_ComercialesByCedula(@Param("cedulaContribuyente") String cedulaContribuyente);

    public void delete(Long id);

    public void deleteAll();

}
