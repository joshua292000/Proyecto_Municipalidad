package org.una.municipalidad.app_escritorio.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.Alert;
import org.una.municipalidad.app_escritorio.DTO.*;
import org.una.municipalidad.app_escritorio.Util.AppContext;
import org.una.municipalidad.app_escritorio.Util.Mensaje;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;
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
        System.out.print("cobro "+cobro.size());
        if(cobro.size()==0){
            JOptionPane.showMessageDialog(null,"No se encontraron registros");
        }else{
            JOptionPane.showMessageDialog(null,"Registros localizados con éxito");
        }
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
        if(cobro.size()==0){
            JOptionPane.showMessageDialog(null,"No se encontraron registros entre estas fechas "+ inicio+" y "+fin);
        }else{
            JOptionPane.showMessageDialog(null,"Registros localizados con éxito");
        }
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
        if(LicenciasComerciales.size()==0){
            JOptionPane.showMessageDialog(null,"No se encontraron registros");
        }else{
            JOptionPane.showMessageDialog(null,"Registros localizados con éxito");
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
                .uri(URI.create("http://localhost:8089/localesmercado"))
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
        if(LocalesMercado.size()==0){
            JOptionPane.showMessageDialog(null,"No se encontraron registros");
        }else{
            JOptionPane.showMessageDialog(null,"Registro localizado con éxito");
        }
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
        if(Propiedades.size()==0){
            JOptionPane.showMessageDialog(null,"No se encontraron registros");
        }else{
            JOptionPane.showMessageDialog(null,"Registros localizados con éxito");
        }
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
        if(para.size()==0){
            JOptionPane.showMessageDialog(null,"No se encontraron registros");
        }
        else{
            JOptionPane.showMessageDialog(null,"Registros localizados con éxito");
        }
        return para;
    }

    public static CobrosDTO CrearCobrosMasivosxpropiedad(Date fecha) throws IOException, InterruptedException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        String fechaTexto1 = formatter.format(fecha);

        CobrosDTO cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/CobrosMasivoPropiedades/"+fechaTexto1+"/"))
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

    public static CobrosDTO CrearCobrosMasivosxLocal(Date fecha) throws IOException, InterruptedException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        String fechaTexto1 = formatter.format(fecha);

        CobrosDTO cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/CobrosMasivosLocales/"+fechaTexto1+"/"))
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

    public static CobrosDTO CrearCobrosMasivosxLicencias(Date fecha) throws IOException, InterruptedException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        String fechaTexto1 = formatter.format(fecha);

        CobrosDTO cobro = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/cobros/CobrosMasivoLicencias/"+fechaTexto1+"/"))
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

    public static List<FechasCobrosDTO> obtenerTodoFechaCobros() throws IOException, InterruptedException {
        List<FechasCobrosDTO> para = null;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8089/fechascobros"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        para = mapper.readValue(response.body(), new TypeReference<List<FechasCobrosDTO>>() {});
        System.out.print("cobro "+para);
        if(para.size()==0){
            JOptionPane.showMessageDialog(null,"No se encontraron registros");
        }
        else{
            JOptionPane.showMessageDialog(null,"Registros localizados con éxito");
        }
        return para;
    }

    public static FechasCobrosDTO ActualizarFechasCobros(Long Id, String Impuesto, Long Periodo, Date fecha1,Date fecha2,Date fecha3,Date fecha4,Date fecha5,Date fecha6,Date fecha7,Date fecha8,Date fecha9,Date fecha10,Date fecha11,Date fecha12) throws IOException, InterruptedException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        String fechaTexto1 = null;
        String fechaTexto2 = null;
        String fechaTexto3 = null;
        String fechaTexto4 = null;
        String fechaTexto5 = null;
        String fechaTexto6 = null;
        String fechaTexto7 = null;
        String fechaTexto8 = null;
        String fechaTexto9 = null;
        String fechaTexto10 = null;
        String fechaTexto11 = null;
        String fechaTexto12 = null;

        if(fecha1!=null){
            fechaTexto1  = formatter.format(fecha1);
        }
        if(fecha2!=null){
            fechaTexto2  = formatter.format(fecha2);
        }
        if(fecha3!=null){
            fechaTexto3  = formatter.format(fecha3);
        }
        if(fecha4!=null){
            fechaTexto4  = formatter.format(fecha4);
        }
        if(fecha5!=null){
            fechaTexto5  = formatter.format(fecha5);
        }
        if(fecha6!=null){
            fechaTexto6  = formatter.format(fecha6);
        }
        if(fecha7!=null){
            fechaTexto6  = formatter.format(fecha7);
        }
        if(fecha8!=null){
            fechaTexto8  = formatter.format(fecha8);
        }
        if(fecha9!=null){
            fechaTexto9  = formatter.format(fecha9);
        }
        if(fecha10!=null){
            fechaTexto10  = formatter.format(fecha10);
        }
        if(fecha11!=null){
            fechaTexto11  = formatter.format(fecha11);
        }
        if(fecha12!=null){
            fechaTexto12  = formatter.format(fecha12);
        }

        FechasCobrosDTO fecha;
        AuthenticationResponse token = (AuthenticationResponse) AppContext.getInstance().get("rol");
        String json = new StringBuilder()
                .append("{")
                .append("\"id\":\"" )
                .append(Id)
                .append("\",")
                .append("\"fechasCobrosImpuestos\":\"" )
                .append(Impuesto)
                .append("\",")
                .append("\"fechasCobrosPeriodo\":\"" )
                .append(Periodo)
                .append("\",")
                .append("\"fechasCobrosFecha1\":\"" )
                .append(fechaTexto1)
                .append("\",")
                .append("\"fechasCobrosFecha2\":\"" )
                .append(fechaTexto2)
                .append("\",")
                .append("\"fechasCobrosFecha3\":\"" )
                .append(fechaTexto3)
                .append("\",")
                .append("\"fechasCobrosFecha4\":\"" )
                .append(fechaTexto4)
                .append("\",")
                .append("\"fechasCobrosFecha5\":\"" )
                .append(fechaTexto5)
                .append("\",")
                .append("\"fechasCobrosFecha6\":\"" )
                .append(fechaTexto6)
                .append("\",")
                .append("\"fechasCobrosFecha7\":\"" )
                .append(fechaTexto7)
                .append("\",")
                .append("\"fechasCobrosFecha8\":\"" )
                .append(fechaTexto8)
                .append("\",")
                .append("\"fechasCobrosFecha9\":\"" )
                .append(fechaTexto9)
                .append("\",")
                .append("\"fechasCobrosFecha10\":\"" )
                .append(fechaTexto10)
                .append("\",")
                .append("\"fechasCobrosFecha11\":\"" )
                .append(fechaTexto11)
                .append("\",")
                .append("\"fechasCobrosFecha12\":\"" )
                .append(fechaTexto12)
                .append("\"")
                .append("}").toString();
        System.out.println("jsonprove fecha "+json+"\n");
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8089/fechascobros/"+Id+"/"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .setHeader("AUTHORIZATION", "Bearer " + token.getJwt())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("status "+response.statusCode());

        System.out.println("cuerpo "+response.body());
        fecha = mapper.readValue(response.body(), new TypeReference<FechasCobrosDTO>() {});
        return fecha;
    }
}
