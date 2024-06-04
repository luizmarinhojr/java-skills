import Models.EnumCoins;
import Services.API;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int choiceMenu = 0;
        boolean status = false;
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

            do {
                try {
                    System.out.print("\nChoose a option -> ");
                    choiceMenu = Integer.parseInt(reader.nextLine());
                    status = true;
                } catch(NumberFormatException e) {
                    System.out.println("Invalid input, try again");
                }
            } while (!status);

            switch (choiceMenu) {
                case 1:
                    choiceValue = askValue("USD");
                    API.searchCurrencyValues("USD", "ARS", choiceValue);
                    break;
                case 2:
                    choiceValue = askValue("ARS");
                    API.searchCurrencyValues("ARS", "USD", choiceValue);
                    break;
                case 3:
                    choiceValue = askValue("USD");
                    API.searchCurrencyValues("USD", "BRL", choiceValue);
                    break;
                case 4:
                    choiceValue = askValue("BRL");
                    API.searchCurrencyValues("BRL", "USD", choiceValue);
                    break;
                case 5:
                    choiceValue = askValue("USD");
                    API.searchCurrencyValues("USD", "COP", choiceValue);
                    break;
                case 6:
                    choiceValue = askValue("COP");
                    API.searchCurrencyValues("COP", "USD", choiceValue);
                    break;
                case 7:
                    for (EnumCoins e : EnumCoins.values()) { // show all currencies available
                        System.out.println("(" + e + ") - " + e.getDescription());
                    }
                    status = false;
                    do {
                        try {
                            System.out.print("\nFrom currency (Ex: BRL) -> ");
                            choiceCountry = reader.nextLine().toUpperCase();
                            EnumCoins.valueOf(choiceCountry);
                            status = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println("It doesn't exist this currency, please type again");
                        }
                    } while (!status);

                    status = false;
                    do {
                        try {
                            System.out.print("To currency (Ex: USD) -> ");
                            choiceToCountry = reader.nextLine().toUpperCase();
                            EnumCoins.valueOf(choiceToCountry);
                            status = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println("It doesn't exist this currency, please type again");
                        }
                    } while (!status);

                    status = false;
                    do {
                        try {
                            System.out.print("Type the value you wanna convert: " + EnumCoins.valueOf(choiceCountry) + " ");
                            choiceValue = Double.parseDouble(reader.nextLine());
                            if (choiceValue <= 0) {
                                throw new NullPointerException();
                            }
                            status = true;
                        } catch (NumberFormatException | NullPointerException e) {
                            System.out.println("ERROR: Please, type a valid number.");
                        }
                    } while (!status);

                    API.searchCurrencyValues(choiceCountry, choiceToCountry, choiceValue);
                    break;
                case 8:
                    System.out.println("Ok, it's exiting now. See you later! =)");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }

            if (choiceMenu != 8 & choiceMenu < 8) {
                System.out.print("\nDo you want to convert one more? (y) Yes  (n) No  -> ");
                String choice = reader.nextLine().toUpperCase();
                if (choice.equals("N")) {
                    System.out.println("Ok, it's exiting now. See you later! =)");
                    break;
                }
            }
        } while(choiceMenu != 8);
    }

    public static Double askValue(String currency) {
        Scanner reader = new Scanner(System.in);
        double choiceValue = 0;
        boolean status = false;
        do {
            try {
                System.out.print("Type the value you wanna convert: " + currency + " ");
                choiceValue = Double.parseDouble(reader.nextLine());
                if (choiceValue <= 0) {
                    throw new NullPointerException();
                }
                status = true;
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("ERROR: Please, type a valid number.");
            }
        } while (!status);

        return choiceValue;
    }
}