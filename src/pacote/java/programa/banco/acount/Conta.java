package pacote.java.programa.banco.acount;

import pacote.java.programa.banco.pessoa.Cliente;
import programa.banco.ultils.FormatadorBr;

import javax.swing.*;

public class Conta {
    private static int quantidaDeContas;

    private int agencia;
    private int conta;
    private Cliente cliente;
    private double saldo = 0.0;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0.0;
        quantidaDeContas += 1;
        setConta(quantidaDeContas);
        this.setAgencia(0);
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", conta=" + conta +
                ", cliente=" + cliente +
                ", saldo=" + FormatadorBr.conversor(this.getSaldo()) +
                '}';
    }

    public void depositar(double valorDoDeposito) {
        if (valorDoDeposito > 0) {
            setSaldo(getSaldo() + valorDoDeposito);
            JOptionPane.showMessageDialog(null, ("Seu dinheiro foi depositado\n") +
                    ("----------Comprovante----------") +
                    ("\nValor depositado: " + valorDoDeposito) +
                    ("\n Seu Saldo atual é: " + getSaldo()));
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar o depósito, tente novamente mais tarde");
        }
    }

    public void sacar(double valorDoSaque) {
        if (this.getSaldo() >= valorDoSaque && valorDoSaque > 0) {
            setSaldo(getSaldo() - valorDoSaque);
            JOptionPane.showMessageDialog(null, "Saque Realizado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "ERRO!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void transferir(Conta contaDestino, double valorDaTransferencia) {
        if (this.getSaldo() >= valorDaTransferencia && valorDaTransferencia > 0) {
            setSaldo(getSaldo() - valorDaTransferencia);
            contaDestino.setSaldo(getSaldo() + valorDaTransferencia);
            JOptionPane.showMessageDialog(null, ("Transferência realizada com sucesso\n") +
                    ("\nValor da transferencia" + valorDaTransferencia));
        } else {
            JOptionPane.showMessageDialog(null, "ERRO!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
