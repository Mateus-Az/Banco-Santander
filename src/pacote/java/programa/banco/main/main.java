package pacote.java.programa.banco.main;

import pacote.java.programa.banco.acount.Conta;

import pacote.java.programa.banco.pessoa.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    static Scanner scanner;
    static List<Conta> clientes;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        clientes = new ArrayList<>();
        exibirOpcoes();
    }


    public static void exibirOpcoes() {

        System.out.println("                ======================================================");
        System.out.println("                <<<<<<<<<<<<<<Bem Vindo ao Banco Santander>>>>>>>>>>>>");
        System.out.println("                ======================================================");
        System.out.println("                INFORME A OPÇÃO DESEJADA:");
        System.out.println("                            ° Para Abrir uma conta conosco,      | [0]");
        System.out.println("                           I° Para realizar um saque,            | [1]");
        System.out.println("                           II° Para realizar um deposito,        | [2]");
        System.out.println("                           III° Para realizar uma transferência, | [3]");
        System.out.println("                           IV° Para verificar informações,       | [4]");
        System.out.println("                           V° Para encerrar o serviço,           | [5]");
        int opcoes = scanner.nextInt();
        switch (opcoes) {
            case 0:
                criarConta();
                break;
            case 1:
                realizarSaque();
                break;
            case 2:
                realizarDeposito();
                break;
            case 3:
                realizarTransferencia();
                break;
            case 4:
                verificarInformacoes();
                break;
            case 5:
                System.exit(1);
                break;
            default:
                exibirOpcoes();
                break;
        }
    }

    private static void realizarTransferencia() {
        System.out.println("Numero da conta");
        int contaEnvio = scanner.nextInt();
        Conta conta = encontrarConta(contaEnvio);
        if (conta != null) {
            System.out.println("Numero conta destino");
            int contaDestino = scanner.nextInt();
            Conta conta1 = encontrarConta(contaDestino);
            if (conta1 != null) {
                System.out.println("Valor da transferencia");
                double valorTransferencia = scanner.nextDouble();
                conta.transferir(conta1, valorTransferencia);
            }
        }
        exibirOpcoes();

    }

    private static void verificarInformacoes() {
        if (clientes.size() > 0) {
            for (Conta conta : clientes) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não existem Contas");
        }
        exibirOpcoes();
    }


    private static void realizarDeposito() {
        System.out.println("Para qual conta você deseja depositar? ");
        System.out.println("Digite numero da conta");
        int numeroDaConta = scanner.nextInt();
        Conta conta = encontrarConta(numeroDaConta);
        if (conta != null) {
            System.out.println("Valor a ser depositado");
            double valorDeposito = scanner.nextInt();
            conta.depositar(valorDeposito);
            System.out.println("Depositado");
        } else {
            System.out.println("Conta não encontrada");
        }
        exibirOpcoes();
    }

    private static void realizarSaque() {
        System.out.println("Numero da conta");
        int numeroDaConta = scanner.nextInt();
        Conta conta = encontrarConta(numeroDaConta);
        if (conta != null) {
            System.out.println("Valor do saque");
            double valorDoSaque = scanner.nextDouble();
            conta.sacar(numeroDaConta);
            System.out.println("Saque Realizado");
        } else {
            System.out.println("Não foi possivel Sacar");
            exibirOpcoes();
        }
    }

    private static void criarConta() {
        System.out.println("Nome");
        String nome = scanner.next();
        System.out.println("CPF");
        String cpf = scanner.next();
        System.out.println("Email");
        String email = scanner.next();
        Cliente cliente = new Cliente(nome, cpf, email);
        Conta conta = new Conta(cliente);
        clientes.add(conta);
        System.out.println("Conta criada");
        exibirOpcoes();
    }

    private static Conta encontrarConta(int numeroDaConta) {
        Conta ct = null;
        if (clientes.size() > 0) {
            for (Conta conta : clientes) {
                if (conta.getConta() == numeroDaConta) {
                    ct = conta;
                }
            }
        }
        return ct;
    }

}