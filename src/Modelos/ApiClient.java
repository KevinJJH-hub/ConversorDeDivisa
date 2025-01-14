package Modelos;
import com.google.gson.Gson;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    public TasaDeCambio ObtenerJsonObjeto(String direccion){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException|InterruptedException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        TasaDeCambio tasaDeCambio = gson.fromJson(response.body(), TasaDeCambio.class);
        return tasaDeCambio;
    }
}
