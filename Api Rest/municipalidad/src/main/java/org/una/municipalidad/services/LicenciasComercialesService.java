package org.una.municipalidad.services;

import java.util.List;
import java.util.Optional;
import org.una.municipalidad.dto.LicenciasComercialesDTO;

public interface LicenciasComercialesService {

    public Optional<List<LicenciasComercialesDTO>> findAll();

    public Optional<LicenciasComercialesDTO> findById(Long id);

    public Optional<LicenciasComercialesDTO> findByCodigo(String codigoComercio);

    public Optional<List<LicenciasComercialesDTO>> findByNombre(String nombreComercio);

    public Optional<LicenciasComercialesDTO> create(LicenciasComercialesDTO licenciacomercialDTO);

    public Optional<LicenciasComercialesDTO> update(LicenciasComercialesDTO licenciacomercialDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
