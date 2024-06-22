public class CheckingAccount extends Account{
    private String tipo = "Corrente";

    public CheckingAccount(int agency, String number, Client client) {
        super(agency, number, client);
        bank.addAccount(CheckingAccount.this);
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
