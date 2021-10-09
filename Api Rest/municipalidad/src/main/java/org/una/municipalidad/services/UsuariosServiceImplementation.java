package org.una.municipalidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.UsuariosDTO;
import org.una.municipalidad.entities.Usuarios;
import org.una.municipalidad.exceptions.NotFoundInformationException;
import org.una.municipalidad.repositories.UsuariosRepository;
import org.una.municipalidad.utils.MapperUtils;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImplementation implements UsuariosService{

    @Autowired
    private UsuariosRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<UsuariosDTO>> findByNombreUsuarioAproximateIgnoreCase(String nombreUsuario) {
        List<Usuarios> usuarioList = usuarioRepository.findByNombreUsuarioContainingIgnoreCase(nombreUsuario);
        List<UsuariosDTO> usuarioDTOList = MapperUtils.DtoListFromEntityList(usuarioList, UsuariosDTO.class);
        return Optional.ofNullable(usuarioDTOList);

    }

    private UsuariosDTO getSavedUsuarioDTO(UsuariosDTO usuarioDTO) {
        Usuarios usuario = MapperUtils.EntityFromDto(usuarioDTO, Usuarios.class);
        Usuarios usuarioCreated = usuarioRepository.save(usuario);
        return MapperUtils.DtoFromEntity(usuarioCreated, UsuariosDTO.class);
    }

    @Override
    @Transactional
    public Optional<UsuariosDTO> create(UsuariosDTO usuarioDTO) {
        return Optional.ofNullable(getSavedUsuarioDTO(usuarioDTO));
    }


    @Override
    @Transactional
    public Optional<UsuariosDTO> update(UsuariosDTO usuarioDTO, Long id) {
        if (usuarioRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(getSavedUsuarioDTO(usuarioDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        usuarioRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuariosDTO> login(String cedula, String claveEncriptado) {
        Usuarios usuario = usuarioRepository.findByCedulaAndClaveEncriptado(cedula, claveEncriptado);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(usuario, UsuariosDTO.class));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuariosDTO> findByCedula(String cedula) {
        Optional<Usuarios> usuario = usuarioRepository.findByCedula(cedula);
        return Optional.ofNullable(MapperUtils.DtoFromEntity(usuario, UsuariosDTO.class));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuariosDTO> findById(Long id) {
        Optional<Usuarios> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) throw new NotFoundInformationException();

        UsuariosDTO usuarioDTO = MapperUtils.DtoFromEntity(usuario.get(), UsuariosDTO.class);
        return Optional.ofNullable(usuarioDTO);

    }


    @Override
    @Transactional(readOnly = true)
    public Optional<List<UsuariosDTO>> findAll() {

        List<UsuariosDTO> usuarioDTOList = MapperUtils.DtoListFromEntityList(usuarioRepository.findAll(), UsuariosDTO.class);
        return Optional.ofNullable(usuarioDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<UsuariosDTO>> findByCedulaAproximate(String cedula) {
        List<Usuarios> usuarioList = usuarioRepository.findByCedulaContaining(cedula);
        if (usuarioList.isEmpty()) throw new NotFoundInformationException();
        List<UsuariosDTO> usuarioDTOList = MapperUtils.DtoListFromEntityList(usuarioList, UsuariosDTO.class);
        return Optional.ofNullable(usuarioDTOList);
    }
}
