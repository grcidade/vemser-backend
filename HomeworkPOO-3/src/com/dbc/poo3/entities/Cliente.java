package com.dbc.poo3.entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;

    private List<Contato> contatos = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void imprimirContatos(){
        for (Contato contato : contatos){
            if(contato != null){
                contato.imprimirContato();
            }
        }
    }

    public void imprimirEnderecos(){
        for (Endereco endereco : enderecos){
            if(endereco != null){
                endereco.imprimirEndereco();
            }
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
