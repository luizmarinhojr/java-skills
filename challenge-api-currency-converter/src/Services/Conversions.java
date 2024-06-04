package Services;

import Models.Conversion;
import Models.Currency;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import java.util.Scanner;

public class Conversions {
    public static void deserialize(String json, String currencyStr, String chToCurrency, double value) {
        Gson gson = new Gson();
        Conversion conversion = gson.fromJson(json, Conversion.class);

        TypeToken<Map<String, Double>> mapType = new TypeToken<>() {};
        Map<String, Double> stringMap = gson.fromJson(conversion.conversion_rates(), mapType);
        Currency currency = new Currency(stringMap);

        exchangeRate(value, currencyStr, chToCurrency, currency.mapCurrencies().get(chToCurrency)); // running the calculation
    }

    public static void exchangeRate(double value, String currencyStr, String toCurrencyStr, double toCurrency) {
        double result = value * toCurrency;
        System.out.printf("\nRESULT ->  %s %,.2f = %s %,.2f\n", currencyStr, value, toCurrencyStr, result);
//        System.out.println("\nRESULT ->  " + currencyStr + " " + value + " = " + toCurrencyStr + " " + result);
    }

    public static double askValue(String currency) {
        Scanner reader = new Scanner(System.in);
        double choiceValue = 0;
        int status = 0;
        do {
            try {
                System.out.print("Type the value you wanna convert: " + currency + " ");
                choiceValue = Double.parseDouble(reader.nextLine());
                if (choiceValue <= 0) {
                    throw new NullPointerException();
                }
                status = 1;
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("ERROR: Please, type a valid number.");
            }
        } while (status == 0);

        return choiceValue;
    }
}
