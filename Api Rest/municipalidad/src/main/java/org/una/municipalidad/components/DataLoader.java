package org.una.municipalidad.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.una.municipalidad.dto.RolesDTO;
import org.una.municipalidad.dto.UsuariosDTO;
import org.una.municipalidad.services.RolesService;
import org.una.municipalidad.services.UsuariosService;


import java.util.Optional;

@Component
public class DataLoader implements ApplicationRunner {
    @Value("${app.admin-user}")
    private String cedula;

    @Value("${app.claveEncriptado}")
    private String claveEncriptado;

    @Autowired
    private UsuariosService usuarioService;

    @Autowired
    private RolesService rolService;

    @Autowired
    //private DepartamentoService departamentoService;

    @Override
    public void run(ApplicationArguments args) {
        if (usuarioService.findByCedulaAproximate(cedula).get().size()==0) {
           /* Optional<DepartamentoDTO> contabilidadDepartamento = departamentoService.create(DepartamentoDTO.builder().nombre("Contabilidad").build());
            Optional<DepartamentoDTO> cajasDepartamento = departamentoService.create(DepartamentoDTO.builder().nombre("Cajas").build());
            Optional<DepartamentoDTO> informaticaDepartamento = departamentoService.create(DepartamentoDTO.builder().nombre("Informatica").build());
*/
            Optional<RolesDTO> colaboradorRol = rolService.create(RolesDTO.builder().nombreRol("Colaborador").build());
            Optional<RolesDTO> auditorRol = rolService.create(RolesDTO.builder().nombreRol("Auditor").build());
            Optional<RolesDTO> contadorRol = rolService.create(RolesDTO.builder().nombreRol("Contador").build());
            Optional<RolesDTO> usuarioRol = rolService.create(RolesDTO.builder().nombreRol("Usuario").build());
            Optional<RolesDTO> administradorRol = rolService.create(RolesDTO.builder().nombreRol("Administrador").build());

            UsuariosDTO cajeroUsuario = UsuariosDTO.builder()

                    .cedula("0123456789")
                    .nombreUsuario("Josselyne Mora")
                    .claveEncriptado("SoylaJoss")
                    .estado(true)
                    //.departamento(cajasDepartamento.orElseThrow())
                    .roles(usuarioRol.orElseThrow()).build();
            usuarioService.create(cajeroUsuario);

            UsuariosDTO contadorUsuario = UsuariosDTO.builder()
                    .cedula("9876543210")
                    .nombreUsuario("Kevin Mora")
                    .claveEncriptado("SoyelKevin")
                    .estado(true)
                    //.departamento(contabilidadDepartamento.orElseThrow())
                    .roles(contadorRol.orElseThrow()).build();
            usuarioService.create(contadorUsuario);

            UsuariosDTO administradorUsuario = UsuariosDTO.builder()
                    .cedula(cedula)
                    .nombreUsuario("Joshua Granados")
                    .claveEncriptado(claveEncriptado)
                    .estado(true)
                   // .departamento(informaticaDepartamento.orElseThrow())
                    .roles(administradorRol.orElseThrow()).build();
            usuarioService.create(administradorUsuario);

            System.out.println("Se agrega el usuario inicial a la aplicación");
        }else {
            System.out.println("Se encontro el usuario administrador, continuando...");
        }
    }
}
