package com.dbc.poo;

public class Contato {

    public String descricao;
    public String telefone;
    public int tipo; // 1 - residencial / 2 - comercial

    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public void imprimirContato(){
        String  tipoMsg;
        if(tipo == 1){
            tipoMsg = "Residencial";
        } else{
            tipoMsg = "Comercial";
        }
        System.out.println("Descrição: " + descricao + "\n"
                        + "Telefone: " + telefone + "\n"
                        + "Tipo: " + tipo + " - " + tipoMsg);
    }
}
