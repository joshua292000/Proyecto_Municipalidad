package org.una.municipalidad.services;

import org.una.municipalidad.dto.UsuariosDTO;

import java.util.List;
import java.util.Optional;

public interface UsuariosService {

    public Optional<List<UsuariosDTO>> findAll();

    public Optional<UsuariosDTO> findById(Long Id);

    public Optional<List<UsuariosDTO>> findByUsuarioIgnoreCase(String Usuario);

    public Optional<List<UsuariosDTO>> findByUsuarioAproximate(String cedula);

    public Optional<UsuariosDTO> create(UsuariosDTO usuariosDTO);

    public Optional<UsuariosDTO> update(UsuariosDTO usuariosDTO, Long Id);

    public void delete(Long Id);

    public void deleteAll();

    public Optional<UsuariosDTO> login(String Usuario,String Clave);

}
