package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.entities.Contribuyentes;
import org.una.municipalidad.repositories.ContribuyentesRepository;
import org.una.municipalidad.utils.MapperUtils;


import java.util.Optional;

public class ContribuyentesServiceImplementation implements ContribuyentesService{
    @Autowired
    private ContribuyentesRepository contribuyentesRepository;

    @Override
    public Optional<ContribuyentesDTO> findByNombreContribuyente(String nombreContribuyente) {
        Optional<Contribuyentes> contribuyentes = contribuyentesRepository.findByNombreContribuyente(nombreContribuyente);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(contribuyentes, ContribuyentesDTO.class));
    }

    @Override
    public Optional<ContribuyentesDTO> findByCedulaContribuyente(Long cedulaContribuyente) {
        Optional<Contribuyentes> contribuyentes = contribuyentesRepository.findByCedulaContribuyente(cedulaContribuyente);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(contribuyentes, ContribuyentesDTO.class));
    }

    @Override
    public Optional<ContribuyentesDTO> create(ContribuyentesDTO contribuyentesDTO) {
        return Optional.ofNullable(getSavedContribuyentesDTO(contribuyentesDTO));
    }

    @Override
    public Optional<ContribuyentesDTO> update(ContribuyentesDTO contribuyentesDTO) {
        return Optional.ofNullable(getSavedContribuyentesDTO(contribuyentesDTO));
    }

    private ContribuyentesDTO getSavedContribuyentesDTO(ContribuyentesDTO contribuyentesDTO) {
        Contribuyentes contribuyentes = MapperUtils.EntityFromDto(contribuyentesDTO, Contribuyentes.class);
        Contribuyentes contribuyentesCreated = contribuyentesRepository.save(contribuyentes);
        return MapperUtils.DtoFromEntity(contribuyentesCreated, ContribuyentesDTO.class);
    }
}
