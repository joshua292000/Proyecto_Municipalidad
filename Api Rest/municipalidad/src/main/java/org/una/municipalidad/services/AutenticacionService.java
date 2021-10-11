package org.una.municipalidad.services;

import org.una.municipalidad.dto.AuthenticationRequest;
import org.una.municipalidad.dto.AuthenticationResponse;

public interface AutenticacionService {

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest);
}
