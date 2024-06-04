import Models.EnumCoins;
import Services.API;
import Services.Conversions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int choiceMenu;
        int status;
        String choiceCountry = "";
        String choiceToCountry = "";

        System.out.println("__________ WELCOME TO CURRENCY CONVERTER __________");

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

            switch (choiceMenu) {
                case 1:
                    choiceValue = Conversions.askValue("USD");
                    API.searchCurrencyValues("USD", "ARS", choiceValue);
                    break;
                case 2:
                    choiceValue = Conversions.askValue("ARS");
                    API.searchCurrencyValues("ARS", "USD", choiceValue);
                    break;
                case 3:
                    choiceValue = Conversions.askValue("USD");
                    API.searchCurrencyValues("USD", "BRL", choiceValue);
                    break;
                case 4:
                    choiceValue = Conversions.askValue("BRL");
                    API.searchCurrencyValues("BRL", "USD", choiceValue);
                    break;
                case 5:
                    choiceValue = Conversions.askValue("USD");
                    API.searchCurrencyValues("USD", "COP", choiceValue);
                    break;
                case 6:
                    choiceValue = Conversions.askValue("COP");
                    API.searchCurrencyValues("COP", "USD", choiceValue);
                    break;
                case 7:
                    for (EnumCoins e : EnumCoins.values()) { // show all currencies available
                        System.out.println("(" + e + ") - " + e.getDescription());
                    }
                    status = 0;
                    do {
                        try {
                            System.out.print("\nFrom currency (Ex: BRL) -> ");
                            choiceCountry = reader.nextLine().toUpperCase();
                            EnumCoins.valueOf(choiceCountry);
                            status = 1;
                        } catch (IllegalArgumentException e) {
                            System.out.println("It doesn't exist this currency, please type again");
                        }
                    } while (status == 0);

                    status = 0;
                    do {
                        try {
                            System.out.print("To currency (Ex: USD) -> ");
                            choiceToCountry = reader.nextLine().toUpperCase();
                            EnumCoins.valueOf(choiceToCountry);
                            status = 1;
                        } catch (IllegalArgumentException e) {
                            System.out.println("It doesn't exist this currency, please type again");
                        }
                    } while (status == 0);

                    status = 0;
                    do {
                        try {
                            System.out.print("Type the value you wanna convert: " + EnumCoins.valueOf(choiceCountry) + " ");
                            choiceValue = Double.parseDouble(reader.nextLine());
                            if (choiceValue <= 0) {
                                throw new NullPointerException();
                            }
                            status = 1;
                        } catch (NumberFormatException | NullPointerException e) {
                            System.out.println("ERROR: Please, type a valid number.");
                        }
                    } while (status == 0);

                    API.searchCurrencyValues(choiceCountry, choiceToCountry, choiceValue);
                    break;
                case 8:
                    System.out.println("Ok, it's exiting now. See you later! =)");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }

            if (choiceMenu != 8 & choiceMenu < 8) {
                System.out.print("\nDo you wanna search one more? (y) Yes  (n) No  -> ");
                String choice = reader.nextLine().toUpperCase();
                if (choice.equals("N")) {
                    break;
                }
            }
        } while(choiceMenu != 8);
    }
}