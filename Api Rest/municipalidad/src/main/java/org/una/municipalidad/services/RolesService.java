package org.una.municipalidad.services;

import org.una.municipalidad.dto.RolesDTO;

import java.util.List;
import java.util.Optional;

public interface RolesService {
    public Optional<List<RolesDTO>> findAll();

    public Optional<RolesDTO> findById(Long id);

    public Optional<List<RolesDTO>> findByNombreRolAproximateIgnoreCase(String nombreRol);

    public Optional<List<RolesDTO>> findByNombreRolAproximate(String nombreRol);

    public Optional<RolesDTO> create(RolesDTO rolesDTO);

    public Optional<RolesDTO> update(RolesDTO rolesDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

    //public Optional<RolesDTO> login(String nombreUsuario,String claveEncriptado);
}
