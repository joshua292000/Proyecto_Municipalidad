package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.CobrosDTO;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.ParametrosDTO;
import org.una.municipalidad.entities.Cobros;
import org.una.municipalidad.entities.Contribuyentes;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.ContribuyentesRepository;
import org.una.municipalidad.utils.MapperUtils;


import java.util.Optional;
import java.util.List;

@Service
public class ContribuyentesServiceImplementation implements ContribuyentesService{
    @Autowired
    private ContribuyentesRepository contribuyentesRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ContribuyentesDTO>> findAll() {
        List<ContribuyentesDTO> contribuyentesDTOList = MapperUtils.DtoListFromEntityList(contribuyentesRepository.findAll(), ContribuyentesDTO.class);
        if (contribuyentesDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(contribuyentesDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ContribuyentesDTO> findById(Long id) {
        Optional<Contribuyentes> contribuyente = contribuyentesRepository.findById(id);
        if (contribuyente.isEmpty()) throw new NotFoundInformationException();
        ContribuyentesDTO contribuyentesDTO = MapperUtils.DtoFromEntity(contribuyente.get(), ContribuyentesDTO.class);
        return Optional.ofNullable(contribuyentesDTO);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ContribuyentesDTO> findByNombreContribuyente(String nombreContribuyente) {
        Optional<Contribuyentes> contribuyentes = contribuyentesRepository.findByNombreContribuyente(nombreContribuyente);
        if(contribuyentes.isEmpty()) throw new NotFoundInformationException();
        ContribuyentesDTO contribuyentesDTO = MapperUtils.DtoFromEntity(contribuyentes.get(),ContribuyentesDTO.class);
        return Optional.ofNullable(contribuyentesDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ContribuyentesDTO> findByCedulaContribuyente(String cedulaContribuyente) {
        Optional<Contribuyentes> contribuyentes = contribuyentesRepository.findByCedulaContribuyente(cedulaContribuyente);
        if(contribuyentes.isEmpty()) throw new NotFoundInformationException();
        ContribuyentesDTO contribuyentesDTO = MapperUtils.DtoFromEntity(contribuyentes.get(),ContribuyentesDTO.class);
        return Optional.ofNullable(contribuyentesDTO);
    }


    @Override
    @Transactional
    public Optional<ContribuyentesDTO> create(ContribuyentesDTO contribuyentesDTO) {
        return Optional.ofNullable(getSavedContribuyentesDTO(contribuyentesDTO));
    }

    @Override
    @Transactional
    public Optional<ContribuyentesDTO> update(ContribuyentesDTO contribuyentesDTO) {
        return Optional.ofNullable(getSavedContribuyentesDTO(contribuyentesDTO));
    }

    private ContribuyentesDTO getSavedContribuyentesDTO(ContribuyentesDTO contribuyentesDTO) {
        Contribuyentes contribuyentes = MapperUtils.EntityFromDto(contribuyentesDTO, Contribuyentes.class);
        Contribuyentes contribuyentesCreated = contribuyentesRepository.save(contribuyentes);
        return MapperUtils.DtoFromEntity(contribuyentesCreated, ContribuyentesDTO.class);
    }
}
