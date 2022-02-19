package com.dbc.poo;

import java.util.Arrays;

public class Cliente {

    public String nome;
    public String cpf;

    public Contato[] contatos;
    public Endereco[] enderecos;

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void imprimirContatos(){
        for (Contato contato : contatos) {
            contato.imprimirContato();
        }
    }

    public void imprimirEnderecos(){
        for (Endereco endereco : enderecos) {
            endereco.imprimirEndereco();
        }
    }

    public void imprimirCliente(){
        System.out.println("Nome: " + nome + "\n" + "CPF: " + cpf);
        System.out.println("Endereços: ");
        imprimirEnderecos();
        System.out.println("Contatos: ");
        imprimirContatos();
    }
}
