package com.dbc.poo3.entities;

public class Contato {

    private String descricao;
    private String telefone;
    private int tipo; // 1 - residencial / 2 - comercial

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public void imprimirContato(){
        String  tipoMsg;
        if(tipo == 1){
            tipoMsg = "Residencial";
        } else if(tipo == 2){
            tipoMsg = "Comercial";
        } else{
            throw new IllegalArgumentException("Tipo de contato invalido");
        }
        System.out.println("Descrição: " + descricao + "\n"
                        + "Telefone: " + telefone + "\n"
                        + "Tipo: " + tipo + " - " + tipoMsg);
    }
}
