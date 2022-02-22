package com.dbc.poo3.interfaces;

import com.dbc.poo3.entities.Conta;

public interface Movimentacao {

    boolean sacar(double valor);
    boolean depositar(double valor);
    boolean transferir(Conta conta, double valor);

}

