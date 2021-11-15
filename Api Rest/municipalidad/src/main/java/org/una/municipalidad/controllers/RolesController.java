package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.DeclaracionesDTO;
import org.una.municipalidad.dto.RolesDTO;
import org.una.municipalidad.dto.RolesDTO;
import org.una.municipalidad.services.RolesService;
import org.una.municipalidad.services.UsuariosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@Api(tags = {"Roles"})
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los roles", response = RolesDTO.class, responseContainer = "List", tags = "Roles")
    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR') or hasRole('GERENTE')")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<RolesDTO>> result = rolesService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un rol a partir de su id", response = RolesDTO.class, tags = "Roles")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<RolesDTO> rolFound = rolesService.findById(id);
        return new ResponseEntity<>(rolFound, HttpStatus.OK);

    }

    @GetMapping("/findByNombreRolAproximateIgnoreCase/{term}")
    @ApiOperation(value = "Obtiene una lista de los nombres de los roles", response = RolesDTO.class, responseContainer = "List", tags = "Roles")
    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR') or hasRole('GERENTE')")
    public ResponseEntity<?> findByNombreRolAproximateIgnoreCase(@PathVariable(value = "term") String term) {
        Optional<List<RolesDTO>> result = rolesService.findByNombreRolAproximateIgnoreCase(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> create(@RequestBody RolesDTO rolesDTO) {
        try {
            Optional<RolesDTO> rolesCreated = rolesService.create(rolesDTO);
            return new ResponseEntity<>(rolesCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza por medio del id los roles", response = RolesDTO.class, tags = "Roles")
    @ResponseBody
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody RolesDTO rolesModified) {
        Optional<RolesDTO> rolesUpdated = rolesService.update(rolesModified, id);
        return new ResponseEntity<>(rolesUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina un rol por medio del id", response = DeclaracionesDTO.class, tags = "Roles")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
            rolesService.delete(id);
            return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina todos los roles", response = DeclaracionesDTO.class, tags = "Roles")
    @DeleteMapping("/")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<?> deleteAll() throws Exception {
        rolesService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
