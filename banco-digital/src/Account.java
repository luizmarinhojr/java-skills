import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements IAccount{
    protected Bank bank = new Bank("998", "Miscs Bank");
    private final int agency;
    private final String number;
    private final Client client;
    private BigDecimal balance;
    private List<Transaction> transactions;

    public Account(int agency, String number, Client client) {
        transactions = new ArrayList<>();
        this.agency = agency;
        this.number = number;
        this.balance = new BigDecimal(0).setScale(2, RoundingMode.HALF_EVEN);
        this.client = client;
    }

    @Override
    public boolean deposit(double value) {
        BigDecimal valueFormatted = new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN);
        this.balance = this.balance.add(valueFormatted);
        System.out.println("Depósito efetuado com sucesso");
        transactions.add(new Transaction(
                LocalDateTime.now(), valueFormatted, Operations.DEPOSIT, Account.this, null));
        return true;
    }

    @Override
    public boolean withdraw(double valueWithdraw) {
        BigDecimal valueFormatted = new BigDecimal(valueWithdraw).setScale(2, RoundingMode.HALF_EVEN);
        if (this.balance.compareTo(valueFormatted) >= 0 ) {
            this.balance = this.balance.subtract(valueFormatted);
            System.out.println("Saque realizado com sucesso!");
            transactions.add(new Transaction(
                    LocalDateTime.now(), valueFormatted, Operations.WITHDRAW, Account.this, null));
            return true;
        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    @Override
    public boolean transfer(double valueTransfer, Account toAccount) {
        BigDecimal valueFormatted = new BigDecimal(valueTransfer).setScale(2, RoundingMode.HALF_EVEN);
        if (this.balance.compareTo(valueFormatted) >= 0) {
            this.balance = this.balance.subtract(valueFormatted);
            System.out.println("Transferência realizada para a Ag: " + toAccount.getAgency() + " | Conta: " + toAccount.getNumber());
            toAccount.depositViaTransfer(valueTransfer, Account.this);
            transactions.add(new Transaction(
                    LocalDateTime.now(), valueFormatted, Operations.TRANSFER, Account.this, toAccount));
            return true;
        }
        return false;
    }

    @Override
    public boolean depositViaTransfer(double value, Account fromAccount) {
        BigDecimal valueFormatted = new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN);
        this.balance = this.balance.add(valueFormatted);
        System.out.println("Transferência recebida de Ag: " + fromAccount.getAgency() + " | Conta: " + fromAccount.getNumber());
        transactions.add(new Transaction(
                LocalDateTime.now(), valueFormatted, Operations.DEPOSIT, fromAccount, null));
        return true;
    }

    public String getBalance() {
        return "Saldo atual: R$ " + this.balance;
    }

    public Client getClient() {
        return client;
    }

    public String getNumber() {
        return number;
    }

    public int getAgency() {
        return agency;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Banco: " + bank + "\n" +
                "Agência: " + agency + "\n" +
                "Conta: " + number + '\'' + "\n" +
                "Cliente" + client.name() + "\n";
    }
}
