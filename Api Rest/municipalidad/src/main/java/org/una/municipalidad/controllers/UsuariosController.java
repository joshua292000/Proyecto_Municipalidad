package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.UsuariosDTO;
import org.una.municipalidad.services.UsuariosService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Usuarios")
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
    public ResponseEntity<?> findById(@PathVariable(value = "Id") Long Id) {
        Optional<UsuariosDTO> usuarioFound = usuarioService.findById(Id);
        return new ResponseEntity<>(usuarioFound, HttpStatus.OK);

    }

    @PutMapping("/login")
    @ResponseBody
    @ApiOperation(value = "Inicio de sesión para conseguir un token de acceso", response = UsuariosDTO.class, tags = "Seguridad")
    public ResponseEntity<?> login(@PathVariable(value = "Usuario") String Usuario, @PathVariable(value = "Clave") String Clave) {
        Optional<UsuariosDTO> usuarioFound = usuarioService.login(Usuario, Clave);
        return new ResponseEntity<>(usuarioFound, HttpStatus.OK);
    }

    @GetMapping("/Usuario/{term}")
    @ApiOperation(value = "Obtiene una lista de los usuarios", response = UsuariosDTO.class, responseContainer = "List", tags = "Usuarios")
    public ResponseEntity<?> findByUsuarioIgnoreCase(@PathVariable(value = "term") String term) {
        Optional<List<UsuariosDTO>> result = usuarioService.findByUsuarioIgnoreCase(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/Usuario/{term}")
    @ApiOperation(value = "Obtiene una lista de las cedulas", response = UsuariosDTO.class, responseContainer = "List", tags = "Usuarios")
    public ResponseEntity<?> findByUsuarioAproximate(@PathVariable(value = "term") String term) {
        Optional<List<UsuariosDTO>> result = usuarioService.findByUsuarioAproximate(term);
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

    @PutMapping("/{Id}")
    @ApiOperation(value = "Actualiza por medio del id", response = UsuariosDTO.class, tags = "Seguridad")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "Id") Long Id, @RequestBody UsuariosDTO usuarioModified) {
        Optional<UsuariosDTO> usuarioUpdated = usuarioService.update(usuarioModified, Id);
        return new ResponseEntity<>(usuarioUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<?> delete(@PathVariable(value = "Id") Long Id) throws Exception {
        try {
            usuarioService.delete(Id);
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
