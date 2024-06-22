import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String number; // bank's number
    private final String name;
    private List<Account> accounts;

    public Bank(String number, String name) {
        this.number = number;
        this.name = name;
        accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
