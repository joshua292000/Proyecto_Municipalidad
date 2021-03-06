package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.Contribuyentes_Licencias_ComercialesDTO;
import org.una.municipalidad.dto.LicenciasComercialesDTO;
import org.una.municipalidad.entities.Contribuyentes_Licencias_Comerciales;
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
    @Transactional(readOnly = true)
    public Optional<LicenciasComercialesDTO> findById(Long id) {
        Optional<Licencias_Comerciales> licenciacomercial = licenciacomercialRepository.findById(id);
        if (licenciacomercial.isEmpty()) throw new NotFoundInformationException();
        LicenciasComercialesDTO licenciasComercialesDTO = MapperUtils.DtoFromEntity(licenciacomercial.get(), LicenciasComercialesDTO.class);
        return Optional.ofNullable(licenciasComercialesDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LicenciasComercialesDTO> findByCodigoComercio(String codigoComercio) {
        Optional<Licencias_Comerciales> licenciacomercial = licenciacomercialRepository.findByCodigoComercio(codigoComercio);
        if (licenciacomercial.isEmpty()) throw new NotFoundInformationException();
        LicenciasComercialesDTO licenciaComercialDTO = MapperUtils.DtoFromEntity(licenciacomercial.get(), LicenciasComercialesDTO.class);
        return Optional.ofNullable(licenciaComercialDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LicenciasComercialesDTO> findByNombreComercio(String nombreComercio) {
        Optional<Licencias_Comerciales> licenciaComercial = licenciacomercialRepository.findByNombreComercio(nombreComercio);
        if (licenciaComercial.isEmpty()) throw new NotFoundInformationException();
        LicenciasComercialesDTO licenciaComercialDTO = MapperUtils.DtoFromEntity(licenciaComercial.get(), LicenciasComercialesDTO.class);
        return Optional.ofNullable(licenciaComercialDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<LicenciasComercialesDTO>> findByEstado(String Estado) {
        List<Licencias_Comerciales> Cobroslist = licenciacomercialRepository.findByEstado(Estado);
        List<LicenciasComercialesDTO> CobrosDtolist = MapperUtils.DtoListFromEntityList(Cobroslist,LicenciasComercialesDTO.class);
        return Optional.ofNullable(CobrosDtolist);
    }

    @Override
    @Transactional(readOnly = true)
    public void EliminarLicencia() {
        licenciacomercialRepository.EliminarLicencia();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<LicenciasComercialesDTO>> findLicencias_ComercialesByCedula(String cedulaContribuyente) {
        List<Licencias_Comerciales> contribuyenteslist = licenciacomercialRepository.findLicencias_ComercialesByCedula(cedulaContribuyente);
        List<LicenciasComercialesDTO> contribuyentesDTO = MapperUtils.DtoListFromEntityList(contribuyenteslist,LicenciasComercialesDTO.class);
        return Optional.ofNullable(contribuyentesDTO);
    }

    private LicenciasComercialesDTO getSavedLicenciaComercialDTO(LicenciasComercialesDTO licenciaComercialDTO) {
        Licencias_Comerciales licenciaComercial = MapperUtils.EntityFromDto(licenciaComercialDTO, Licencias_Comerciales.class);
        Licencias_Comerciales licenciaComercialCreated = licenciacomercialRepository.save(licenciaComercial);
        return MapperUtils.DtoFromEntity(licenciaComercialCreated, LicenciasComercialesDTO.class);
    }

    @Override
    @Transactional
    public Optional<LicenciasComercialesDTO> create(LicenciasComercialesDTO licenciacomercialDTO) {
        return Optional.ofNullable(getSavedLicenciaComercialDTO(licenciacomercialDTO));
    }

    @Override
    @Transactional
    public Optional<LicenciasComercialesDTO> update(LicenciasComercialesDTO licenciacomercialDTO, Long id) {
        if (licenciacomercialRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedLicenciaComercialDTO(licenciacomercialDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        licenciacomercialRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        licenciacomercialRepository.deleteAll();
    }
}
