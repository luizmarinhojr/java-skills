package com.luizmarinho.vehicles.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    public String getData(String address) {

        String json = "";
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body(); 
        } catch (IOException | IllegalArgumentException | InterruptedException e) {
            System.out.println("A error happened");
        }
        return json;
    }
}
