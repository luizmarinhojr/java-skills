package com.luizmarinho.vehicles.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public record Vehicle (@JsonAlias("Valor") String value,
    @JsonAlias("Marca") String brand, @JsonAlias("Modelo") String model, 
    @JsonAlias("AnoModelo") int year, @JsonAlias("Combustivel") String fuel, 
    @JsonAlias("CodigoFipe") String fipeCode, @JsonAlias("MesReferencia") String monthRef) {

    public Double price() {
        try {
            return Double.parseDouble(value().substring(3, value().length() - 3).replace(".", ""));
        } catch(NumberFormatException e) {
            System.out.println("It didn't convert to double");
            return 0.0;
        }
    }

    public String resumeCar() {
        return String.format("Value: R$ %,.2f | Brand: %s | Model: %s | Year: %d | Fuel: %s", price(), brand(), model(), year(), fuel());
    }

    @Override
    public String toString() {

        return String.format("""
                Value: R$ %,.2f
                Brand: %s
                Model: %s
                Year: %d
                Fuel: %s
                Fipe Code: %s
                Reference Month: %s
                """, price(), brand(), model(), year(), fuel(), fipeCode(), monthRef());
    }

}
