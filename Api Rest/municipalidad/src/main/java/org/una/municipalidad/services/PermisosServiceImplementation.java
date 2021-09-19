package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.PermisosDTO;
import org.una.municipalidad.dto.PermisosDTO;
import org.una.municipalidad.entities.Permisos;
import org.una.municipalidad.entities.Permisos;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.PermisosRepository;
import org.una.municipalidad.utils.MapperUtils;
import java.util.List;
import java.util.Optional;

@Service
public class PermisosServiceImplementation implements PermisosService{

    @Autowired
    private PermisosRepository permisosRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisosDTO>> findByNombrePermisoAproximateIgnoreCase(String nombrePermiso) {
        List<Permisos> permisosList = permisosRepository.findByNombrePermisoContainingIgnoreCase(nombrePermiso);
        List<PermisosDTO> permisosDTOList = MapperUtils.DtoListFromEntityList(permisosList, PermisosDTO.class);
        return Optional.ofNullable(permisosDTOList);

    }

    private PermisosDTO getSavedPermisoDTO(PermisosDTO permisosDTO) {
        Permisos permisos = MapperUtils.EntityFromDto(permisosDTO, Permisos.class);
        Permisos permisosCreated = permisosRepository.save(permisos);
        return MapperUtils.DtoFromEntity(permisosCreated, PermisosDTO.class);
    }

    @Override
    @Transactional
    public Optional<PermisosDTO> create(PermisosDTO permisosDTO) {
        return Optional.ofNullable(getSavedPermisoDTO(permisosDTO));
    }


    @Override
    @Transactional
    public Optional<PermisosDTO> update(PermisosDTO permisosDTO, Long id) {
        if (permisosRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedPermisoDTO(permisosDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        permisosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        permisosRepository.deleteAll();
    }


    /*@Override
    @Transactional(readOnly = true)
    public Optional<RolesDTO> login(String nombreRol, String descripcionRol) {
        Roles roles = rolesRepository.findByNombreRolAndDescripcionRol(nombreRol, descripcionRol);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(roles, RolesDTO.class));
    }*/

    @Override
    @Transactional(readOnly = true)
    public Optional<PermisosDTO> findById(Long id) {
        Optional<Permisos> permisos = permisosRepository.findById(id);
        if (permisos.isEmpty()) throw new NotFoundInformationException();

        PermisosDTO permisosDTO = MapperUtils.DtoFromEntity(permisos.get(), PermisosDTO.class);
        return Optional.ofNullable(permisosDTO);

    }


    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisosDTO>> findAll() {

        List<PermisosDTO> permisosDTOList = MapperUtils.DtoListFromEntityList(permisosRepository.findAll(), PermisosDTO.class);
        return Optional.ofNullable(permisosDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisosDTO>> findByNombrePermisoAproximate(String nombrePermiso) {
        List<Permisos> permisosList = permisosRepository.findByNombrePermisoContaining(nombrePermiso);
        if (permisosList.isEmpty()) throw new NotFoundInformationException();

        List<PermisosDTO> permisosDTOList = MapperUtils.DtoListFromEntityList(permisosList, PermisosDTO.class);
        return Optional.ofNullable(permisosDTOList);
    }
}
