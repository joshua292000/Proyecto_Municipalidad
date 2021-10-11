package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.ParametrosDTO;
import org.una.municipalidad.dto.RolesDTO;
import org.una.municipalidad.entities.Parametros;
import org.una.municipalidad.entities.Roles;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.ParametrosRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ParametrosServiceImplementation implements ParametrosService{

    @Autowired
    private ParametrosRepository parametrosRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ParametrosDTO>> findAll() {
        List<ParametrosDTO> parametrosDTOList = MapperUtils.DtoListFromEntityList(parametrosRepository.findAll(), ParametrosDTO.class);
        if (parametrosDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(parametrosDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ParametrosDTO> findById(Long id) {
        Optional<Parametros> parametros = parametrosRepository.findById(id);
        if (parametros.isEmpty()) throw new NotFoundInformationException();
        ParametrosDTO parametrosDTO = MapperUtils.DtoFromEntity(parametros.get(), ParametrosDTO.class);
        return Optional.ofNullable(parametrosDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ParametrosDTO> findByLlaveParametro(String llaveParametro) {
        Optional<Parametros> parametros = parametrosRepository.findByLlaveParametro(llaveParametro);
        if (parametros.isEmpty()) throw new NotFoundInformationException();
        ParametrosDTO parametrosDTO = MapperUtils.DtoFromEntity(parametros.get(), ParametrosDTO.class);
        return Optional.ofNullable(parametrosDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ParametrosDTO> findByValorParametro(String valorParametro) {
        Optional<Parametros> parametros = parametrosRepository.findByValorParametro(valorParametro);
        if (parametros.isEmpty()) throw new NotFoundInformationException();
        ParametrosDTO parametrosDTO = MapperUtils.DtoFromEntity(parametros.get(), ParametrosDTO.class);
        return Optional.ofNullable(parametrosDTO);
    }

    private ParametrosDTO getSavedParametrosDTO(ParametrosDTO parametrosDTO) {
        Parametros parametros = MapperUtils.EntityFromDto(parametrosDTO, Parametros.class);
        Parametros parametrosCreated = parametrosRepository.save(parametros);
        return MapperUtils.DtoFromEntity(parametrosCreated, ParametrosDTO.class);
    }

    @Override
    @Transactional
    public Optional<ParametrosDTO> create(ParametrosDTO parametrosDTO) {
        return Optional.ofNullable(getSavedParametrosDTO(parametrosDTO));
    }

    @Override
    @Transactional
    public Optional<ParametrosDTO> update(ParametrosDTO parametrosDTO, Long id) {
        if (parametrosRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedParametrosDTO(parametrosDTO));
    }

    @Override
    public void delete(Long id) {
        parametrosRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        parametrosRepository.deleteAll();
    }
}
