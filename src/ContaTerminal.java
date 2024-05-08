import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        int numeroConta;
        String agencia;
        String nomeCliente;
        int operacao;
        double saldoAtual = 0;
        double valorOperacao;
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("Por favor, informe o número da sua conta:");
        numeroConta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Agora diga a agência:");
        agencia = scanner.next();
        scanner.nextLine();

        System.out.println("Agora informe seu nome:");
        nomeCliente = scanner.next();
        scanner.nextLine();

        System.out.println("Seja bem-vindo, senhor " + nomeCliente + "!");
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Agência: " + agencia);
        System.out.println("Saldo atual: " + saldoAtual + "R$");

        do {
            try {
                System.out.println("\nSe deseja fazer uma operação, digite 1 para depositar, 2 para sacar ou 0 para sair:");
                operacao = scanner.nextInt();
                scanner.nextLine();

                switch (operacao) {
                    case 1:
                        System.out.println("Quanto deseja depositar?");
                        valorOperacao = scanner.nextDouble();
                        saldoAtual += valorOperacao;
                        System.out.println("Depósito de " + valorOperacao + "R$ realizado com sucesso!");
                        System.out.println("Seu saldo atual é de: " + saldoAtual + "R$");
                        break;
                    case 2:
                        if (saldoAtual == 0) {
                            System.out.println("Você não possui saldo para sacar!");
                        } else {
                            System.out.println("Quanto deseja sacar?");
                            valorOperacao = scanner.nextDouble();
                            if (valorOperacao > saldoAtual) {
                                System.out.println("Saldo insuficiente para realizar o saque!");
                            } else {
                                saldoAtual -= valorOperacao;
                                System.out.println("Saque de " + valorOperacao + "R$ realizado com sucesso!");
                                System.out.println("Seu saldo atual é de: " + saldoAtual + "R$");
                            }
                        }
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Operação inválida! Digite 1 para depositar, 2 para sacar ou 0 para sair.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número válido.");
                scanner.nextLine();
                operacao = -1;
            }
        } while (operacao != 0);

        System.out.println("Obrigado por utilizar nossos serviços. Tenha um bom dia!");
        scanner.close();
    }
}