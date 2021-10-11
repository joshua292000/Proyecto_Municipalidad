package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.AuthenticationRequest;
import org.una.municipalidad.dto.AuthenticationResponse;
import org.una.municipalidad.dto.UsuariosDTO;
import org.una.municipalidad.exceptions.InvalidCredentialsException;
import org.una.municipalidad.exceptions.MissingInputsException;
import org.una.municipalidad.services.AutenticacionService;

import javax.validation.Valid;

@RestController
@RequestMapping("/autenticacion")
@Api(tags = {"Autenticaciones"})
public class AutenticacionController {

    @Autowired
    private AutenticacionService autenticacionService;

    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = UsuariosDTO.class, tags = "Autenticaciones")
    @PostMapping("")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new MissingInputsException();
        }
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        AuthenticationResponse token = autenticacionService.login(authenticationRequest);
        if (!token.getJwt().isEmpty()) {
            authenticationResponse.setJwt(token.getJwt());

            return new ResponseEntity(authenticationResponse, HttpStatus.OK);
        } else {
            throw new InvalidCredentialsException();
        }
    }
}
