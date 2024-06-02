package Models;

public record Address(String cep, String logradouro, String bairro, String localidade, String uf) {
    @Override
    public String toString() {
        return "CEP: " + cep + "\n" +
                "Rua: " + logradouro + "\n" +
                "Bairro: " + bairro + "\n" +
                "Cidade: " + localidade + "\n" +
                "UF: " + uf + "\n";
    }
}
