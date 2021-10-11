package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.AuthenticationRequest;
import org.una.municipalidad.dto.AuthenticationResponse;
import org.una.municipalidad.dto.UsuariosDTO;
import org.una.municipalidad.exceptions.InvalidCredentialsException;
import org.una.municipalidad.exceptions.MissingInputsException;
import org.una.municipalidad.services.LoginService;


import javax.validation.Valid;
@RestController
@RequestMapping("/login")
@Api(tags = {"Login"})
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("")
    @ResponseBody
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = UsuariosDTO.class, tags = "Seguridad")
    public ResponseEntity<?> login2(@Valid @RequestBody AuthenticationRequest authenticationRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { throw new MissingInputsException();  }
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        AuthenticationResponse token = loginService.login2(authenticationRequest);
        if (token.getJwt() != null)  {
            return new ResponseEntity(loginService.login2(authenticationRequest), HttpStatus.OK);
        } else {
            throw new InvalidCredentialsException();
        }
    }
}
