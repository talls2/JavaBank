package programa;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta    |");
        System.out.println("|   Opção 2 - Depositar      |");
        System.out.println("|   Opção 3 - Sacar          |");
        System.out.println("|   Opção 4 - Transferir     |");
        System.out.println("|   Opção 5 - Listar Todas   |");
        System.out.println("|   Opção 6 - Examinar Conta |");
        System.out.println("|   Opção 7 - Sair           |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                listarConta();
                break;
            case 7:
                System.out.println("até a proxima");
                break;
            default:
                System.out.println("opção invalida");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String CPF = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, CPF, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Conta criada com sucesso!");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) { // verifica se existem contas criadas
            for (Conta c : contasBancarias) { // percorre as contas existentes
                if (c.getNumeroConta() == numeroConta) { // verifica uma por uma se a conta bate com a condição
                    conta = c; //se bater, retorna a conta
                }
            }

        } else {
            System.out.println("Não existem contas criadas");

        }
        return conta;
    }

    public static void depositar() {
        System.out.println("insira o numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depositar?");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();

    }

    public static void sacar() {
        System.out.println("Insira o numero da conta");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja Sacar?");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
        }
        operacoes();
    }
    public static void transferir() {
        System.out.println("Insira a conta de origem");
        int numeroConta1 = input.nextInt();

        Conta conta1 = encontrarConta(numeroConta1);
        if (conta1 != null) {
            System.out.println("Insira a conta que irá receber a transferencia ");
            int numeroConta2 = input.nextInt();

            Conta conta2 = encontrarConta(numeroConta2);

            if (conta2 != null) {
                System.out.println("insira o valor da transferencia");
                Double valorTransferencia = input.nextDouble();

                conta1.transferir(conta2, valorTransferencia);
            }
            else {
                System.out.println("Conta informada invalida");
            }
        }
        else {
            System.out.println("Conta informada invalida");
        }
        operacoes();
    }

    public static void listar() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        }
        else{
                System.out.println("Não há contas cadastradas!");
            }
        operacoes();
    }




    public static void listarConta(){
        System.out.println("insira a conta que deseja verificar");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);
        if (conta != null){
            String lista = conta.toString();
            System.out.println(lista);
        }
        else {
            System.out.println("Conta inexistente");
        }
        operacoes();
    }
}