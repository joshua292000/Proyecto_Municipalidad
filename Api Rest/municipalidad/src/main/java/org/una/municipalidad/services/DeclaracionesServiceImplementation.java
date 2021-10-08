package org.una.municipalidad.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.DeclaracionesDTO;
import org.una.municipalidad.dto.LicenciasComercialesDTO;
import org.una.municipalidad.entities.Declaraciones;
import org.una.municipalidad.entities.Licencias_Comerciales;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.DeclaracionesRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DeclaracionesServiceImplementation implements DeclaracionesService{
    @Autowired
    private DeclaracionesRepository declaracionesRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<DeclaracionesDTO>> findAll() {
        List<DeclaracionesDTO> declaracionDTOList = MapperUtils.DtoListFromEntityList(declaracionesRepository.findAll(), DeclaracionesDTO.class);
        if (declaracionDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(declaracionDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DeclaracionesDTO> findById(Long id) {
        Optional<Declaraciones> declaracion = declaracionesRepository.findById(id);
        if (declaracion.isEmpty()) throw new NotFoundInformationException();
        DeclaracionesDTO declaracionDTO = MapperUtils.DtoFromEntity(declaracion.get(), DeclaracionesDTO.class);
        return Optional.ofNullable(declaracionDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<DeclaracionesDTO>> findByMontoDeclarado(Long montoDeclarado) {
        List<Declaraciones> declaracionlList = declaracionesRepository.findByMontoDeclarado(montoDeclarado);
        if (declaracionlList.isEmpty()) throw new NotFoundInformationException();
        List<DeclaracionesDTO> declaracionDTOList = MapperUtils.DtoListFromEntityList(declaracionlList, DeclaracionesDTO.class);
        return Optional.ofNullable(declaracionDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<DeclaracionesDTO>> findByIdAndFechaDeclarado(Long id, Date fechaDeclarado) {
        List<Declaraciones> declaracionlList = declaracionesRepository.findByIdAndFechaDeclarado(id, fechaDeclarado);
        if (declaracionlList.isEmpty()) throw new NotFoundInformationException();
        List<DeclaracionesDTO> declaracionDTOList = MapperUtils.DtoListFromEntityList(declaracionlList, DeclaracionesDTO.class);
        return Optional.ofNullable(declaracionDTOList);
    }

    private DeclaracionesDTO getSavedDeclaracionDTO(DeclaracionesDTO declaracionesDTO) {
        Declaraciones declaracion = MapperUtils.EntityFromDto(declaracionesDTO, Declaraciones.class);
        Declaraciones declaracionCreated = declaracionesRepository.save(declaracion);
        return MapperUtils.DtoFromEntity(declaracionCreated, DeclaracionesDTO.class);
    }

    @Override
    @Transactional
    public Optional<DeclaracionesDTO> create(DeclaracionesDTO declaracionesDTO) {
        return Optional.ofNullable(getSavedDeclaracionDTO(declaracionesDTO));
    }

    @Override
    @Transactional
    public Optional<DeclaracionesDTO> update(DeclaracionesDTO declaracionesDTO, Long id) {
        if (declaracionesRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedDeclaracionDTO(declaracionesDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        declaracionesRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        declaracionesRepository.deleteAll();
    }
}
