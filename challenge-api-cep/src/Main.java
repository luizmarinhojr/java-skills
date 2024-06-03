import Services.CepAPI;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("How do you wanna search? (1) CEP or (2) Address -> ");
        int choice = reader.nextInt();

        switch (choice) {
            case 1:
                try {
                    System.out.println();
                    System.out.print("Type the CEP number: ");
                    String cep = reader.next();
                    if (cep.length() != 8) {
                        System.out.println("Ops, the CEP format is wrong.");
                        throw new StringIndexOutOfBoundsException("The CEP must have 8 numbers");
                    }
                    CepAPI apiCep = new CepAPI(cep);
                    apiCep.searchCEP();
                } catch(StringIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                Scanner reader2 = new Scanner(System.in);
                System.out.print("Type the state acronym name (ex: RJ): ");
                String state = URLEncoder.encode(reader2.nextLine(), StandardCharsets.US_ASCII);
                System.out.print("Type the city name: ");
                String city = URLEncoder.encode(reader2.nextLine(), StandardCharsets.UTF_8);
                System.out.print("Type the street name: ");
                String street = URLEncoder.encode(reader2.nextLine(), StandardCharsets.UTF_8);
                CepAPI apiAddress = new CepAPI(state, city, street);
                apiAddress.searchCEP();
                break;

            default:
                System.out.println("Invalid option! The program stopped.");
                break;
        }
    }
}