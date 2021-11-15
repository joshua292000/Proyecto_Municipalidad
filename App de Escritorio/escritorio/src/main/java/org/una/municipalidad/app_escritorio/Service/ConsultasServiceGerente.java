package org.una.municipalidad.app_escritorio.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.Alert;
import org.una.municipalidad.app_escritorio.DTO.*;
import org.una.municipalidad.app_escritorio.Util.AppContext;
import org.una.municipalidad.app_escritorio.Util.Mensaje;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class ConsultasServiceGerente {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private static ObjectMapper mapper = new ObjectMapper();

    public static List<CobrosDTO> obtenerTodoCobro() throws IOException, InterruptedException {
        List<CobrosDTO> cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("No se encontro información en su solicitud, revise su petición")){
            cobro=null;
        }else{
            cobro = mapper.readValue(response.body(), new TypeReference<List<CobrosDTO>>() {});
        }
        return cobro;
    }

    public static List<CobrosDTO> obtenerTodoCobroXEsatado(String parametro) throws IOException, InterruptedException {
        List<CobrosDTO> cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/findByEstado/"+parametro+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        cobro = mapper.readValue(response.body(), new TypeReference<List<CobrosDTO>>() {});
        System.out.print("cobro "+cobro);
        return cobro;
    }

    public static List<CobrosDTO> obtenerTodoCobroXFechas(LocalDate inicio, LocalDate fin) throws IOException, InterruptedException {
        List<CobrosDTO> cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/findByCobrosBetweenFechaPago/"+inicio+"/"+fin))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        cobro = mapper.readValue(response.body(), new TypeReference<List<CobrosDTO>>() {});
        System.out.print("cobro "+cobro);
        return cobro;
    }
    public static List<ContribuyentesDTO> obtenerTodoContribuyente() throws IOException, InterruptedException {
        List<ContribuyentesDTO> contribuyente = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/contribuyentes"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("No se encontro información en su solicitud, revise su petición")){
            contribuyente=null;
        }else{
            contribuyente = mapper.readValue(response.body(), new TypeReference<List<ContribuyentesDTO>>() {});
        }
        return contribuyente;
    }
    public static List<LicenciasComercialesDTO> obtenerTodoLicencias() throws IOException, InterruptedException {
        List<LicenciasComercialesDTO> LicenciasComerciales = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/licenciasComerciales"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("No se encontro información en su solicitud, revise su petición")){
            LicenciasComerciales=null;
        }else{
            LicenciasComerciales = mapper.readValue(response.body(), new TypeReference<List<LicenciasComercialesDTO>>() {});
        }
        return LicenciasComerciales;
    }

    public static List<LicenciasComercialesDTO> obtenerTodoLicenciasxEstado(String parametro) throws IOException, InterruptedException {
        List<LicenciasComercialesDTO> LicenciasComerciales = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/licenciasComerciales/findByEstado/"+parametro+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("No se encontro información en su solicitud, revise su petición")){
            LicenciasComerciales=null;
        }else{
            LicenciasComerciales = mapper.readValue(response.body(), new TypeReference<List<LicenciasComercialesDTO>>() {});
        }
        System.out.print("LicenciasComerciales "+LicenciasComerciales);
        return LicenciasComerciales;
    }

    public static List<LocalesMercadoDTO> obtenerTodoLocales() throws IOException, InterruptedException {
        List<LocalesMercadoDTO> LocalesMercado = null;
        System.out.print("Roll "+AppContext.getInstance().get("rol"));
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        System.out.print("Token "+token.getJwt());
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/licenciasComerciales"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("No se encontro información en su solicitud, revise su petición")){
            LocalesMercado=null;
        }else{
            LocalesMercado = mapper.readValue(response.body(), new TypeReference<List<LocalesMercadoDTO>>() {});
        }
        return LocalesMercado;
    }

    public static List<LocalesMercadoDTO> obtenerTodoLocalesxEstado(String parametro) throws IOException, InterruptedException {
        List<LocalesMercadoDTO> LocalesMercado = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/localesmercado/findByEstado/"+parametro+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("No se encontro información en su solicitud, revise su petición")){
            LocalesMercado=null;
        }else{
            LocalesMercado = mapper.readValue(response.body(), new TypeReference<List<LocalesMercadoDTO>>() {});
        }
        System.out.print("LocalesMercado "+LocalesMercado);
        return LocalesMercado;
    }

    public static List<PropiedadesDTO> obtenerTodoPropiedades() throws IOException, InterruptedException {
        List<PropiedadesDTO> Propiedades = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/propiedades"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("No se encontro información en su solicitud, revise su petición")){
            Propiedades=null;
        }else{
            Propiedades = mapper.readValue(response.body(), new TypeReference<List<PropiedadesDTO>>() {});
        }
        return Propiedades;
    }

    public static List<PropiedadesDTO> obtenerTodoPropiedadesxEstado(String parametro) throws IOException, InterruptedException {
        List<PropiedadesDTO> Propiedades = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/propiedades/findByEstado/"+parametro+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("No se encontro información en su solicitud, revise su petición")){
            Propiedades=null;
        }else{
            Propiedades = mapper.readValue(response.body(), new TypeReference<List<PropiedadesDTO>>() {});
        }
        System.out.print("Propiedades "+Propiedades);
        return Propiedades;
    }

    public static PropiedadesDTO EliminarTodoPropiedadesxEstado() throws IOException, InterruptedException {
        PropiedadesDTO Propiedades = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/propiedades/EliminarPropiedades"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 500){
            Mensaje.show(Alert.AlertType.ERROR,"","No se generaron cobros");
            Propiedades=null;
        }
        return Propiedades;
    }

    public static CobrosDTO EliminarTodoCobrosxEstado() throws IOException, InterruptedException {
        CobrosDTO cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/cobrosmasivos"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 500){
            Mensaje.show(Alert.AlertType.ERROR,"","No se generaron cobros");
            cobro=null;
        }
        return cobro;
    }

    public static LocalesMercadoDTO EliminarTodoLocalesxEstado() throws IOException, InterruptedException {
        LocalesMercadoDTO local = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/localesmercado/EliminarLocales"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 500){
            Mensaje.show(Alert.AlertType.ERROR,"","No se generaron cobros");
            local=null;
        }
        return local;
    }

    public static LicenciasComercialesDTO EliminarTodoLicenciasxEstado() throws IOException, InterruptedException {
        LicenciasComercialesDTO Lice = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/licenciasComerciales/EliminarLicencia"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 500){
            Mensaje.show(Alert.AlertType.ERROR,"","No se generaron cobros");
            Lice=null;
        }
        return Lice;
    }
    public static List<ParametrosDTO> obtenerTodoParametros() throws IOException, InterruptedException {
        List<ParametrosDTO> para = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/parametros"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        para = mapper.readValue(response.body(), new TypeReference<List<ParametrosDTO>>() {});
        System.out.print("cobro "+para);
        return para;
    }

    public static CobrosDTO CrearCobrosMasivosxpropiedad() throws IOException, InterruptedException {
        CobrosDTO cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/CobrosMasivoPropiedades"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 500){
            Mensaje.show(Alert.AlertType.ERROR,"","No se generaron cobros");
            cobro=null;
        }
        return cobro;
    }

    public static CobrosDTO CrearCobrosMasivosxLocal() throws IOException, InterruptedException {
        CobrosDTO cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/CobrosMasivosLocales"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 500){
            Mensaje.show(Alert.AlertType.ERROR,"","No se generaron cobros");
            cobro=null;
        }
        return cobro;
    }

    public static CobrosDTO CrearCobrosMasivosxLicencias() throws IOException, InterruptedException {
        CobrosDTO cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/CobrosMasivoLicencias"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 500){
            Mensaje.show(Alert.AlertType.ERROR,"","No se generaron cobros");
            cobro=null;
        }
        return cobro;
    }
}
