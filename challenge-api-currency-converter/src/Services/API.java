package Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    public static void searchCurrencyValues(String currency, String toCurrency, double value) throws IOException, InterruptedException {
        String apiKey = "77a4cd30bec036bbf6107740";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + currency;
        HttpResponse<String> response;
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        String json = response.body();
        Conversions.deserialize(json, currency, toCurrency, value);
    }
}
