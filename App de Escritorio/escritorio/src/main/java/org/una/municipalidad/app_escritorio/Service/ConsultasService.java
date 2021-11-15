package org.una.municipalidad.app_escritorio.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.una.municipalidad.app_escritorio.DTO.*;
import org.una.municipalidad.app_escritorio.Util.AppContext;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ConsultasService {
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private static ObjectMapper mapper = new ObjectMapper();

    public static List<RolesDTO> RolCBX() throws IOException, InterruptedException {

        List<RolesDTO> rol = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/roles"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println("status "+response.statusCode());

        // print response body
        System.out.println("cuerpo "+response.body());

        rol = mapper.readValue(response.body(), new TypeReference<List<RolesDTO>>() {});


        return rol;

    }

    public static List<UsuariosDTO> ObtenerUsuario(String cedula) throws IOException, InterruptedException {

        List<UsuariosDTO> usurio = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/usuarios/findByCedulaAproximate/"+cedula+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        // print response body
        System.out.println("cuerpo "+response.body());
        usurio = mapper.readValue(response.body(), new TypeReference<List<UsuariosDTO>>() {});

        return usurio;

    }

    public static RolesDTO ObtenerRol(Long id) throws IOException, InterruptedException {

        RolesDTO rol = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/roles/"+id+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        rol = mapper.readValue(response.body(), new TypeReference<RolesDTO>() {});

        return rol;

    }

    public static UsuariosDTO CrearUsuario(String nombreUsuario, String claveEncriptado, String cedula, boolean estado,RolesDTO roles) throws IOException, InterruptedException {
        long idd=8;
        UsuariosDTO usuario = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"nombreUsuario\":\"" )
                .append(nombreUsuario)
                .append("\",")
                .append("\"claveEncriptado\":\"" )
                .append(claveEncriptado)
                .append("\",")
                .append("\"cedula\":\"" )
                .append(cedula)
                .append("\",")
                .append("\"estado\":\"" )
                .append(estado)
                .append("\",")
                .append("\"roles\":{" )
                .append("\"id\":\"" )
                .append(roles.getId())
                .append("\"}")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/usuarios/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        usuario = mapper.readValue(response.body(), new TypeReference<UsuariosDTO>() {});
        return usuario;

    }

    public static ParametrosDTO CrearParametro(String llaveParametro, String valorParametro) throws IOException, InterruptedException {
        long idd=8;
        ParametrosDTO parametro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"llaveParametro\":\"" )
                .append(llaveParametro)
                .append("\",")
                .append("\"valorParametro\":\"" )
                .append(valorParametro)
                .append("\"")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/parametros/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        parametro = mapper.readValue(response.body(), new TypeReference<ParametrosDTO>() {});
        return parametro;

    }

    public static ParametrosDTO ObtenerParametro(String llave) throws IOException, InterruptedException {

        ParametrosDTO parametro = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/parametros/findByLlaveParametro/"+llave+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        parametro = mapper.readValue(response.body(), new TypeReference<ParametrosDTO>() {});

        return parametro;

    }


}