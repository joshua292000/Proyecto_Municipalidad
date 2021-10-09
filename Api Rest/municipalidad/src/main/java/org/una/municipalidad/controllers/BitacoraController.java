package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.BitacorasDTO;
import org.una.municipalidad.services.BitacorasService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/bitacora")
@Api(tags = {"Bitacora"})
public class BitacoraController {

    @Autowired
    private BitacorasService bitacoraService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todas las Licencias Comerciales.", response = BitacorasDTO.class, responseContainer = "List", tags = "Bitacora")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<BitacorasDTO>> result = bitacoraService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una bitacora a partir de su id", response = BitacorasDTO.class, tags = "Bitacora")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<BitacorasDTO> bitacoraFound = bitacoraService.findById(id);
        return new ResponseEntity<>(bitacoraFound, HttpStatus.OK);
    }

    @GetMapping("/{codigoComercio}")
    @ApiOperation(value = "Obtiene una tabal de la bitacora", response = BitacorasDTO.class, tags = "Bitacora")
    public ResponseEntity<?> findByBitacoraTabla(@PathVariable(value = "bitacoraTabla") String bitacoraTabla) {
        Optional<BitacorasDTO> bitacoraFound = bitacoraService.findByBitacoraTabla(bitacoraTabla);
        return new ResponseEntity<>(bitacoraFound, HttpStatus.OK);
    }

    @GetMapping("/{nombreComercio}")
    @ApiOperation(value = "Obtiene una descripcion de la bitacora", response = BitacorasDTO.class, tags = "Bitacora")
    public ResponseEntity<?> findByBitacoraDescripcion(@PathVariable(value = "bitacoraDescripcion") String bitacoraDescripcion) {
        Optional<BitacorasDTO> bitacoraFound = bitacoraService.findByBitacoraDescripcion(bitacoraDescripcion);
        return new ResponseEntity<>(bitacoraFound, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody BitacorasDTO bitacoraDTO) {
        try {
            Optional<BitacorasDTO> bitacoraCreated = bitacoraService.create(bitacoraDTO);
            return new ResponseEntity<>(bitacoraCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza por medio del id", response = BitacorasDTO.class, tags = "Seguridad")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody BitacorasDTO bitacoraModified) {
        Optional<BitacorasDTO> bitacoraUpdated = bitacoraService.update(bitacoraModified, id);
        return new ResponseEntity<>(bitacoraUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina una bitacora por medio del id", response = BitacorasDTO.class, tags = "Seguridad")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        bitacoraService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina todas las bitacoras", response = BitacorasDTO.class, tags = "Seguridad")
    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() throws Exception {
        bitacoraService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);

    }
}
