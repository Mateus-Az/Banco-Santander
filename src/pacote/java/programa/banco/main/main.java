package pacote.java.programa.banco.main;

import pacote.java.programa.banco.acount.Conta;

import pacote.java.programa.banco.pessoa.Cliente;

import javax.swing.*;
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
        int opcoes = 10;
        try {
            opcoes = Integer.parseInt(JOptionPane.showInputDialog(
                       ( "=======================================================\n") +
                     ( "   <<<<<<<<<<<<<<Bem Vindo ao Banco Santander>>>>>>>>>>>>\n") +
                      ("  =======================================================\n")+
            ("                                  INFORME A OPÇÃO DESEJADA:\n")+
            ("[0]° Para Abrir uma conta conosco,   \n")+
            ("[1]° Para realizar um saque,        \n")+
            ("[2]° Para realizar um deposito,    \n")+
            ("[3]° Para realizar uma transferência,  \n")+
            ("[4]° Para verificar informações,     \n")+
            ("[5]° Para encerrar o serviço,         \n")));

        }catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null,"Opção Inválida");
        }

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
        Conta conta = encontrarConta(Integer.parseInt(JOptionPane.showInputDialog("Numero da conta de Origem da transferência")));
        if (conta != null) {
            Conta conta1 = encontrarConta(Integer.parseInt(JOptionPane.showInputDialog("Numero da conta de destino da transferência")));
            if (conta1 != null) {
                double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência"));
                conta.transferir(conta1, valorTransferencia);
            }
        }exibirOpcoes();
    }

    private static void verificarInformacoes() {
        if (clientes.size() > 0) {
            for (Conta conta : clientes) {
                System.out.println(conta);
            }
        } else {
            JOptionPane.showMessageDialog(null,"ERRO!","ERRO", JOptionPane.ERROR_MESSAGE );
        }
        exibirOpcoes();
    }


    private static void realizarDeposito() {
        Conta conta = encontrarConta(Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta que deseja depositar")));
        if (conta != null) {
            double valorDeposito = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor a ser depositado"));
            conta.depositar(valorDeposito);
        } else {
            JOptionPane.showMessageDialog(null,"ERRO!","ERRO", JOptionPane.ERROR_MESSAGE );
        }
        exibirOpcoes();
    }

    private static void realizarSaque() {
        int numeroDaConta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número para Realizar o saque"));
        Conta conta = encontrarConta(numeroDaConta);
        if (conta != null) {
            System.out.println("Valor do saque");
            double valorDoSaque = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor para Saque"));
            conta.sacar(numeroDaConta);
        }exibirOpcoes();
    }

    private static void criarConta() {
        String nome = JOptionPane.showInputDialog("Digite seu nome");
        String cpf = JOptionPane.showInputDialog("Digite seu cpf");
        String email = JOptionPane.showInputDialog("Digite seu email");
        Cliente cliente = new Cliente(nome, cpf, email);
        Conta conta = new Conta(cliente);
        clientes.add(conta);
        JOptionPane.showMessageDialog(null,("Conta Criada com sucesso\n")+
                ("\nNome: " + nome)+
                ("\nCPF: " + cpf)+
                ("\nEmail: " + email)+
                ("\nAgência : " + conta.getAgencia())+
                ("\nConta : " + conta.getConta()));
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
        }else{
            JOptionPane.showMessageDialog(null,"ERRO!","ERRO", JOptionPane.ERROR_MESSAGE );
        }
        return ct;
    }
}