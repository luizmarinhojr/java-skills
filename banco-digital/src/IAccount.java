
public interface IAccount {
    boolean deposit(double value);
    boolean withdraw(double valueWithdraw);
    boolean transfer(double valueTransfer, Account toAccount);
    boolean depositViaTransfer(double value, Account fromAccount);
}
