package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.Contribuyentes_Licencias_ComercialesDTO;
import org.una.municipalidad.dto.Contribuyentes_PropiedadesDTO;
import org.una.municipalidad.entities.Contribuyentes_Propiedades;
import org.una.municipalidad.repositories.Contribuyentes_PropiedadesRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Optional;

@Service
public class Contribuyentes_PropiedadesServiceImplementation implements Contribuyentes_PropiedadesService {
    @Autowired
    private Contribuyentes_PropiedadesRepository contribuyentes_propiedadesRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Contribuyentes_PropiedadesDTO> findByPorcentajePropiedad(Long porcentajePropiedad) {
        Optional<Contribuyentes_Propiedades> contriPro = contribuyentes_propiedadesRepository.findByPorcentajePropiedad(porcentajePropiedad);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(contriPro, Contribuyentes_PropiedadesDTO.class));
    }

    private Contribuyentes_PropiedadesDTO getSavedContribuyenteProDTO(Contribuyentes_PropiedadesDTO contProDTO) {
        Contribuyentes_Propiedades contriPro = MapperUtils.EntityFromDto(contProDTO, Contribuyentes_Propiedades.class);
        Contribuyentes_Propiedades contriProCreated = contribuyentes_propiedadesRepository.save(contriPro);
        return MapperUtils.DtoFromEntity(contriProCreated, Contribuyentes_PropiedadesDTO.class);
    }

    @Override
    @Transactional
    public Optional<Contribuyentes_PropiedadesDTO> create(Contribuyentes_PropiedadesDTO contProDTO) {
        return Optional.ofNullable(getSavedContribuyenteProDTO(contProDTO));
    }

    @Override
    @Transactional
    public Optional<Contribuyentes_PropiedadesDTO> update(Contribuyentes_PropiedadesDTO contProDTO) {
        return Optional.ofNullable(getSavedContribuyenteProDTO(contProDTO));
    }

    @Override
    public void deleteAll() {
        contribuyentes_propiedadesRepository.deleteAll();
    }
}
