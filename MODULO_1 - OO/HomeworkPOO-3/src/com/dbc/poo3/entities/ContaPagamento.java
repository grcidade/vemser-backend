package com.dbc.poo3.entities;

import com.dbc.poo3.interfaces.Impressao;

public class ContaPagamento extends Conta implements Impressao {

    public static final double TAXA_SAQUE = 4.25;

    public ContaPagamento(String numeroConta, int agencia, double saldo, Cliente cliente) {
        super(numeroConta, agencia, saldo, cliente);
    }

    @Override
    public boolean sacar(double valor){
        if(valor > super.getSaldo()){
            throw new IllegalArgumentException("Valor de saque mais alto do que deveria!");
        }
        if(valor < 0.0){
            throw new IllegalArgumentException("Valor deve ser maior do que 0!");
        }
        if((getSaldo() - valor) - TAXA_SAQUE < 0.0){
            throw new IllegalArgumentException("Valor de saldo indisponível");
        }
        setSaldo((getSaldo() - valor) - TAXA_SAQUE);
        System.out.println("Saque de " + valor + "R$");
        System.out.println("Novo saldo: " + getSaldo());
        return true;
    }

    @Override
    public void imprimir() {
        System.out.println("Cliente:");
        getCliente().imprimirCliente();
        System.out.println("Numero da conta: " + getNumeroConta() + "\n" + "Agencia: " + getAgencia() + "\n" + "Saldo: " + String.format("%.2f", getSaldo()));
    }
}
