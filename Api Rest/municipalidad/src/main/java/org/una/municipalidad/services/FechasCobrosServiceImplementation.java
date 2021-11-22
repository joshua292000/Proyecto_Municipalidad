package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.CobrosDTO;
import org.una.municipalidad.dto.FechasCobrosDTO;
import org.una.municipalidad.entities.Cobros;
import org.una.municipalidad.entities.FechasCobros;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.CobrosRepository;
import org.una.municipalidad.repositories.FechasCobrosRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.List;
import java.util.Optional;
@Service
public class FechasCobrosServiceImplementation implements FechasCobrosService{
    @Autowired
    private FechasCobrosRepository fechascobrosRepository;
    @Override
    @Transactional(readOnly = true)
    public Optional<List<FechasCobrosDTO>> findAll() {
        List<FechasCobrosDTO> fechascobrosDTOList = MapperUtils.DtoListFromEntityList(fechascobrosRepository.findAll(), FechasCobrosDTO.class);
        if (fechascobrosDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(fechascobrosDTOList);
    }

    private FechasCobrosDTO getSavedCobrosDTO(FechasCobrosDTO FechasCobrosDTO) {
        FechasCobros cobros = MapperUtils.EntityFromDto(FechasCobrosDTO, FechasCobros.class);
        FechasCobros cobrosCreated = fechascobrosRepository.save(cobros);
        return MapperUtils.DtoFromEntity(cobrosCreated, FechasCobrosDTO.class);
    }

    @Override
    @Transactional
    public Optional<FechasCobrosDTO> create(FechasCobrosDTO FechasCobrosDTO) {
        return Optional.ofNullable(getSavedCobrosDTO(FechasCobrosDTO));
    }

    @Override
    @Transactional
    public Optional<FechasCobrosDTO> update(FechasCobrosDTO cobrosDTO, Long id) {
        if (fechascobrosRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedCobrosDTO(cobrosDTO));
    }
}
