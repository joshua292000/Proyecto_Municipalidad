package org.una.municipalidad.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.AuthenticationRequest;
import org.una.municipalidad.dto.AuthenticationResponse;
import org.una.municipalidad.dto.RolesDTO;
import org.una.municipalidad.dto.UsuariosDTO;
import org.una.municipalidad.exceptions.InvalidCredentialsException;
import org.una.municipalidad.jwt.JwtProvider;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Optional;


@Repository
public class AutenticacionServiceImplementation implements AutenticacionService{
    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AutenticacionServiceImplementation(){

    }

    @Override
    @Transactional(readOnly = true)
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {

        Optional<UsuariosDTO> usuario = usuariosService.findByCedula(authenticationRequest.getCedula());

        if (usuario.isPresent() &&  bCryptPasswordEncoder.matches(authenticationRequest.getClave(),usuario.get().getClaveEncriptado())) {
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getCedula(),
                    authenticationRequest.getClave()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            authenticationResponse.setJwt(jwtProvider.generateToken(authenticationRequest));
            UsuariosDTO usuarioDto = MapperUtils.DtoFromEntity(usuario.get(), UsuariosDTO.class);
            authenticationResponse.setUsuarioDTO(usuarioDto);
            authenticationResponse.setRolDTO(RolesDTO.builder().nombreRol(usuarioDto.getRoles().getNombreRol()).build());

            return authenticationResponse;
        } else {
            throw new InvalidCredentialsException();
        }
    }


}
