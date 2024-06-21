import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        

        System.out.print("Digite o número da conta: ");
        int numeroConta;
        try {
            numeroConta = Integer.parseInt(reader.nextLine());
        } catch (NumberFormatException e) {
            numeroConta = 0;
            System.out.println("Erro! formato de entrada inválido");
        }

        System.out.print("Digite o número da sua agência com o digito: ");
        String agencia = reader.nextLine();

        System.out.print("Digite o seu nome: ");
        String nomeCliente = reader.nextLine();

        System.out.print("Digite o saldo da conta: ");
        double saldo;
        try {
            saldo = Double.parseDouble(reader.nextLine());
        } catch (NumberFormatException | NullPointerException e) {
            saldo = 0.0;
            System.out.println("Erro! formato de entrada inválido");
        }

        reader.close();

        System.out.println("\nOlá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numeroConta + " e seu saldo " + saldo + " já está disponível para saque");
    }
}
