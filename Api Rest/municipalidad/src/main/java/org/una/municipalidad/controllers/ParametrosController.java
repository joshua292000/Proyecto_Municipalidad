package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.ParametrosDTO;
import org.una.municipalidad.dto.RolesDTO;
import org.una.municipalidad.services.ParametrosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parametros")
@Api(tags = {"Parametros"})

public class ParametrosController {
    @Autowired
    private ParametrosService parametrosService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los parametros", response = ParametrosDTO.class, responseContainer = "List", tags = "Parametros")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ParametrosDTO>> result = parametrosService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un parametro a partir de su id", response = RolesDTO.class, tags = "Parametros")
    //@PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ParametrosDTO> parametroFound = parametrosService.findById(id);
        return new ResponseEntity<>(parametroFound, HttpStatus.OK);

    }

    @GetMapping("/{parametrosLlaves}")
    @ApiOperation(value = "Obtiene un parametro a partir de su llave", response = ParametrosDTO.class, tags = "Parametros")
    public ResponseEntity<?> findByParametrosLlaves(@PathVariable(value = "parametrosLlaves") String parametrosLlaves) {
        Optional<ParametrosDTO> parametroFound = parametrosService.findByParametrosLlaves(parametrosLlaves);
        return new ResponseEntity<>(parametroFound, HttpStatus.OK);
    }

    @GetMapping("/{parametrosValor}")
    @ApiOperation(value = "Obtiene un parametro a partir de su valor", response = ParametrosDTO.class, tags = "Parametros")
    public ResponseEntity<?> findByParametrosValor(@PathVariable(value = "parametrosValor") String parametrosValor) {
        Optional<ParametrosDTO> parametroFound = parametrosService.findByParametrosValor(parametrosValor);
        return new ResponseEntity<>(parametroFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ParametrosDTO parametrosDTO) {
        try {
            Optional<ParametrosDTO> parametrosCreated = parametrosService.create(parametrosDTO);
            return new ResponseEntity<>(parametrosCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza por medio del id ", response = ParametrosDTO.class, tags = "Parametros")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ParametrosDTO paramentrosModified) {
        Optional<ParametrosDTO> parametrosUpdated = parametrosService.update(paramentrosModified, id);
        return new ResponseEntity<>(parametrosUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina los parametros por medio del id", response = ParametrosDTO.class, tags = "Parametros")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        parametrosService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina todos los parametros", response = ParametrosDTO.class, tags = "Parametros")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        parametrosService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);

    }
}
