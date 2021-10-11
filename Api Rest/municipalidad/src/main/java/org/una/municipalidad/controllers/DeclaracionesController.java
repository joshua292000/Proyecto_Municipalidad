package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.DeclaracionesDTO;
import org.una.municipalidad.services.DeclaracionesService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/declaraciones")
@Api(tags = {"Declaraciones"})

public class DeclaracionesController {

    @Autowired
    private DeclaracionesService declaracionService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todas las declaraciones", response = DeclaracionesDTO.class, responseContainer = "List", tags = "Declaraciones")
    @PreAuthorize("hasRole('GERENTE') or hasRole('AUDITOR') or hasRole('GESTOR')")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<DeclaracionesDTO>> result = declaracionService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una declaracion a partir de su id", response = DeclaracionesDTO.class, tags = "Declaraciones")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<DeclaracionesDTO> declaracionFound = declaracionService.findById(id);
        return new ResponseEntity<>(declaracionFound, HttpStatus.OK);
    }

    @GetMapping("/montoDeclarado/{term}")
    @ApiOperation(value = "Obtiene una lista de los montos declarados", response = DeclaracionesDTO.class, responseContainer = "List", tags = "Declaraciones")
    @PreAuthorize("hasRole('GERENTE') or hasRole('AUDITOR')")
    public ResponseEntity<?> findByMontoDeclarado(@PathVariable(value = "term") long term) {
        Optional<List<DeclaracionesDTO>> result = declaracionService.findByMontoDeclarado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/id/{term}")
    @ApiOperation(value = "Obtiene una lista de los años declarados por medio del id", response = DeclaracionesDTO.class, responseContainer = "List", tags = "Declaraciones")
    @PreAuthorize("hasRole('GERENTE') or hasRole('AUDITOR')")
    public ResponseEntity<?> findByIdAndFechaDeclarado(@PathVariable(value = "term") Long term, Date fechaDeclarado) {
        Optional<List<DeclaracionesDTO>> result = declaracionService.findByIdAndFechaDeclarado(term, fechaDeclarado);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> create(@RequestBody DeclaracionesDTO declaracionDTO) {
        try {
            Optional<DeclaracionesDTO> declaracionCreated = declaracionService.create(declaracionDTO);
            return new ResponseEntity<>(declaracionCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza por medio del id", response = DeclaracionesDTO.class, tags = "Declaraciones")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody DeclaracionesDTO declaracionModified) {
        Optional<DeclaracionesDTO> declaracionUpdated = declaracionService.update(declaracionModified, id);
        return new ResponseEntity<>(declaracionUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina una declaracion por medio del id", response = DeclaracionesDTO.class, tags = "Declaraciones")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
            declaracionService.delete(id);
            return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina todas las declaraciones", response = DeclaracionesDTO.class, tags = "Declaraciones")
    @DeleteMapping("/")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> deleteAll() throws Exception {
        declaracionService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);

    }
}
