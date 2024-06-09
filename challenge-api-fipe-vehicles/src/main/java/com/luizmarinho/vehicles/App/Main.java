package com.luizmarinho.vehicles.App;

import java.util.*;
import java.util.stream.Collectors;

import com.luizmarinho.vehicles.Model.Data;
import com.luizmarinho.vehicles.Model.Models;
import com.luizmarinho.vehicles.Model.Vehicle;
import com.luizmarinho.vehicles.Service.Api;
import com.luizmarinho.vehicles.Service.ConvertJson;

public class Main {
    Api api = new Api();
    ConvertJson convertJson = new ConvertJson();
    Scanner reader = new Scanner(System.in);


    public void executeProgram() {

        final String baseUrl = "https://parallelum.com.br/fipe/api/v1/";
        String menu = """
                *********** MENU ***********
                Car
                Motorcycle
                Truck""";

        System.out.println(menu);
        System.out.print("\nWhat would you like search -> ");
        String choice = reader.nextLine().toLowerCase();

        StringBuilder address = new StringBuilder(baseUrl);
        String json;
        if (choice.contains("ca")) {
            address.append("carros/marcas/");
            json = api.getData(address.toString());
        } else if (choice.contains("mo")) {
            address.append("motos/marcas/");
            json = api.getData(address.toString());
        } else {
            address.append("caminhoes/marcas/");
            json = api.getData(address.toString());
        }

        var brand = convertJson.convertToList(json, Data.class);

        System.out.println("\n***** BRANDS *****");
        brand.stream()
            .sorted(Comparator.comparing(Data::name))
            .forEach(System.out::println);  // PRINT ALL BRANDS ON CONSOLE

        // GETTING BRAND CODE INPUT FROM USER
        String choiceBrand = codeIsValid(brand, "brand");
        address.append(choiceBrand).append("/modelos/");

        // GETTING VEHICLES MODELS
        json = api.getData(address.toString());
        var models = convertJson.convertToObject(json, Models.class);
        
        List<Data> filteredModels;
        do {
            System.out.print("\nEnter model [name] or type [1] to show all models -> ");
            String choiceModel = reader.nextLine();

            if (choiceModel.equals("1")) {
                filteredModels = models.modelsList().stream()
                    .sorted(Comparator.comparing(Data::name))
                    .collect(Collectors.toList());
                break;
            } 
            
            filteredModels =  models.modelsList().stream()
                .filter(m -> m.name().toLowerCase().contains(choiceModel.toLowerCase()))
                .collect(Collectors.toList());

            if (filteredModels.isEmpty()){
                System.out.println("\nWe didn't find this model name, please try again");
            }

        } while (filteredModels.isEmpty()); // While it doesn't have a valid model name

        System.out.println("\n***** MODELS *****");
        filteredModels.forEach(System.out::println); // PRINTING ALL MODELS FILTERED

        // GETTING MODEL CODE INPUT FROM USER
        String choiceModel = codeIsValid(filteredModels, "model");
        address.append(choiceModel).append("/anos/");

        // GETTING VEHICLES YEARS FROM API
        json = api.getData(address.toString());
        var year = convertJson.convertToList(json, Data.class);

        // GETTING YEAR CODE INPUT FROM USER
        List<Vehicle> vehicles = new ArrayList<>();
        String addressModelsYears;
        for (Data d : year) {
            addressModelsYears = address + d.code();
            json = api.getData(addressModelsYears);
            vehicles.add(convertJson.convertToObject(json, Vehicle.class));
        }

        System.out.println("\n***** Vehicles Resume *****");
        vehicles.forEach(v -> System.out.println(v.resumeCar()));

        System.out.println("\n***** STATISTICS *****");
        DoubleSummaryStatistics statistics = vehicles.stream().collect(Collectors.summarizingDouble(Vehicle::price));
        System.out.printf("Count years model: %d\nAverage price: R$ %,.2f\nMinimum price: R$ %,.2f\nMax price: %,.2f"
                , statistics.getCount(), statistics.getAverage(), statistics.getMin(), statistics.getMax());

        System.out.println("\n\n***** Most cheap *****");
        vehicles.stream()
                .min(Comparator.comparingDouble(Vehicle::price))
                .ifPresent(d -> System.out.println(d.resumeCar()));

        System.out.println("\n***** Most Expensive *****");
        vehicles.stream()
                .max(Comparator.comparingDouble(Vehicle::price))
                .ifPresent(d -> System.out.println(d.resumeCar()));

        System.out.println("\n***** Most newer *****");
        vehicles.stream()
                .max(Comparator.comparingInt(Vehicle::year))
                .ifPresent(d -> System.out.println(d.resumeCar()));


        System.out.println("\nMain source: " + address);
    }


    private String codeIsValid(List<Data> actualClass, String typeInformation) {
        while (true) {
            System.out.print("\nEnter " + typeInformation + " code -> ");
            String choice = reader.nextLine();
            for (Data d : actualClass) {
                if (d.code().equals(choice)) {
                    System.out.println("\nYou chose the " + d.name().toUpperCase() + " " + typeInformation);
                    return choice;
                }
            }
            System.out.println("\nThis code does not exist, please try again");
        }
    }

}
