package com.dbc.poo;

public class Main {

    public static void main(String[] args) {

        Contato cont = new Contato("Amigo 1","51987463548", 2);
        Contato cont2 = new Contato("Amigo 2","51929463548", 1);
        Endereco end = new Endereco(1, "Rua Tabajara", 95, "APTO 603", "94910200", "Cachoeirinha",  "RS", "Brasil");
        Endereco end2 = new Endereco(2, "Avenida dos Estados", 110, "APTO 4", "94910110", "Porto Alegre",  "RS", "Brasil");
        Cliente cliente1 = new Cliente("Guilherme", "05056129097",new Contato[]{cont, cont2}, new Endereco[]{end, end2});

        System.out.println("====================================================================");
        System.out.println("TESTANDO MÉTODOS CONTATO E ENDEREÇO");
        System.out.println();
        cont.imprimirContato();
        System.out.println();
        end.imprimirEndereco();

        System.out.println("====================================================================");
        System.out.println("TESTANDO MÉTODOS CLIENTE");
        System.out.println();
        System.out.println("*Imprimir Contatos*");
        cliente1.imprimirContatos();
        System.out.println();
        System.out.println("*Imprimir Endereços*");
        cliente1.imprimirEnderecos();
        System.out.println();
        System.out.println("*Imprimir Cliente*");
        cliente1.imprimirCliente();
    }
}
