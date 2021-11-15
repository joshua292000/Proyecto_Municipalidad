package org.una.municipalidad.app_escritorio.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.una.municipalidad.app_escritorio.DTO.AuthenticationResponse;
import org.una.municipalidad.app_escritorio.DTO.BitacorasDTO;
import org.una.municipalidad.app_escritorio.DTO.DeclaracionesDTO;
import org.una.municipalidad.app_escritorio.DTO.UsuariosDTO;
import org.una.municipalidad.app_escritorio.Util.AppContext;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class ConsultasServiceAuditor {
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private static ObjectMapper mapper = new ObjectMapper();

    public static List<BitacorasDTO> obtenerTodoMovimientos() throws IOException, InterruptedException {
        List<BitacorasDTO> bitacora = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/bitacora"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("No se encontro información en su solicitud, revise su petición")){
            bitacora=null;
        }else{
            bitacora = mapper.readValue(response.body(), new TypeReference<List<BitacorasDTO>>() {});
        }
        return bitacora;
    }

    public static List<DeclaracionesDTO> obtenerTodoDeclaraciones() throws IOException, InterruptedException {
        List<DeclaracionesDTO> declaracion = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/declaraciones"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("No se encontro información en su solicitud, revise su petición")){
            declaracion=null;
        }else{
           declaracion = mapper.readValue(response.body(), new TypeReference<List<DeclaracionesDTO>>() {});
        }
        return declaracion;
    }

    public static List<UsuariosDTO> usuarioCBX() throws IOException, InterruptedException {

        List<UsuariosDTO> usuarios = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/usuarios"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println("status " + response.statusCode());

        System.out.println("cuerpo " + response.body());

        usuarios = mapper.readValue(response.body(), new TypeReference<List<UsuariosDTO>>() {
        });

        return usuarios;
    }
    public static List<BitacorasDTO>ObtenerMovimientoUsuarioFecha(int id, LocalDate startDate, LocalDate endDate) throws IOException, InterruptedException {

        List<BitacorasDTO> movimientos = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/bitacora/findByIdBetweenFecha/"+id+"/"+startDate+"/"+endDate))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println("status "+response.statusCode());


        System.out.println("cuerpo "+response.body());

        movimientos = mapper.readValue(response.body(), new TypeReference<List<BitacorasDTO>>() {});


        return movimientos;

    }
    public static List<BitacorasDTO>ObtenerMovimientoUsuario(int id) throws IOException, InterruptedException {

        List<BitacorasDTO> movimientos = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/bitacora/findById/"+id))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println("status "+response.statusCode());


        System.out.println("cuerpo "+response.body());

        movimientos = mapper.readValue(response.body(), new TypeReference<List<BitacorasDTO>>() {});


        return movimientos;

    }
    }
