package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.RolesDTO;
import org.una.municipalidad.entities.Roles;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.RolesRepository;
import org.una.municipalidad.utils.MapperUtils;
import java.util.List;
import java.util.Optional;

@Service
public class RolesServiceImplementation implements RolesService{

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<RolesDTO>> findByNombreRolAproximateIgnoreCase(String nombreRol) {
        List<Roles> rolesList = rolesRepository.findByNombreRolContainingIgnoreCase(nombreRol);
        List<RolesDTO> rolesDTOList = MapperUtils.DtoListFromEntityList(rolesList, RolesDTO.class);
        return Optional.ofNullable(rolesDTOList);

    }

    private RolesDTO getSavedRolDTO(RolesDTO rolesDTO) {
        Roles roles = MapperUtils.EntityFromDto(rolesDTO, Roles.class);
        Roles rolesCreated = rolesRepository.save(roles);
        return MapperUtils.DtoFromEntity(rolesCreated, RolesDTO.class);
    }

    @Override
    @Transactional
    public Optional<RolesDTO> create(RolesDTO rolesDTO) {
        return Optional.ofNullable(getSavedRolDTO(rolesDTO));
    }


    @Override
    @Transactional
    public Optional<RolesDTO> update(RolesDTO rolesDTO, Long id) {
        if (rolesRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedRolDTO(rolesDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        rolesRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        rolesRepository.deleteAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<RolesDTO> findById(Long id) {
        Optional<Roles> roles = rolesRepository.findById(id);
        if (roles.isEmpty()) throw new NotFoundInformationException();
        RolesDTO rolesDTO = MapperUtils.DtoFromEntity(roles.get(), RolesDTO.class);
        return Optional.ofNullable(rolesDTO);

    }


    @Override
    @Transactional(readOnly = true)
    public Optional<List<RolesDTO>> findAll() {

        List<RolesDTO> rolesDTOList = MapperUtils.DtoListFromEntityList(rolesRepository.findAll(), RolesDTO.class);
        return Optional.ofNullable(rolesDTOList);
    }


}
