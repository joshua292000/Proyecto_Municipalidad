package org.una.municipalidad.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.Contribuyentes_Licencias_ComercialesDTO;
import org.una.municipalidad.dto.UsuariosDTO;
import org.una.municipalidad.entities.Contribuyentes_Licencias_Comerciales;
import org.una.municipalidad.entities.Usuarios;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.Contribuyentes_Licencias_ComercialesRepository;
import org.una.municipalidad.repositories.UsuariosRepository;
import org.una.municipalidad.utils.MapperUtils;
import java.util.List;
import java.util.Optional;

@Service
public class Contribuyentes_Lic_ComercialesServiceImplementation implements Contribuyentes_Lic_ComercialesService{

    @Autowired
    private Contribuyentes_Licencias_ComercialesRepository contribuyentes_licencias_comercialesRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Contribuyentes_Licencias_ComercialesDTO> findByPorcentaje(Long porcentaje) {
        Optional<Contribuyentes_Licencias_Comerciales> contriLicCom = contribuyentes_licencias_comercialesRepository.findByPorcentaje(porcentaje);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(contriLicCom, Contribuyentes_Licencias_ComercialesDTO.class));
    }

    private Contribuyentes_Licencias_ComercialesDTO getSavedContribuyenteLicComDTO(Contribuyentes_Licencias_ComercialesDTO contLicComDTO) {
        Contribuyentes_Licencias_Comerciales contriLicCom = MapperUtils.EntityFromDto(contLicComDTO, Contribuyentes_Licencias_Comerciales.class);
        Contribuyentes_Licencias_Comerciales contriLicComCreated = contribuyentes_licencias_comercialesRepository.save(contriLicCom);
        return MapperUtils.DtoFromEntity(contriLicComCreated, Contribuyentes_Licencias_ComercialesDTO.class);
    }

    @Override
    @Transactional
    public Optional<Contribuyentes_Licencias_ComercialesDTO> create(Contribuyentes_Licencias_ComercialesDTO contLicComDTO) {
        return Optional.ofNullable(getSavedContribuyenteLicComDTO(contLicComDTO));
    }

    @Override
    public Optional<Contribuyentes_Licencias_ComercialesDTO> update(Contribuyentes_Licencias_ComercialesDTO contLicComDTO) {
        return Optional.empty();
    }

    @Override
    public void deleteAll() {

    }
}
