package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.CobrosDTO;
import org.una.municipalidad.entities.Cobros;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.CobrosRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CobrosServiceImplementation implements CobrosService {

    @Autowired
    private CobrosRepository cobrosRepository;
    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobrosDTO>> findAll() {
        List<CobrosDTO> cobrosDTOList = MapperUtils.DtoListFromEntityList(cobrosRepository.findAll(), CobrosDTO.class);
        if (cobrosDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(cobrosDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CobrosDTO> findById(Long id) {
        Optional<Cobros> cobros = cobrosRepository.findById(id);
        if (cobros.isEmpty()) throw new NotFoundInformationException();
        CobrosDTO cobrosDTO = MapperUtils.DtoFromEntity(cobros.get(), CobrosDTO.class);
        return Optional.ofNullable(cobrosDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CobrosDTO> findByCobrosPeriodo(String cobrosPeriodo) {
        Optional<Cobros> cobros = cobrosRepository.findByCobrosPeriodo(cobrosPeriodo);
        if (cobros.isEmpty()) throw new NotFoundInformationException();
        CobrosDTO cobrosDTO = MapperUtils.DtoFromEntity(cobros.get(), CobrosDTO.class);
        return Optional.ofNullable(cobrosDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CobrosDTO> findByCobrosMonto(Long cobrosMonto) {
        Optional<Cobros> cobros = cobrosRepository.findByCobrosMonto(cobrosMonto);
        if (cobros.isEmpty()) throw new NotFoundInformationException();
        CobrosDTO cobrosDTO = MapperUtils.DtoFromEntity(cobros.get(), CobrosDTO.class);
        return Optional.ofNullable(cobrosDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobrosDTO>> findByCobrosFechaPago(Date startDate, Date endDate) {
        List<Cobros> Fechacobroslist = cobrosRepository.findByCobrosFechaPago(startDate, endDate);
        List<CobrosDTO> FechacobrosDtolist = MapperUtils.DtoListFromEntityList(Fechacobroslist,CobrosDTO.class);
        return Optional.ofNullable(FechacobrosDtolist);
    }

   @Override
    @Transactional(readOnly = true)
    public Optional<List<CobrosDTO>> findCobroByCedulaContribuyente(@Param("cedulaContribuyente") String cedulaContribuyente) {
        List<Cobros> Cobroslist = cobrosRepository.findCobroByCedulaContribuyente(cedulaContribuyente);
        List<CobrosDTO> CobrosDtolist = MapperUtils.DtoListFromEntityList(Cobroslist,CobrosDTO.class);
        return Optional.ofNullable(CobrosDtolist);
    }

    private CobrosDTO getSavedCobrosDTO(CobrosDTO cobrosDTO) {
        Cobros cobros = MapperUtils.EntityFromDto(cobrosDTO, Cobros.class);
        Cobros cobrosCreated = cobrosRepository.save(cobros);
        return MapperUtils.DtoFromEntity(cobrosCreated, CobrosDTO.class);
    }

    @Override
    @Transactional
    public Optional<CobrosDTO> create(CobrosDTO cobrosDTO) {
        return Optional.ofNullable(getSavedCobrosDTO(cobrosDTO));
    }

    @Override
    @Transactional
    public Optional<CobrosDTO> update(CobrosDTO cobrosDTO, Long id) {
        if (cobrosRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedCobrosDTO(cobrosDTO));
    }

    @Override
    public void delete(Long id) {
        cobrosRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        cobrosRepository.deleteAll();
    }
}
