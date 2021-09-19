package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.PermisosDTO;
import org.una.municipalidad.services.PermisosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permisos")
@Api(tags = {"Permisos"})

public class PermisosController {
    @Autowired
    private PermisosService permisosService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los permisos", response = PermisosDTO.class, responseContainer = "List", tags = "Permisos")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<PermisosDTO>> result = permisosService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un permiso a partir de su id", response = PermisosDTO.class, tags = "Permisos")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<PermisosDTO> rolFound = permisosService.findById(id);
        return new ResponseEntity<>(rolFound, HttpStatus.OK);

    }
    /*
    @PutMapping("/login")
    @ResponseBody
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = RolesDTO.class, tags = "Seguridad")
    public ResponseEntity<?> login(@PathVariable(value = "nombreUsuario") String nombreUsuario, @PathVariable(value = "claveEncriptado") String claveEncriptado) {
        Optional<RolesDTO> usuarioFound = usuarioService.login(nombreUsuario, claveEncriptado);
        return new ResponseEntity<>(usuarioFound, HttpStatus.OK);
    }

    @GetMapping("/usuario/{term}")
    @ApiOperation(value = "Obtiene una lista de las usuarios", response = RolesDTO.class, responseContainer = "List", tags = "Usuarios")
    public ResponseEntity<?> findByNombreUsuarioAproximate(@PathVariable(value = "term") String term) {
        Optional<List<RolesDTO>> result = usuarioService.findByNombreUsuarioAproximate(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/nombre/{term}")
    @ApiOperation(value = "Obtiene una lista de los usuarios", response = RolesDTO.class, responseContainer = "List", tags = "Usuarios")
    public ResponseEntity<?> findByNombreUsuarioAproximateIgnoreCase(@PathVariable(value = "term") String term) {
        Optional<List<RolesDTO>> result = usuarioService.findByNombreUsuarioAproximateIgnoreCase(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }*/


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody PermisosDTO permisosDTO) {
        try {
            Optional<PermisosDTO> permisosCreated = permisosService.create(permisosDTO);
            return new ResponseEntity<>(permisosCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza por medio del id", response = PermisosDTO.class, tags = "Seguridad")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody PermisosDTO rolesModified) {
        Optional<PermisosDTO> rolesUpdated = permisosService.update(rolesModified, id);
        return new ResponseEntity<>(rolesUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        try {
            permisosService.delete(id);
            return new ResponseEntity<>("Ok", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        //TODO: Implementar este método
        throw new Exception("Not implemented Function");
    }
}
