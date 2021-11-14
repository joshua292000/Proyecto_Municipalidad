package org.una.municipalidad.services;


import org.springframework.data.repository.query.Param;
import org.una.municipalidad.dto.LicenciasComercialesDTO;
import org.una.municipalidad.dto.PropiedadesDTO;
import org.una.municipalidad.entities.Propiedades;

import java.util.List;
import java.util.Optional;

public interface PropiedadesService {
    public Optional<List<PropiedadesDTO>> findAll();

    public Optional<PropiedadesDTO> findById(Long propiedades_id);

    public Optional<List<PropiedadesDTO>> findByEstado(String Estado);

    public Optional<PropiedadesDTO> findByPropiedadValorTerreno(long propiedadValorTerreno);

    public Optional<PropiedadesDTO> findByPropiedadValorConstruccion(long propiedadValorConstruccion);

    public Optional<List<PropiedadesDTO>> findPropiedadesByCedula(@Param("cedulaContribuyente") String cedulaContribuyente);


    public Optional<PropiedadesDTO> create(PropiedadesDTO propiedadesDTO);

    public Optional<PropiedadesDTO> update(PropiedadesDTO propiedadesDTO, Long propiedades_id);

    public void delete(Long propiedades_id);

    public void deleteAll();

}
