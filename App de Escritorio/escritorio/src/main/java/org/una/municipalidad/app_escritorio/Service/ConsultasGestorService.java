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
import java.util.List;

public class ConsultasGestorService {
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private static ObjectMapper mapper = new ObjectMapper();

    public static ContribuyentesDTO CrearContribuyente(String Apellidos, String Cedula, String Nombre) throws IOException, InterruptedException {
        long idd=8;
        ContribuyentesDTO contribuyentes = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"apellidoContribuyente\":\"" )
                .append(Apellidos)
                .append("\",")
                .append("\"id\":\"" )
                .append(idd)
                .append("\",")
                .append("\"nombreContribuyente\":\"" )
                .append(Nombre)
                .append("\",")
                .append("\"cedulaContribuyente\":\"" )
                .append(Cedula)
                .append("\"")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/contribuyentes/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        contribuyentes = mapper.readValue(response.body(), new TypeReference<ContribuyentesDTO>() {});
        return contribuyentes;

    }

    public static ContribuyentesDTO ObtenerContribuyente(String cedula) throws IOException, InterruptedException {

        ContribuyentesDTO contribuyente = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/contribuyentes/findByCedulaContribuyente/"+cedula+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        contribuyente = mapper.readValue(response.body(), new TypeReference<ContribuyentesDTO>() {});

         return contribuyente;

    }

    public static LicenciasComercialesDTO CrearLicenciaComercial(String Nombre, Long Telefono, String correo, String distrito, LocalDate registro, LocalDate actualizacion, String codigo, String estado) throws IOException, InterruptedException {
        long idd=8;
        LicenciasComercialesDTO Licencia = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"nombreComercio\":\"" )
                .append(Nombre)
                .append("\",")
                .append("\"telefonoComercio\":\"" )
                .append(Telefono)
                .append("\",")
                .append("\"correoComercio\":\"" )
                .append(correo)
                .append("\",")
                .append("\"distritoComercio\":\"" )
                .append(distrito)
                .append("\",")
                .append("\"telefonoComercio\":\"" )
                .append(Telefono)
                .append("\",")
                .append("\"fechaRegistrocomercio\":\"" )
                .append(registro)
                .append("\",")
                .append("\"ultima_Actualizacioncomercio\":\"" )
                .append(actualizacion)
                .append("\",")
                .append("\"codigoComercio\":\"" )
                .append(codigo)
                .append("\",")
                .append("\"estado\":\"" )
                .append(estado)
                .append("\"")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/licenciasComerciales/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        // print response body
        System.out.println("cuerpo "+response.body());
        Licencia = mapper.readValue(response.body(), new TypeReference<LicenciasComercialesDTO>() {});
        return Licencia;

    }

    public static LocalesMercadoDTO CrearLocalMercado(String Nombre, String ubicacion, String correo, Long Telefono, Long Monto, LocalDate registro, LocalDate actualizacion, String estado) throws IOException, InterruptedException {

        LocalesMercadoDTO local = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"nombreLocal\":\"" )
                .append(Nombre)
                .append("\",")
                .append("\"ubicacionLocal\":\"" )
                .append(ubicacion)
                .append("\",")
                .append("\"correoLocal\":\"" )
                .append(correo)
                .append("\",")
                .append("\"telefonoLocal\":\"" )
                .append(Telefono)
                .append("\",")
                .append("\"monto_Alquiler_Local\":\"" )
                .append(Monto)
                .append("\",")
                .append("\"fechaRegistrocomercio\":\"" )
                .append(registro)
                .append("\",")
                .append("\"ultima_Actualizacioncomercio\":\"" )
                .append(actualizacion)
                .append("\",")
                .append("\"estado\":\"" )
                .append(estado)
                .append("\"")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/localesmercado/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        local = mapper.readValue(response.body(), new TypeReference<LocalesMercadoDTO>() {});

        return local;

    }

    public static PropiedadesDTO CrearPropiedad(String propiedadProvincia, String propiedadCanton, String propiedadDistrito, String propiedadDireccion, String propiedadGeolocalizacion, Long propiedadArea, String propiedadPlano, Long propiedadAMetrosFrente, Long propiedadValorTerreno, Long propiedadValorConstruccion, Long propiedadOtrosValores, boolean PerteneceEstado, String propiedadZona, String estado, LocalDate registro, LocalDate actualizacion) throws IOException, InterruptedException {

        PropiedadesDTO propiedad = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"propiedadProvincia\":\"" )
                .append(propiedadProvincia)
                .append("\",")
                .append("\"propiedadCanton\":\"" )
                .append(propiedadCanton)
                .append("\",")
                .append("\"propiedadDistrito\":\"" )
                .append(propiedadDistrito)
                .append("\",")
                .append("\"propiedadDireccion\":\"" )
                .append(propiedadDireccion)
                .append("\",")
                .append("\"propiedadGeolocalizacion\":\"" )
                .append(propiedadGeolocalizacion)
                .append("\",")
                .append("\"propiedadArea\":\"" )
                .append(propiedadArea)
                .append("\",")
                .append("\"propiedadPlano\":\"" )
                .append(propiedadPlano)
                .append("\",")
                .append("\"propiedadAMetrosFrente\":\"" )
                .append(propiedadAMetrosFrente)
                .append("\",")
                .append("\"propiedadValorTerreno\":\"" )
                .append(propiedadValorTerreno)
                .append("\",")
                .append("\"propiedadValorConstruccion\":\"" )
                .append(propiedadValorConstruccion)
                .append("\",")
                .append("\"propiedadOtrosValores\":\"" )
                .append(propiedadOtrosValores)
                .append("\",")
                .append("\"PerteneceEstado\":\"" )
                .append(PerteneceEstado)
                .append("\",")
                .append("\"propiedadZona\":\"" )
                .append(propiedadZona)
                .append("\",")
                .append("\"estado\":\"" )
                .append(estado)
                .append("\",")
                .append("\"propiedad_fecha_Registro\":\"" )
                .append(registro)
                .append("\",")
                .append("\"propiedad_ultima_Actualizacion\":\"" )
                .append(actualizacion)
                .append("\"")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/propiedades/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        System.out.println("cuerpo "+response.body());
        propiedad = mapper.readValue(response.body(), new TypeReference<PropiedadesDTO>() {});

        return propiedad;

    }

    public static List<LicenciasComercialesDTO> ObtenerLicencia(String cedula) throws IOException, InterruptedException {

        List<LicenciasComercialesDTO> licencia = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/licenciasComerciales/findLicencias_ComercialesByCedula/"+cedula+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        System.out.println("cuerpo "+response.body());
        licencia = mapper.readValue(response.body(), new TypeReference<List<LicenciasComercialesDTO>>() {});

        return licencia;

    }

    public static List<LocalesMercadoDTO> ObtenerLocal(String cedula) throws IOException, InterruptedException {

        List<LocalesMercadoDTO> local = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/localesmercado/findLocales_MercadoByCedula/"+cedula+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        local = mapper.readValue(response.body(), new TypeReference<List<LocalesMercadoDTO>>() {});

        return local;

    }

    public static List<PropiedadesDTO> ObtenerPropiedad(String cedula) throws IOException, InterruptedException {

        List<PropiedadesDTO> propiedad = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/propiedades/findPropiedadesByCedula/"+cedula+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        propiedad = mapper.readValue(response.body(), new TypeReference<List<PropiedadesDTO>>() {});

        return propiedad;

    }

    public static List<CobrosDTO> obtenerCobro(String cedula) throws IOException, InterruptedException {
        List<CobrosDTO> cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/findCobrosByCedulaContribuyentePendientes/"+cedula+"/"))
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


    public static LicenciasComercialesDTO ActualizarLicenciaComercial(Long Id, String Nombre, Long Telefono, String correo, String distrito, LocalDate registro, LocalDate actualizacion, String codigo, String estado) throws IOException, InterruptedException {
        LicenciasComercialesDTO Licencia = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"id\":\"" )
                .append(Id)
                .append("\",")
                .append("\"nombreComercio\":\"" )
                .append(Nombre)
                .append("\",")
                .append("\"telefonoComercio\":\"" )
                .append(Telefono)
                .append("\",")
                .append("\"correoComercio\":\"" )
                .append(correo)
                .append("\",")
                .append("\"distritoComercio\":\"" )
                .append(distrito)
                .append("\",")
                .append("\"telefonoComercio\":\"" )
                .append(Telefono)
                .append("\",")
                .append("\"fechaRegistrocomercio\":\"" )
                .append(registro)
                .append("\",")
                .append("\"ultima_Actualizacioncomercio\":\"" )
                .append(actualizacion)
                .append("\",")
                .append("\"codigoComercio\":\"" )
                .append(codigo)
                .append("\",")
                .append("\"estado\":\"" )
                .append(estado)
                .append("\"")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/licenciasComerciales/"+Id+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        System.out.println("cuerpo "+response.body());
        Licencia = mapper.readValue(response.body(), new TypeReference<LicenciasComercialesDTO>() {});
        return Licencia;
    }

    public static LocalesMercadoDTO ActualizarLocalMercado(Long Id,String Nombre, String ubicacion, String correo, Long Telefono, Long Monto, LocalDate registro, LocalDate actualizacion, String estado) throws IOException, InterruptedException {

        LocalesMercadoDTO local = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"id\":\"" )
                .append(Id)
                .append("\",")
                .append("\"nombreLocal\":\"" )
                .append(Nombre)
                .append("\",")
                .append("\"ubicacionLocal\":\"" )
                .append(ubicacion)
                .append("\",")
                .append("\"correoLocal\":\"" )
                .append(correo)
                .append("\",")
                .append("\"telefonoLocal\":\"" )
                .append(Telefono)
                .append("\",")
                .append("\"monto_Alquiler_Local\":\"" )
                .append(Monto)
                .append("\",")
                .append("\"fechaRegistrocomercio\":\"" )
                .append(registro)
                .append("\",")
                .append("\"ultima_Actualizacioncomercio\":\"" )
                .append(actualizacion)
                .append("\",")
                .append("\"estado\":\"" )
                .append(estado)
                .append("\"")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/localesmercado/"+Id+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        local = mapper.readValue(response.body(), new TypeReference<LocalesMercadoDTO>() {});

        return local;
    }

    public static PropiedadesDTO ActualizarPropiedad(Long Id,String propiedadProvincia, String propiedadCanton, String propiedadDistrito, String propiedadDireccion, String propiedadGeolocalizacion, Long propiedadArea, String propiedadPlano, Long propiedadAMetrosFrente, Long propiedadValorTerreno, Long propiedadValorConstruccion, Long propiedadOtrosValores, boolean PerteneceEstado, String propiedadZona, String estado, LocalDate registro, LocalDate actualizacion) throws IOException, InterruptedException {

        PropiedadesDTO propiedad = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"propiedades_id\":\"" )
                .append(Id)
                .append("\",")
                .append("\"propiedadProvincia\":\"" )
                .append(propiedadProvincia)
                .append("\",")
                .append("\"propiedadCanton\":\"" )
                .append(propiedadCanton)
                .append("\",")
                .append("\"propiedadDistrito\":\"" )
                .append(propiedadDistrito)
                .append("\",")
                .append("\"propiedadDireccion\":\"" )
                .append(propiedadDireccion)
                .append("\",")
                .append("\"propiedadGeolocalizacion\":\"" )
                .append(propiedadGeolocalizacion)
                .append("\",")
                .append("\"propiedadArea\":\"" )
                .append(propiedadArea)
                .append("\",")
                .append("\"propiedadPlano\":\"" )
                .append(propiedadPlano)
                .append("\",")
                .append("\"propiedadAMetrosFrente\":\"" )
                .append(propiedadAMetrosFrente)
                .append("\",")
                .append("\"propiedadValorTerreno\":\"" )
                .append(propiedadValorTerreno)
                .append("\",")
                .append("\"propiedadValorConstruccion\":\"" )
                .append(propiedadValorConstruccion)
                .append("\",")
                .append("\"propiedadOtrosValores\":\"" )
                .append(propiedadOtrosValores)
                .append("\",")
                .append("\"PerteneceEstado\":\"" )
                .append(PerteneceEstado)
                .append("\",")
                .append("\"propiedadZona\":\"" )
                .append(propiedadZona)
                .append("\",")
                .append("\"Estado\":\"" )
                .append(estado)
                .append("\",")
                .append("\"propiedad_fecha_Registro\":\"" )
                .append(registro)
                .append("\",")
                .append("\"propiedad_ultima_Actualizacion\":\"" )
                .append(actualizacion)
                .append("\"")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/propiedades/"+Id+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        propiedad = mapper.readValue(response.body(), new TypeReference<PropiedadesDTO>() {});

        return propiedad;
    }

    /*public static CobrosDTO ActualizarCobro(Long Id, String Nombre, Long Telefono, String correo, String distrito, LocalDate registro, LocalDate actualizacion, String codigo, String estado) throws IOException, InterruptedException {
        LicenciasComercialesDTO Licencia = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"id\":\"" )
                .append(Id)
                .append("\",")
                .append("\"nombreComercio\":\"" )
                .append(Nombre)
                .append("\",")
                .append("\"telefonoComercio\":\"" )
                .append(Telefono)
                .append("\",")
                .append("\"correoComercio\":\"" )
                .append(correo)
                .append("\",")
                .append("\"distritoComercio\":\"" )
                .append(distrito)
                .append("\",")
                .append("\"telefonoComercio\":\"" )
                .append(Telefono)
                .append("\",")
                .append("\"fechaRegistrocomercio\":\"" )
                .append(registro)
                .append("\",")
                .append("\"ultima_Actualizacioncomercio\":\"" )
                .append(actualizacion)
                .append("\",")
                .append("\"codigoComercio\":\"" )
                .append(codigo)
                .append("\",")
                .append("\"estado\":\"" )
                .append(estado)
                .append("\"")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/licenciasComerciales/"+Id+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        System.out.println("cuerpo "+response.body());
        Licencia = mapper.readValue(response.body(), new TypeReference<LicenciasComercialesDTO>() {});
        return Licencia;
    }*/
}
