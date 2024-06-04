import Models.EnumCoins;
import Services.API;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner reader = new Scanner(System.in);

        System.out.println("**************************************");
        System.out.println("Welcome to currency converter :)");
        System.out.println("**************************************");

        int choiceMenu;
        String choiceCountry;
        String choiceToCountry;
        do {
            double choiceValue = 0;
            System.out.println("\n---------------------- MENU -----------------------");
            System.out.println("******************** FAVORITES ********************");
            System.out.println("(1) " + EnumCoins.USD.getDescription() + " => " + EnumCoins.ARS.getDescription());
            System.out.println("(2) " + EnumCoins.ARS.getDescription() + " => " + EnumCoins.USD.getDescription());
            System.out.println("(3) " + EnumCoins.USD.getDescription() + " => " + EnumCoins.BRL.getDescription());
            System.out.println("(4) " + EnumCoins.BRL.getDescription() + " => " + EnumCoins.USD.getDescription());
            System.out.println("(5) " + EnumCoins.USD.getDescription() + " => " + EnumCoins.COP.getDescription());
            System.out.println("(6) " + EnumCoins.COP.getDescription() + " => " + EnumCoins.USD.getDescription());
            System.out.println("***************************************************");
            System.out.println("(7) Custom Conversion");
            System.out.println("(8) Exit");
            System.out.println("---------------------------------------------------");

            System.out.print("\nChoose a option -> ");
            choiceMenu = Integer.parseInt(reader.nextLine());

            if (choiceMenu < 7) {
                System.out.print("Type the value you wanna convert: ");
                choiceValue = Double.parseDouble(reader.nextLine());
            }

            switch (choiceMenu) {
                case 1:
                    API.searchCurrencyValues("USD", "ARS", choiceValue);
                    break;
                case 2:
                    API.searchCurrencyValues("ARS", "USD", choiceValue);
                    break;
                case 3:
                    API.searchCurrencyValues("USD", "BRL", choiceValue);
                    break;
                case 4:
                    API.searchCurrencyValues("BRL", "USD", choiceValue);
                    break;
                case 5:
                    API.searchCurrencyValues("USD", "COP", choiceValue);
                    break;
                case 6:
                    API.searchCurrencyValues("COP", "USD", choiceValue);
                    break;
                case 7:
                    for (EnumCoins e : EnumCoins.values()) {
                        System.out.println("(" + e + ") - " + e.getDescription());
                    }
                    System.out.print("\nType your choice (Ex: BRL) -> ");
                    choiceCountry = reader.nextLine().toUpperCase();

                    System.out.print("Do you wish to convert to (Ex: USD) -> ");
                    choiceToCountry = reader.nextLine().toUpperCase();

                    System.out.print("Type the value you wanna convert: " + EnumCoins.valueOf(choiceCountry) + " ");
                    choiceValue = Double.parseDouble(reader.nextLine());

                    API.searchCurrencyValues(choiceCountry, choiceToCountry, choiceValue);
                    break;
                case 8:
                    System.out.println("Ok, it's exiting now. See you later! =)");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }

            if (choiceMenu != 8) {
                System.out.print("\nDo you wanna search one more? (y) Yes  (n) No  -> ");
                String choice = reader.nextLine();
                if (choice.equals("n") || choice.equals("N")) {
                    break;
                }
            }
        } while(choiceMenu != 8);
    }
}