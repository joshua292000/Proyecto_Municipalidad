package org.una.municipalidad.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.municipalidad.dto.AuthenticationRequest;
import org.una.municipalidad.dto.AuthenticationResponse;
import org.una.municipalidad.dto.RolesDTO;
import org.una.municipalidad.dto.UsuariosDTO;
import org.una.municipalidad.entities.Usuarios;
import org.una.municipalidad.exceptions.InvalidCredentialsException;
import org.una.municipalidad.jwt.JwtProvider;
import org.una.municipalidad.repositories.UsuariosRepository;
import org.una.municipalidad.utils.MapperUtils;

import java.util.Optional;


@Service
public class LoginServiceImplementation implements LoginService {
    @Autowired
    private UsuariosRepository usuarioRepository;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    @Transactional(readOnly = true)
    public AuthenticationResponse login2(AuthenticationRequest authenticationRequest) {

        Optional<Usuarios> usuario = usuarioRepository.findByCedula(authenticationRequest.getCedula());

        if (usuario.isPresent() &&  bCryptPasswordEncoder.matches(authenticationRequest.getClaveEncriptado(),usuario.get().getClaveEncriptado())) {
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getCedula(), authenticationRequest.getClaveEncriptado()));
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
