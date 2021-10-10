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
import org.una.municipalidad.dto.DeclaracionesDTO;
import org.una.municipalidad.dto.UsuariosDTO;
import org.una.municipalidad.exceptions.InvalidCredentialsException;
import org.una.municipalidad.exceptions.MissingInputsException;
import org.una.municipalidad.services.UsuariosService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@Api(tags = {"Usuarios"})
public class UsuariosController {
    @Autowired
    private UsuariosService usuarioService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los Usuarios", response = UsuariosDTO.class, responseContainer = "List", tags = "Usuarios")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<UsuariosDTO>> result = usuarioService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una usuario a partir de su id", response = UsuariosDTO.class, tags = "Usuarios")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<UsuariosDTO> usuarioFound = usuarioService.findById(id);
        return new ResponseEntity<>(usuarioFound, HttpStatus.OK);

    }

   @PutMapping("/login")
    @ResponseBody
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = UsuariosDTO.class, tags = "Seguridad")
    public ResponseEntity<?> login(@PathVariable(value = "nombreUsuario") String nombreUsuario, @PathVariable(value = "claveEncriptado") String claveEncriptado) {
        Optional<UsuariosDTO> usuarioFound = usuarioService.login(nombreUsuario, claveEncriptado);
        return new ResponseEntity<>(usuarioFound, HttpStatus.OK);
    }

    @PutMapping("/")
    @ResponseBody
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = UsuariosDTO.class, tags = "Seguridad")
    public ResponseEntity<?> login2( @Valid @RequestBody AuthenticationRequest authenticationRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { throw new MissingInputsException();  }
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();

        //String token = usuarioService.login(authenticationRequest);
        AuthenticationResponse token = usuarioService.login2(authenticationRequest);
        if (token.getJwt() != null)  {
            authenticationResponse.setJwt(token.getJwt());
            //authenticationResponse.setJwt(token);
            //return new ResponseEntity<>(usuarioFound, HttpStatus.OK);
            //TODO: Complete this   authenticationResponse.setUsuario(usuario);
            //TODO: Complete this    authenticationResponse.setPermisos(permisosOtorgados);
            return new ResponseEntity(authenticationResponse, HttpStatus.OK);
        } else {
            throw new InvalidCredentialsException();
        }
    }


    @GetMapping("/cedula/{term}")
    @ApiOperation(value = "Obtiene una lista de las cedulas", response = UsuariosDTO.class, responseContainer = "List", tags = "Usuarios")
    public ResponseEntity<?> findByCedulaAproximate(@PathVariable(value = "term") String term) {
        Optional<List<UsuariosDTO>> result = usuarioService.findByCedulaAproximate(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/nombre/{term}")
    @ApiOperation(value = "Obtiene una lista de los nombres de los usuarios", response = UsuariosDTO.class, responseContainer = "List", tags = "Usuarios")
    public ResponseEntity<?> findByNombreUsuarioAproximateIgnoreCase(@PathVariable(value = "term") String term) {
        Optional<List<UsuariosDTO>> result = usuarioService.findByNombreUsuarioAproximateIgnoreCase(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody UsuariosDTO usuarioDTO) {
        try {
            Optional<UsuariosDTO> usuarioCreated = usuarioService.create(usuarioDTO);
            return new ResponseEntity<>(usuarioCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza por medio del id", response = UsuariosDTO.class, tags = "Seguridad")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody UsuariosDTO usuarioModified) {
        Optional<UsuariosDTO> usuarioUpdated = usuarioService.update(usuarioModified, id);
        return new ResponseEntity<>(usuarioUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina un usuario por medio del id", response = DeclaracionesDTO.class, tags = "Seguridad")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        usuarioService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina todos los usuarios", response = DeclaracionesDTO.class, tags = "Seguridad")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        usuarioService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
