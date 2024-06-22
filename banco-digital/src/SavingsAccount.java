public class SavingsAccount extends Account{
    private String tipo = "Poupança";

    public SavingsAccount(int agency, String number, Client client) {
        super(agency, number, client);
        bank.addAccount(SavingsAccount.this);
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Banco: " + bank.getName() + "\n" +
                "Tipo Conta: " + tipo + "\n" +
                "Agência: " + getAgency() + "\n" +
                "Conta: " + getNumber() + "\n" +
                "Cliente: " + getClient().name() + "\n";
    }
}
