package org.una.municipalidad.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.una.municipalidad.dto.ContribuyentesDTO;
import org.una.municipalidad.dto.LicenciasComercialesDTO;
import org.una.municipalidad.dto.LocalesMercadoDTO;
import org.una.municipalidad.services.LocalesMercadoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/localesmercado")
@Api(tags = {"LocalesMercado"})
public class LocalesMercadoController {
    @Autowired
    private LocalesMercadoService localesMercadoService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los locales de mercado", response = LocalesMercadoDTO.class, responseContainer = "List", tags = "LocalesMercado")
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE') or hasRole('AUDITOR')")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<LocalesMercadoDTO>> result = localesMercadoService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findByEstado/{Estado}")
    @ApiOperation(value = "Obtiene un local del mercado a partir de su estado", response = LocalesMercadoDTO.class, tags = "LocalesMercado")
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE')")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "Estado") String Estado) {
        try{
            Optional<List<LocalesMercadoDTO>> result = localesMercadoService.findByEstado(Estado);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un local del mercado a partir de su id", response = LocalesMercadoDTO.class, tags = "LocalesMercado")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<LocalesMercadoDTO> localesMercadoFound = localesMercadoService.findById(id);
        return new ResponseEntity<>(localesMercadoFound, HttpStatus.OK);

    }

    @GetMapping("/findByNombreLocal/{nombreLocal}")
    @ApiOperation(value = "Obtiene un local del mercado a partir de su nombre", response = LocalesMercadoDTO.class, tags = "LocalesMercado")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> findByNombreLocal(@PathVariable(value = "nombreLocal") String nombreLocal) {
        Optional<LocalesMercadoDTO>result = localesMercadoService.findByNombreLocal(nombreLocal);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findLocales_MercadoByCedula/{cedulaContribuyente}")
    @ApiOperation(value = "Obtiene una lista de locales de mercado a partir de la cedula de un contribuyente", response = ContribuyentesDTO.class, tags = "LicenciasComerciales")
    @PreAuthorize("hasRole('GESTOR') or hasRole('BOT') or hasRole('GERENTE')")
    public ResponseEntity<?> findLocales_MercadoByCedula(@PathVariable(value = "cedulaContribuyente")String cedulaContribuyente) {
        try{
            Optional<List<LocalesMercadoDTO>> result = localesMercadoService.findLocales_MercadoByCedula(cedulaContribuyente);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/EliminarLocales")
    @ApiOperation(value = "Precedimiento almacenado", response = LocalesMercadoDTO.class, tags = "LocalesMercado")
    @PreAuthorize("hasRole('GESTOR') or hasRole('GERENTE')")
    public ResponseEntity<?> EliminarLocales() {
        try{
            localesMercadoService.EliminarLocales();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> create(@RequestBody LocalesMercadoDTO localesMercadoDTO) {
        try {
            Optional<LocalesMercadoDTO> localesMercadoCreated = localesMercadoService.create(localesMercadoDTO);
            return new ResponseEntity<>(localesMercadoCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza la informacion", response = LocalesMercadoDTO.class, tags = "LocalesMercado")
    @ResponseBody
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id,@RequestBody LocalesMercadoDTO localesMercadoModified) {
        Optional<LocalesMercadoDTO> LocalesMercadoUpdated =  localesMercadoService.update(localesMercadoModified, id);
        return new ResponseEntity<>(LocalesMercadoUpdated, HttpStatus.OK);
    }


}
