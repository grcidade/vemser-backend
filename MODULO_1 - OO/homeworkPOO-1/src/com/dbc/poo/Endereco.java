package com.dbc.poo;

public class Endereco {

    public int tipo; // 1 - residencial 2 - comercial
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

    public Endereco(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public void imprimirEndereco(){
        String  tipoMsg;
        if(tipo == 1){
            tipoMsg = "Residencial";
        } else if(tipo == 2){
            tipoMsg = "Comercial";
        } else{
            throw new IllegalArgumentException("Tipo de contato invalido");
        }
        System.out.println("Tipo: " + tipo + " - " + tipoMsg + "\n" + "Logradouro: " + logradouro + "\n" + "Número: " + numero + "\n" + "Complemento: " + complemento + "\n" +
                        "Cep: " + cep + "\n" + "Cidade: " + cidade + "\n" + "Estado: " + estado + "\n" + "País: " + pais);
    }
}
