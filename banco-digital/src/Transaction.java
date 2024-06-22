import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class Transaction {
    private final UUID idTransaction;
    private final LocalDateTime dateTime;
    private final BigDecimal value;
    private final String operation;
    private final Account fromAccount;
    private final Account toAccount;

    public Transaction(LocalDateTime dateTime, BigDecimal value, Operations operation, Account fromAccount, Account toAccount) {
        this.idTransaction = randomUUID();
        this.dateTime = dateTime;
        this.value = value;
        this.operation = operation.toString();
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getOperation() {
        return operation;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public UUID getIdTransaction() {
        return idTransaction;
    }

    @Override
    public String toString() {
        String messageFromAccount = fromAccount != null ?
                "From account: [ Agency: " + fromAccount.getAgency() + " Number: " + fromAccount.getNumber() + " ]" : "";
        String messageToAccount = toAccount != null ?
                "To account: [ Agency: " + toAccount.getAgency() + " Number: " + toAccount.getNumber() + " ]" : "";

        return "ID da transação: " + idTransaction + " | " + "DateTime: " + dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " | " +
                "Value: R$ " + value + " | " +
                "Operation: '" + operation + " | " +
                messageFromAccount + " | " +
                messageToAccount + "\n";
    }
}
