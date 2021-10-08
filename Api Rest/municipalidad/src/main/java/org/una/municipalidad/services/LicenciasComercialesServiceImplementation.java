package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.LicenciasComercialesDTO;
import org.una.municipalidad.entities.Licencias_Comerciales;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.LicenciasComercialesRepository;
import org.una.municipalidad.utils.MapperUtils;


import java.util.List;
import java.util.Optional;

@Service
public class LicenciasComercialesServiceImplementation implements LicenciasComercialesService{

    @Autowired
    private LicenciasComercialesRepository licenciacomercialRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<LicenciasComercialesDTO>> findAll() {
        List<LicenciasComercialesDTO> licenciasComercialesDTOList = MapperUtils.DtoListFromEntityList(licenciacomercialRepository.findAll(), LicenciasComercialesDTO.class);
        if (licenciasComercialesDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(licenciasComercialesDTOList);
    }

    @Override
    public Optional<LicenciasComercialesDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<LicenciasComercialesDTO>> findByCodigo(String codigoComercio) {
        return Optional.empty();
    }

    @Override
    public Optional<List<LicenciasComercialesDTO>> findByNombre(String nombreComercio) {
        return Optional.empty();
    }

    @Override
    public Optional<LicenciasComercialesDTO> create(LicenciasComercialesDTO licenciacomercialDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<LicenciasComercialesDTO> update(LicenciasComercialesDTO licenciacomercialDTO, Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
