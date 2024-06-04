package Services;

import Models.Conversion;
import Models.Currency;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Map;

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
        System.out.println("\nRESULT ->  " + currencyStr + " " + value + " = " + toCurrencyStr + " " + result);
    }
}
