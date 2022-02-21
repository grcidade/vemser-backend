package com.dbc.poo;

public class Main {

    public static void main(String[] args) {

        //INSTANCIANDO OBJETOS
        Contato cont = new Contato("Amigo 1","51987463548", 2);
        Contato cont2 = new Contato("Amigo 2","51929463548", 1);
        Endereco end = new Endereco(1, "Rua Tabajara", 95, "APTO 603", "94910200", "Cachoeirinha",  "RS", "Brasil");
        Endereco end2 = new Endereco(2, "Avenida dos Estados", 110, "APTO 4", "94910110", "Porto Alegre",  "RS", "Brasil");
        Cliente cliente1 = new Cliente("Guilherme", "05056129097");
        Cliente cliente2 = new Cliente("Marcio", "05056124597");
        cliente1.contatos[0] = cont;
        cliente1.contatos[1] = cont2;
        cliente2.contatos[0] = cont;
        cliente2.contatos[1] = cont2;
        cliente1.enderecos[0] = end;
        cliente1.enderecos[1] = end2;
        cliente2.enderecos[0] = end;
        cliente2.enderecos[1] = end2;
        ContaCorrente cc1 = new ContaCorrente("7623", 2, 400.00, 100.00, cliente1);
        ContaCorrente cc2 = new ContaCorrente("8623", 1, 800.00, 50.00, cliente2);

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

        System.out.println("====================================================================");
        System.out.println("TESTANDO MÉTODOS CONTA CORRENTE");
        System.out.println();
        System.out.println("*Imprimir Conta Corrente*");
        cc1.imprimirContaCorrente();
        System.out.println();
        System.out.println("*Testando Saque*");
        if(cc1.sacar(200.00)){
            System.out.println("Funcionou!");
        }
        System.out.println();
        System.out.println("*Testando Deposito*");
        if(cc1.depositar(300.00)){
            System.out.println("Funcinou!");
        }
        System.out.println();
        System.out.println("*Testando Retorno do Saldo + Cheque Especial*");
        double total = cc1.retornarSaldoComChequeEspecial();
        System.out.println("Saldo + Cheque Especial: " + total);
        System.out.println();
        System.out.println("*Testando Transferência*");
        if(cc1.trasnferir(cc2, 200)){
            System.out.println("Funcionou!");
        }

    }
}
