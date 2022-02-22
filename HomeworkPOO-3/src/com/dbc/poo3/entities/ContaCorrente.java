package com.dbc.poo3.entities;

import com.dbc.poo3.interfaces.Impressao;

public class ContaCorrente extends Conta implements Impressao {

    private double chequeEspecial;

    public ContaCorrente(String numeroConta, int agencia, double saldo, Cliente cliente, double chequeEspecial) {
        super(numeroConta, agencia, saldo, cliente);
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double retornarSaldoComChequeEspecial(){
        return getSaldo() + chequeEspecial;
    }

    @Override
    public boolean sacar(double valor){
        if(valor > retornarSaldoComChequeEspecial()){
            throw new IllegalArgumentException("Valor de saque mais alto do que deveria!");
        }
        if(valor < 0.0){
            throw new IllegalArgumentException("Valor deve ser maior do que 0!");
        }
        setSaldo(getSaldo() - valor);
        System.out.println("Saque de " + valor + "R$");
        System.out.println("Novo saldo: " + getSaldo());
        return true;
    }

    @Override
    public void imprimir(){
        System.out.println("Cliente:");
        getCliente().imprimirCliente();
        System.out.println("Numero da conta: " + getNumeroConta() + "\n" + "Agencia: " + getAgencia() + "\n" + "Saldo: " + String.format("%.2f", getSaldo()) +
                "\n" + "Cheque Especial: " + chequeEspecial);
    }
}
