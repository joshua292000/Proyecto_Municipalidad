package org.una.municipalidad.app_escritorio.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.una.municipalidad.app_escritorio.DTO.AuthenticationResponse;
import org.una.municipalidad.app_escritorio.DTO.BitacorasDTO;
import org.una.municipalidad.app_escritorio.Util.AppContext;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
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
                .uri(URI.create("http://localhost:8089/cobros"))
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
}
