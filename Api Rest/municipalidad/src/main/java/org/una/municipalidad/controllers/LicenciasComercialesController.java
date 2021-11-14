package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.Contribuyentes_Licencias_ComercialesDTO;
import org.una.municipalidad.dto.DeclaracionesDTO;
import org.una.municipalidad.dto.LicenciasComercialesDTO;
import org.una.municipalidad.services.LicenciasComercialesService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/licenciasComerciales")
@Api(tags = {"LicenciasComerciales"})
public class LicenciasComercialesController {

    @Autowired
    private LicenciasComercialesService licenciaComercialService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todas las Licencias Comerciales", response = LicenciasComercialesDTO.class, responseContainer = "List", tags = "LicenciasComerciales")
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE') or hasRole('AUDITOR')")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<LicenciasComercialesDTO>> result = licenciaComercialService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una licencia comercial a partir de su id", response = LicenciasComercialesDTO.class, tags = "LicenciasComerciales")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<LicenciasComercialesDTO> licenciaComercialFound = licenciaComercialService.findById(id);
        return new ResponseEntity<>(licenciaComercialFound, HttpStatus.OK);
    }

    @GetMapping("/{codigoComercio}")
    @ApiOperation(value = "Obtiene una licencia comercial a partir de su codigo", response = LicenciasComercialesDTO.class, tags = "LicenciasComerciales")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findByCodigoComercio(@PathVariable(value = "codigoComercio") String codigoComercio) {
        Optional<LicenciasComercialesDTO> licenciaComercialFound = licenciaComercialService.findByCodigoComercio(codigoComercio);
        return new ResponseEntity<>(licenciaComercialFound, HttpStatus.OK);
    }
    @GetMapping("/findByEstado/{Estado}")
    @ApiOperation(value = "Obtiene una licencia comercial a partir estado", response = LicenciasComercialesDTO.class, tags = "LicenciasComerciales")
    @PreAuthorize("hasRole('GERENTE')")
    public ResponseEntity<?> findByEstado(String Estado) {
        try{
            Optional<List<LicenciasComercialesDTO>> result = licenciaComercialService.findByEstado(Estado);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{nombreComercio}")
    @ApiOperation(value = "Obtiene una licencia comercial a partir de su nombre", response = LicenciasComercialesDTO.class, tags = "LicenciasComerciales")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findByNombreComercio(@PathVariable(value = "nombreComercio") String nombreComercio) {
        Optional<LicenciasComercialesDTO> licenciaComercialFound = licenciaComercialService.findByNombreComercio(nombreComercio);
        return new ResponseEntity<>(licenciaComercialFound, HttpStatus.OK);
    }

    @GetMapping("/findLicencias_ComercialesByCedula/{cedulaContribuyente}")
    @ApiOperation(value = "Obtiene una lista de licencias comerciales a partir de la cedula de un contribuyente", response = ContribuyentesDTO.class, tags = "LicenciasComerciales")
    @PreAuthorize("hasRole('GESTOR') or hasRole('BOT')")
    public ResponseEntity<?> findLicencias_ComercialesByCedula(@PathVariable(value = "cedulaContribuyente")String cedulaContribuyente) {
        try{
            Optional<List<LicenciasComercialesDTO>> result = licenciaComercialService.findLicencias_ComercialesByCedula(cedulaContribuyente);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> create(@RequestBody LicenciasComercialesDTO licenciaComercialDTO) {
        try {
            Optional<LicenciasComercialesDTO> licenciaComercialCreated = licenciaComercialService.create(licenciaComercialDTO);
            return new ResponseEntity<>(licenciaComercialCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza por medio del id", response = LicenciasComercialesDTO.class, tags = "LicenciasComerciales")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody LicenciasComercialesDTO licenciaComercialModified) {
        Optional<LicenciasComercialesDTO> licenciaComercialUpdated = licenciaComercialService.update(licenciaComercialModified, id);
        return new ResponseEntity<>(licenciaComercialUpdated, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina una licencia comercial por medio del id", response = LicenciasComercialesDTO.class, tags = "LicenciasComerciales")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        licenciaComercialService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina todas las licencias comerciales", response = LicenciasComercialesDTO.class, tags = "LicenciasComerciales")
    @DeleteMapping("/")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> deleteAll() throws Exception {
        licenciaComercialService.deleteAll();
        return new ResponseEntity<>("Ok", HttpStatus.OK);

    }
}
