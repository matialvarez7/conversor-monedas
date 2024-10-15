import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ConsultaTasaCambio {

    // Consulta a la API para que nos devuelva el valor de una moneda convertida a otra específica
    public static Moneda consultaMoneda(String moneda, String monedaAConvertir){

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(crearURIConsultaEspecifica(moneda, monedaAConvertir))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró la moneda");
        }
    }

    private static URI crearURIConsultaEspecifica(String moneda1, String moneda2){
        String resultado1 = URLEncoder.encode(moneda1, StandardCharsets.UTF_8);
        String resultado2 = URLEncoder.encode(moneda2, StandardCharsets.UTF_8);
        String APIkey = "8fb3c5ed5602fcc50c5f9bf4";
        return URI.create("https://v6.exchangerate-api.com/v6/"+ APIkey +"/pair/"+resultado1+"/"+resultado2);
    }
}
