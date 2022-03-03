package com.dbc.poo2.interfaces;

import com.dbc.poo2.entities.Conta;

public interface Movimentacao {

    boolean sacar(double valor);
    boolean depositar(double valor);
    boolean transferir(Conta conta, double valor);

}

