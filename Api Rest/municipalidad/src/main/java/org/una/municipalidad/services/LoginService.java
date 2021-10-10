package org.una.municipalidad.services;

import org.una.municipalidad.dto.AuthenticationRequest;
import org.una.municipalidad.dto.AuthenticationResponse;

public interface LoginService {
    public AuthenticationResponse login2(AuthenticationRequest authenticationRequest);
}
