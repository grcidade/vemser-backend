package com.dbc.poo;

public class ContaCorrente {

    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial;

    public Cliente cliente;

    public ContaCorrente(String numeroConta, int agencia, double saldo, double chequeEspecial, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
        this.cliente = cliente;
    }

    public void imprimirContaCorrente(){
        System.out.println("Número da conta: " + numeroConta + "\n" + "Agência: " + agencia + "\n" + "Saldo: " + String.format("%.2f", saldo) + "\n"
                           + "Cheque Especial: " + String.format("%.2f",chequeEspecial));
        cliente.imprimirCliente();
    }

    public boolean sacar(double valor){
        if(valor > retornarSaldoComChequeEspecial() || valor < 0.0){
            throw new IllegalArgumentException("Valor de saque mais alto do que deveria!");
        }
        if(valor > saldo){
            double resto = valor - saldo;
            saldo = 0.0;
            chequeEspecial -= resto;
            System.out.println("Saque de " + valor + "R$");
            System.out.println("Novo saldo: " + saldo);
            System.out.println("Quantidade de cheque especial: " + chequeEspecial);
            return true;
        }
        saldo -= valor;
        System.out.println("Saque de " + valor + "R$");
        System.out.println("Novo saldo: " + saldo);
        return true;
    }

    public boolean depositar(double valor){
        if(valor <= 0.0){
            throw new IllegalArgumentException("Valor de depósito deve ser maior que 0!");
        }
        saldo += valor;
        System.out.println("Depósito de " + valor + "R$");
        System.out.println("Novo saldo: " + saldo);
        return true;
    }

    public double retornarSaldoComChequeEspecial(){
        return saldo + chequeEspecial;
    }

    public boolean trasnferir(ContaCorrente cc, double valor){
        if(valor <= 0.0 || valor > saldo){
            throw new IllegalArgumentException("Valor de transferência deve ser maior que 0 e menor que o valor de saldo disponível");
        }
        saldo -= valor;
        cc.saldo += valor;
        System.out.println("A conta número " + numeroConta + " do " + cliente.nome + " tranferiu " + valor
                           + "R$ para a conta número " + cc.numeroConta + " do " + cc.cliente.nome + "!");
        return true;
    }
}
