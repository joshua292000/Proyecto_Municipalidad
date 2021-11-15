package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.BitacorasDTO;
import org.una.municipalidad.entities.BitacoraCambios;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.BitacoraRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BitacorasServiceImplementation implements BitacorasService{
    @Autowired
    private BitacoraRepository bitacoraRepository;
    @Override
    @Transactional(readOnly = true)
    public Optional<List<BitacorasDTO>> findAll() {
        List<BitacorasDTO> bitacorasDTOList = MapperUtils.DtoListFromEntityList(bitacoraRepository.findAll(), BitacorasDTO.class);
        if (bitacorasDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(bitacorasDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BitacorasDTO> findById(Long id) {
        Optional<BitacoraCambios> bitacoraCambios = bitacoraRepository.findById(id);
        if (bitacoraCambios.isEmpty()) throw new NotFoundInformationException();
        BitacorasDTO bitacorasDTO = MapperUtils.DtoFromEntity(bitacoraCambios.get(), BitacorasDTO.class);
        return Optional.ofNullable(bitacorasDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BitacorasDTO> findByBitacoraTabla(String bitacoraTabla) {
        Optional<BitacoraCambios> bitacoraCambios = bitacoraRepository.findByBitacoraTabla(bitacoraTabla);
        if (bitacoraCambios.isEmpty()) throw new NotFoundInformationException();
        BitacorasDTO bitacorasDTO = MapperUtils.DtoFromEntity(bitacoraCambios.get(), BitacorasDTO.class);
        return Optional.ofNullable(bitacorasDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BitacorasDTO> findByBitacoraDescripcion(String bitacoraDescripcion) {
        Optional<BitacoraCambios> bitacoraCambios = bitacoraRepository.findByBitacoraDescripcion(bitacoraDescripcion);
        if (bitacoraCambios.isEmpty()) throw new NotFoundInformationException();
        BitacorasDTO bitacorasDTO = MapperUtils.DtoFromEntity(bitacoraCambios.get(), BitacorasDTO.class);
        return Optional.ofNullable(bitacorasDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<BitacorasDTO>> findByIdBetweenFecha(@Param("idUsuario")Long id, @Param("startDate") Date startDate, @Param("endDate")Date endDate) {
        List<BitacoraCambios> bitacoraCambiosList = bitacoraRepository.findByIdBetweenFecha(id,startDate,endDate);
        List<BitacorasDTO> bitacorasDTOList = MapperUtils.DtoListFromEntityList(bitacoraCambiosList,BitacorasDTO.class);
        return Optional.ofNullable(bitacorasDTOList);

    }

    private BitacorasDTO getSavedBitacorasDTO(BitacorasDTO bitacorasDTO) {
        BitacoraCambios bitacoraCambios = MapperUtils.EntityFromDto(bitacorasDTO, BitacoraCambios.class);
        BitacoraCambios bitacoraCambiosCreated = bitacoraRepository.save(bitacoraCambios);
        return MapperUtils.DtoFromEntity(bitacoraCambiosCreated, BitacorasDTO.class);
    }

    @Override
    @Transactional
    public Optional<BitacorasDTO> create(BitacorasDTO bitacorasDTO) {
        return Optional.ofNullable(getSavedBitacorasDTO(bitacorasDTO));
    }

    @Override
    @Transactional
    public Optional<BitacorasDTO> update(BitacorasDTO bitacorasDTO, Long id) {
        if (bitacoraRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedBitacorasDTO(bitacorasDTO));
    }

    @Override
    public void delete(Long id) {
        bitacoraRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        bitacoraRepository.deleteAll();
    }
}
