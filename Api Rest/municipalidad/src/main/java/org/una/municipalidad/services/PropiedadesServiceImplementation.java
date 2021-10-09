package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.PropiedadesDTO;
import org.una.municipalidad.entities.Propiedades;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.PropiedadesRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class PropiedadesServiceImplementation implements PropiedadesService {
    @Autowired
    private PropiedadesRepository propiedadesRepository;
    @Override
    @Transactional(readOnly = true)
    public Optional<List<PropiedadesDTO>> findAll() {
        List<PropiedadesDTO> propiedadesDTOList = MapperUtils.DtoListFromEntityList(propiedadesRepository.findAll(), PropiedadesDTO.class);
        if (propiedadesDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(propiedadesDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PropiedadesDTO> findById(Long id) {
        Optional<Propiedades> propiedades = propiedadesRepository.findById(id);
        if (propiedades.isEmpty()) throw new NotFoundInformationException();
        PropiedadesDTO propiedadesDTO = MapperUtils.DtoFromEntity(propiedades.get(), PropiedadesDTO.class);
        return Optional.ofNullable(propiedadesDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PropiedadesDTO> findByPropiedadValorTerreno(long propiedadValorTerreno) {
        Optional<Propiedades> propiedades = propiedadesRepository.findByPropiedadValorTerreno(propiedadValorTerreno);
        if (propiedades.isEmpty()) throw new NotFoundInformationException();
        PropiedadesDTO propiedadesDTO = MapperUtils.DtoFromEntity(propiedades.get(), PropiedadesDTO.class);
        return Optional.ofNullable(propiedadesDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PropiedadesDTO> findByPropiedadValorConstruccion(long propiedadValorConstruccion) {
        Optional<Propiedades> propiedades = propiedadesRepository.findByPropiedadValorConstruccion(propiedadValorConstruccion);
        if (propiedades.isEmpty()) throw new NotFoundInformationException();
        PropiedadesDTO propiedadesDTO = MapperUtils.DtoFromEntity(propiedades.get(), PropiedadesDTO.class);
        return Optional.ofNullable(propiedadesDTO);
    }

    private PropiedadesDTO getSavedPropiedadesDTO(PropiedadesDTO propiedadesDTO) {
        Propiedades propiedades = MapperUtils.EntityFromDto(propiedadesDTO, Propiedades.class);
        Propiedades propiedadesCreated = propiedadesRepository.save(propiedades);
        return MapperUtils.DtoFromEntity(propiedadesCreated, PropiedadesDTO.class);
    }
    @Override
    @Transactional
    public Optional<PropiedadesDTO> create(PropiedadesDTO propiedadesDTO) {
        return Optional.ofNullable(getSavedPropiedadesDTO(propiedadesDTO));
    }

    @Override
    @Transactional
    public Optional<PropiedadesDTO> update(PropiedadesDTO propiedadesDTO, Long id) {
        if (propiedadesRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedPropiedadesDTO(propiedadesDTO));
    }

    @Override
    public void delete(Long id) {
        propiedadesRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        propiedadesRepository.deleteAll();
    }
}
