package com.dbc.poo3.entities;

import com.dbc.poo3.interfaces.Impressao;

public class ContaPoupanca extends Conta implements Impressao {

    public static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(String numeroConta, int agencia, double saldo, Cliente cliente) {
        super(numeroConta, agencia, saldo, cliente);
    }

    public void creditarTaxa(){
        super.setSaldo(getSaldo() * JUROS_MENSAL);
    }

    @Override
    public void imprimir(){
        System.out.println("Cliente:");
        getCliente().imprimirCliente();
        System.out.println("Numero da conta: " + getNumeroConta() + "\n" + "Agencia: " + getAgencia() + "\n" + "Saldo: " + String.format("%.2f", getSaldo()));
    }
}
