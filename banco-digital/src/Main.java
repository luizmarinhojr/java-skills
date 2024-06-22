import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("1", "Mateus Guimarães Soares",
                LocalDate.of(1998, 8, 23),
                "José Gonçalves Guimarães", "Roberta de Lima Soares",
                new Address("Brasil", "24999-888", "RJ", "Niterói",
                        "Rua do Norte", "82", null));

        Client client2 = new Client("2", "Fernanda Gomes Machado",
                LocalDate.of(1992, 11, 16),
                "Nico da Avenida Brasil", "Marta Machado da Silva",
                new Address("Brasil", "22889-888", "SP", "São José dos Campos",
                        "Rua do Sul", "114", null));


        Account account = new CheckingAccount(239, "887332", client1);
        Account account2 = new SavingsAccount(340, "117322", client2);
        account.deposit(1000);

        System.out.println("Conta -> " + account.getBalance());
        System.out.println("Conta2 -> " + account2.getBalance());

        account.withdraw(300);

        account.transfer(300, account2);

        System.out.println("Conta2: " + account2.getBalance());

        System.out.println("Conta: " + account.getBalance());

        System.out.println("\nConta:\n" + account.getTransactions());

        System.out.println("\nConta2:\n" + account2.getTransactions());

        account2.transfer(100, account);

        System.out.println("\nConta:\n" + account.getTransactions());

        System.out.println("\nConta2:\n" + account2.getTransactions());

        System.out.println("Conta -> " + account.getBalance());

        System.out.println("Conta2 -> " + account2.getBalance());

        System.out.println(account);

        System.out.println(account2);
    }
}