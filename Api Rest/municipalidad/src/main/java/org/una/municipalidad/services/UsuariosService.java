package org.una.municipalidad.services;

import org.una.municipalidad.dto.UsuariosDTO;

import java.util.List;
import java.util.Optional;

public interface UsuariosService {

    public Optional<List<UsuariosDTO>> findAll();

    public Optional<UsuariosDTO> findById(Long id);

    public Optional<List<UsuariosDTO>> findByNombreUsuarioAproximateIgnoreCase(String nombreUsuario);

    public Optional<List<UsuariosDTO>> findByNombreUsuarioAproximate(String nombreUsuario);

    public Optional<UsuariosDTO> create(UsuariosDTO usuariosDTO);

    public Optional<UsuariosDTO> update(UsuariosDTO usuariosDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<UsuariosDTO> login(String nombreUsuario,String claveEncriptado);

}
