package com.dbc.poo3.entities;

import com.dbc.poo3.interfaces.Movimentacao;

public abstract class Conta implements Movimentacao {

    private String numeroConta;
    private int agencia;
    private double saldo;

    public Cliente cliente;

    public Conta(String numeroConta, int agencia, double saldo, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean sacar(double valor){
        if(valor > saldo){
            throw new IllegalArgumentException("Valor de saque mais alto do que deveria!");
        }
        if(valor < 0.0){
            throw new IllegalArgumentException("Valor deve ser maior do que 0!");
        }
        saldo -= valor;
        System.out.println("Saque de " + valor + "R$");
        System.out.println("Novo saldo: " + saldo);
        return true;
    }

    @Override
    public boolean depositar(double valor){
        if(valor <= 0.0){
            throw new IllegalArgumentException("Valor de depósito deve ser maior que 0!");
        }
        saldo += valor;
        System.out.println("Depósito de " + valor + "R$");
        System.out.println("Novo saldo: " + saldo);
        return true;
    }

    @Override
    public boolean transferir(Conta conta, double valor){
        if(valor <= 0.0 || valor > saldo){
            throw new IllegalArgumentException("Valor de transferência deve ser maior que 0 e menor que o valor de saldo disponível");
        }
        saldo -= valor;
        conta.saldo += valor;
        System.out.println("A conta número " + numeroConta + " do " + cliente.getNome() + " transferiu " + valor
                + "R$ para a conta número " + conta.numeroConta + " do " + conta.cliente.getNome() + "!");
        return true;
    }
}
