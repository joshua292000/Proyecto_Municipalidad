package org.una.municipalidad.app_escritorio.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.una.municipalidad.app_escritorio.DTO.*;
import org.una.municipalidad.app_escritorio.Util.AppContext;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
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
        if(licencia.size()==0){
            JOptionPane.showMessageDialog(null,"No se encontraron Licencias comerciales registradas para el contribuyente con cedula "+cedula);
        }else{
            JOptionPane.showMessageDialog(null,"Registros localizados con éxito");
        }
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
        if(local.size()==0){
            JOptionPane.showMessageDialog(null,"No se encontraron Locales de Mercado registrados para el contribuyente con cedula "+cedula);
        }else {
            JOptionPane.showMessageDialog(null, "Registros localizados con éxito");
        }
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
        if(propiedad.size()==0){
            JOptionPane.showMessageDialog(null,"No se encontraron propiedades registradas para el contribuyente con cedula "+cedula);
        }else{
            JOptionPane.showMessageDialog(null,"Registros localizados con éxito");
        }
        return propiedad;

    }

    public static List<CobrosDTO> obtenerCobro(String cedula, String estado) throws IOException, InterruptedException {
        List<CobrosDTO> cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/findCobrosByCedulaContribuyentePendientes/"+cedula+"/"+estado+"/"))
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

    public static CobrosDTO ActualizarCobro(Long Id, String cobrosPeriodo, Long cobrosMonto, LocalDate cobrosFechaCreacion, LocalDate cobrosFechaVencimiento, String estado, LocalDate cobrosFechaPago, LicenciasComercialesDTO licencia, FacturasDTO facturas,TipoCobrosDTO tipocobros,LocalesMercadoDTO localesmercado,PropiedadesDTO propiedades) throws IOException, InterruptedException {
        CobrosDTO cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"id\":\"" )
                .append(Id)
                .append("\",")
                .append("\"cobrosPeriodo\":\"" )
                .append(cobrosPeriodo)
                .append("\",")
                .append("\"cobrosMonto\":\"" )
                .append(cobrosMonto)
                .append("\",")
                .append("\"cobrosFechaCreacion\":\"" )
                .append(cobrosFechaCreacion)
                .append("\",")
                .append("\"cobrosFechaVencimiento\":\"" )
                .append(cobrosFechaVencimiento)
                .append("\",")
                .append("\"estado\":\"" )
                .append(estado)
                .append("\",")
                .append("\"cobrosFechaPago\":\"" )
                .append(cobrosFechaPago)
                .append("\",")
                .append("\"licenciascomerciales\":null," )
                //.append("\"")
                .append("\"facturas\":null," )
                //.append("\",")
                .append("\"tipocobros\":{" )
                .append("\"id\":\"" )
                .append(tipocobros.getId())
                .append("\"},")
                .append("\"localesmercado\":null," )
                //.append("\",")
                .append("\"propiedades\":{" )
                .append("\"propiedades_id\":\"" )
                .append(propiedades.getPropiedades_id())
                .append("\"}")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/cobros/"+Id+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        System.out.println("cuerpo "+response.body());
        cobro = mapper.readValue(response.body(), new TypeReference<CobrosDTO>() {});
        return cobro;
    }

    public static CobrosDTO ActualizarCobroLicencia(Long Id, String cobrosPeriodo, Long cobrosMonto, LocalDate cobrosFechaCreacion, LocalDate cobrosFechaVencimiento, String estado, LocalDate cobrosFechaPago, LicenciasComercialesDTO licencia, FacturasDTO facturas,TipoCobrosDTO tipocobros,LocalesMercadoDTO localesmercado,PropiedadesDTO propiedades) throws IOException, InterruptedException {
        CobrosDTO cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"id\":\"" )
                .append(Id)
                .append("\",")
                .append("\"cobrosPeriodo\":\"" )
                .append(cobrosPeriodo)
                .append("\",")
                .append("\"cobrosMonto\":\"" )
                .append(cobrosMonto)
                .append("\",")
                .append("\"cobrosFechaCreacion\":\"" )
                .append(cobrosFechaCreacion)
                .append("\",")
                .append("\"cobrosFechaVencimiento\":\"" )
                .append(cobrosFechaVencimiento)
                .append("\",")
                .append("\"estado\":\"" )
                .append(estado)
                .append("\",")
                .append("\"cobrosFechaPago\":\"" )
                .append(cobrosFechaPago)
                .append("\",")
                .append("\"licenciascomerciales\":{" )
                .append("\"id\":\"" )
                .append(licencia.getId())
                .append("\"},")
                .append("\"facturas\":null," )
                //.append("\",")
                .append("\"tipocobros\":{" )
                .append("\"id\":\"" )
                .append(tipocobros.getId())
                .append("\"},")
                .append("\"localesmercado\":null," )
                //.append("\",")
                .append("\"propiedades\":null}" )
                //.append("\"}")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/cobros/"+Id+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        cobro = mapper.readValue(response.body(), new TypeReference<CobrosDTO>() {});
        return cobro;
    }

    public static CobrosDTO ActualizarCobroMercado(Long Id, String cobrosPeriodo, Long cobrosMonto, LocalDate cobrosFechaCreacion, LocalDate cobrosFechaVencimiento, String estado, LocalDate cobrosFechaPago, LicenciasComercialesDTO licencia, FacturasDTO facturas,TipoCobrosDTO tipocobros,LocalesMercadoDTO localesmercado,PropiedadesDTO propiedades) throws IOException, InterruptedException {
        CobrosDTO cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"id\":\"" )
                .append(Id)
                .append("\",")
                .append("\"cobrosPeriodo\":\"" )
                .append(cobrosPeriodo)
                .append("\",")
                .append("\"cobrosMonto\":\"" )
                .append(cobrosMonto)
                .append("\",")
                .append("\"cobrosFechaCreacion\":\"" )
                .append(cobrosFechaCreacion)
                .append("\",")
                .append("\"cobrosFechaVencimiento\":\"" )
                .append(cobrosFechaVencimiento)
                .append("\",")
                .append("\"estado\":\"" )
                .append(estado)
                .append("\",")
                .append("\"cobrosFechaPago\":\"" )
                .append(cobrosFechaPago)
                .append("\",")
                .append("\"licenciascomerciales\":null," )
                .append("\"facturas\":null," )
                //.append("\",")
                .append("\"tipocobros\":{" )
                .append("\"id\":\"" )
                .append(tipocobros.getId())
                .append("\"},")
                .append("\"localesmercado\":{" )
                .append("\"id\":\"" )
                .append(localesmercado.getId())
                .append("\"},")
                .append("\"propiedades\":null}" )
                //.append("\"}")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/cobros/"+Id+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        cobro = mapper.readValue(response.body(), new TypeReference<CobrosDTO>() {});
        return cobro;
    }

    public static LicenciasComercialesDTO ObtenerLicenciaNombre(String nombre) throws IOException, InterruptedException {

        LicenciasComercialesDTO licencia = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/licenciasComerciales/findByNombreComercio/"+nombre+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        System.out.println("cuerpo "+response.body());
        licencia = mapper.readValue(response.body(), new TypeReference<LicenciasComercialesDTO>() {});

        return licencia;

    }

    public static LocalesMercadoDTO ObtenerNombreLocal(String nombre) throws IOException, InterruptedException {

        LocalesMercadoDTO local = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/localesmercado/findByNombreLocal/"+nombre+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        local = mapper.readValue(response.body(), new TypeReference<LocalesMercadoDTO> () {});

        return local;

    }

    public static PropiedadesDTO ObtenerIdPropiedad(Long Id) throws IOException, InterruptedException {

        PropiedadesDTO propiedad = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/propiedades/"+Id+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        propiedad = mapper.readValue(response.body(), new TypeReference<PropiedadesDTO>() {});

        return propiedad;

    }

    public static Contribuyentes_Licencias_ComercialesDTO CrearLicenciaComercialXContribuyente(Long porcentaje, ContribuyentesDTO contribuyente, LicenciasComercialesDTO licencia) throws IOException, InterruptedException {
        Date fecha = new Date();
        LocalDate fechaRegistro = LocalDate.parse("2021-11-12");
        Contribuyentes_Licencias_ComercialesDTO Licencia;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"porcentajeLicencia\":\"" )
                .append(porcentaje)
                .append("\",")
                .append("\"contribuyente\":{" )
                .append("\"id\":\"" )
                .append(contribuyente.getId())
                .append("\",")
                .append("\"nombreContribuyente\":\"" )
                .append(contribuyente.getNombreContribuyente())
                .append("\",")
                .append("\"apellidoContribuyente\":\"" )
                .append(contribuyente.getApellidoContribuyente())
                .append("\",")
                .append("\"cedulaContribuyente\":\"" )
                .append(contribuyente.getCedulaContribuyente())
                .append("\"},")
                .append("\"licenciascomerciales\":{" )
                .append("\"id\":\"" )
                .append(licencia.getId())
                .append("\",")
                .append("\"nombreComercio\":\"" )
                .append(licencia.getNombreComercio())
                .append("\",")
                .append("\"telefonoComercio\":\"" )
                .append(licencia.getTelefonoComercio())
                .append("\",")
                .append("\"correoComercio\":\"" )
                .append(licencia.getCorreoComercio())
                .append("\",")
                .append("\"distritoComercio\":\"" )
                .append(licencia.getDistritoComercio())
                .append("\",")
                .append("\"fechaRegistrocomercio\":\"" )
                .append(fechaRegistro)
                .append("\",")
                .append("\"ultima_Actualizacioncomercio\":\"" )
                .append(fechaRegistro)
                .append("\",")
                .append("\"codigoComercio\":\"" )
                .append(licencia.getCodigoComercio())
                .append("\",")
                .append("\"estado\":\"" )
                .append(licencia.getEstado())
                .append("\"}")
                .append("}").toString();
        System.out.println("jsonprove f"+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/contribuyentes_licencias_comerciales/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status f "+response.statusCode());

        // print response body
        System.out.println("cuerpo f "+response.body());
        Licencia = mapper.readValue(response.body(), new TypeReference<Contribuyentes_Licencias_ComercialesDTO>() {});
        return Licencia;

    }

    public static Contribuyentes_PropiedadesDTO CrearPropiedadXContribuyente(Long porcentaje, ContribuyentesDTO contribuyente, PropiedadesDTO propiedades) throws IOException, InterruptedException {

        Contribuyentes_PropiedadesDTO propiedad = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"porcentajePropiedad\":\"" )
                .append(porcentaje)
                .append("\",")
                .append("\"contribuyente\":{" )
                .append("\"id\":\"" )
                .append(contribuyente.getId())
                .append("\"},")
                .append("\"propiedades\":{" )
                .append("\"propiedades_id\":\"" )
                .append(propiedades.getPropiedades_id())
                .append("\"}")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/contribuyentes_propiedades/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        System.out.println("cuerpo "+response.body());
        propiedad = mapper.readValue(response.body(), new TypeReference<Contribuyentes_PropiedadesDTO>() {});

        return propiedad;

    }

    public static Contribuyentes_Locales_MercadoDTO CrearLocalXContribuyente(Long porcentaje, ContribuyentesDTO contribuyente, LocalesMercadoDTO local) throws IOException, InterruptedException {

        Contribuyentes_Locales_MercadoDTO localM = null;

        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"porcentajeLocales\":\"" )
                .append(porcentaje)
                .append("\",")
                .append("\"contribuyente\":{" )
                .append("\"id\":\"" )
                .append(contribuyente.getId())
                .append("\"},")
                .append("\"localesmercado\":{" )
                .append("\"id\":\"" )
                .append(local.getId())
                .append("\"}")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/contribuyentes_Locales_Mercado/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        System.out.println("cuerpo "+response.body());
        localM = mapper.readValue(response.body(), new TypeReference<Contribuyentes_Locales_MercadoDTO>() {});

        return localM;

    }

    public static List<CobrosDTO> obtenerCobro2(String cedula, String estado) throws IOException, InterruptedException {
        List<CobrosDTO> cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/findCobrosByCedulaContribuyente/"+cedula+"/"+estado+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        System.out.println("cuerpo "+response.body());
        if(response.body().equals("No se encontro información en su solicitud, revise su petición")){
            cobro=null;
        }else{
            cobro = mapper.readValue(response.body(), new TypeReference<List<CobrosDTO>>() {});
        }
        return cobro;
    }

    public static List<CobrosDTO> obtenerCobro3(String cedula, String estado) throws IOException, InterruptedException {
        List<CobrosDTO> cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/findCobrosByCedulaContribuyente2/"+cedula+"/"+estado+"/"))
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

    public static List<CobrosDTO> obtenerCobro4(String cedula, String estado) throws IOException, InterruptedException {
        List<CobrosDTO> cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/findCobrosByCedulaContribuyente3/"+cedula+"/"+estado+"/"))
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

    public static BitacorasDTO CrearRegistro(String bitacoraTabla, String bitacoraDescripcion, String bitacoraUsuario, LocalDate bitacoraFecha, Long usuarioId) throws IOException, InterruptedException {

        BitacorasDTO bitacora = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"bitacoraTabla\":\"" )
                .append(bitacoraTabla)
                .append("\",")
                .append("\"bitacoraDescripcion\":\"" )
                .append(bitacoraDescripcion)
                .append("\",")
                .append("\"bitacoraUsuario\":\"" )
                .append(bitacoraUsuario)
                .append("\",")
                .append("\"bitacoraFecha\":\"" )
                .append(bitacoraFecha)
                .append("\",")
                .append("\"usuario\":{" )
                .append("\"id\":\"" )
                .append(usuarioId)
                .append("\"}")
                .append("}").toString();
        System.out.println("jsonprove "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/bitacora/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        bitacora = mapper.readValue(response.body(), new TypeReference<BitacorasDTO>() {});

        return bitacora;

    }
}
