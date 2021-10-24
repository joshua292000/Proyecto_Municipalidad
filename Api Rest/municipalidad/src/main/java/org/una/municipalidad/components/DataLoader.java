package org.una.municipalidad.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.una.municipalidad.dto.ParametrosDTO;
import org.una.municipalidad.dto.RolesDTO;
import org.una.municipalidad.dto.UsuariosDTO;
import org.una.municipalidad.services.ParametrosService;
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
    private ParametrosService parametroService;


    @Override
    public void run(ApplicationArguments args) {
        if (usuarioService.findByCedulaAproximate(cedula).get().size()==0) {

            Optional<RolesDTO> gestorRol = rolService.create(RolesDTO.builder().nombreRol(RolesTypes.ROLE_GESTOR.name()).build());
            Optional<RolesDTO> gerenteRol = rolService.create(RolesDTO.builder().nombreRol(RolesTypes.ROLE_GERENTE.name()).build());
            Optional<RolesDTO> administradorRol = rolService.create(RolesDTO.builder().nombreRol(RolesTypes.ROLE_ADMINISTRADOR.name()).build());
            Optional<RolesDTO> auditorRol = rolService.create(RolesDTO.builder().nombreRol(RolesTypes.ROLE_AUDITOR.name()).build());

            UsuariosDTO cajeroUsuario = UsuariosDTO.builder()
                    .cedula("0123456789")
                    .nombreUsuario("Panchito")
                    .claveEncriptado("agapito123")
                    .estado(true)
                    .roles(gestorRol.orElseThrow()).build();
            usuarioService.create(cajeroUsuario);

            UsuariosDTO auditorUsuario = UsuariosDTO.builder()
                    .cedula("0948242")
                    .nombreUsuario("Panchita")
                    .claveEncriptado("agapita123")
                    .estado(true)
                    .roles(auditorRol.orElseThrow()).build();
            usuarioService.create(auditorUsuario);

            UsuariosDTO gestorUsuario = UsuariosDTO.builder()
                    .cedula("9876543210")
                    .nombreUsuario("Kevin")
                    .claveEncriptado("SoyelKevin")
                    .estado(true)
                    .roles(gestorRol.orElseThrow()).build();
            usuarioService.create(gestorUsuario);

            UsuariosDTO administradorUsuario = UsuariosDTO.builder()
                    .cedula(cedula)
                    .nombreUsuario("Joshua")
                    .claveEncriptado(claveEncriptado)
                    .estado(true)
                    .roles(administradorRol.orElseThrow()).build();
            usuarioService.create(administradorUsuario);

            UsuariosDTO gerenteUsuario = UsuariosDTO.builder()
                    .cedula("11833091")
                    .nombreUsuario("Josselyn")
                    .claveEncriptado("Nadiepasadeestaesquina")
                    .estado(true)
                    .roles(gerenteRol.orElseThrow()).build();
            usuarioService.create(gerenteUsuario);

            ParametrosDTO horario = ParametrosDTO.builder()
                            .llaveParametro("Horario")
                                    .valorParametro("5am.5pm")
                                            .build();
            parametroService.create(horario);

            ParametrosDTO formula1 = ParametrosDTO.builder()
                    .llaveParametro("Formula impuesto de licencia comercial")
                    .valorParametro("Ganancias declaradas * 0,2%.")
                    .build();
            parametroService.create(formula1);

            ParametrosDTO formula2 = ParametrosDTO.builder()
                    .llaveParametro("Formula bienes inmuebles")
                    .valorParametro("Valor anual del total de la propiedad * 0,025.")
                    .build();
            parametroService.create(formula2);

            ParametrosDTO formula3 = ParametrosDTO.builder()
                    .llaveParametro("Formula locales de mercado")
                    .valorParametro("Este impuesto se cobra mensualmente la cantidad acordada,sin embargo cada dos meses aumenta un 2%.")
                    .build();
            parametroService.create(formula3);

            System.out.println("Se agrega el usuario inicial a la aplicación");
        }else {
            System.out.println("Se encontro el usuario administrador, continuando...");
        }
    }
}
