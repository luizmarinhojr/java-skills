package Services;

import Models.Address;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.Scanner;


public class CepAPI {
    private final String url;
    private final Gson gson = new Gson();

    public CepAPI(String cep) {
        this.url = "https://viacep.com.br/ws/" + cep + "/json/";
    }

    public CepAPI(String state, String city, String street) {
        this.url = "https://viacep.com.br/ws/" + state + "/" + city + "/" + street + "/json/";
    }

    public void searchCEP() {
        HttpResponse<String> response;
        System.out.println(this.url);
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.url)).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() >= 400) {
                throw new ConnectException("ERROR - Status Code -> " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        formatingCeps(response.body());
    }

    private void formatingCeps(String json) {
        if (this.url.length() > 42) {
            createMultipleCepClass(json);
        } else {
            createUniqueCepClass(json);
        }
    }

    private void createUniqueCepClass(String json) {
        Address address = gson.fromJson(json, Address.class);
        System.out.println(address);
        saveCeps(json);
        System.out.println("Source -> " + this.url);
    }

    private void createMultipleCepClass(String json) {
        TypeToken<List<Address>> tt = new TypeToken<>() {};
        List<Address> address = gson.fromJson(json, tt.getType());

        for (int i = 0; i < address.size(); i++) {
            System.out.println("''' Option " + (i + 1) + " '''");
            System.out.println(address.get(i));
        }
        System.out.println("Source -> " + this.url);
        Scanner reader = new Scanner(System.in);
        System.out.print("\nType the option number of the address you wish to register: ");
        int choice = reader.nextInt();
        String addressStr = address.get(choice-1).toString();
        saveCeps(addressStr);
    }

    private void saveCeps(String cepInfo) {
        try {
            FileWriter file = new FileWriter("ceps.json");
            file.write(cepInfo);
            file.close();
        } catch(FileAlreadyExistsException e) {
            e.getMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
