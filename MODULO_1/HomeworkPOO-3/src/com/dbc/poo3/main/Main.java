package com.dbc.poo3.main;


import com.dbc.poo3.entities.*;

public class Main {

    public static void main(String[] args) {

        //INSTANCIANDO OBJETOS
        Contato cont = new Contato("Amigo 1","51987463548", 2);
        Contato cont2 = new Contato("Amigo 2","51929463548", 1);
        Endereco end = new Endereco(1, "Rua Tabajara", 95, "APTO 603", "94910200", "Cachoeirinha",  "RS", "Brasil");
        Endereco end2 = new Endereco(2, "Avenida dos Estados", 110, "APTO 4", "94910110", "Porto Alegre",  "RS", "Brasil");
        Cliente cliente1 = new Cliente("Guilherme", "05056129097");
        Cliente cliente2 = new Cliente("Marcio", "05056124597");
        cliente1.getContatos().add(cont);
        cliente1.getContatos().add(cont2);
        cliente1.getEnderecos().add(end);
        cliente1.getEnderecos().add(end2);
        cliente2.getEnderecos().add(end);
        cliente2.getEnderecos().add(end2);
        cliente2.getContatos().add(cont);
        cliente2.getContatos().add(cont2);

        ContaCorrente cc1 = new ContaCorrente("7584",1, 500, cliente1, 100.00);
        ContaPoupanca cp1 = new ContaPoupanca("7263", 2, 500, cliente1);
        ContaPagamento contaPag1 = new ContaPagamento("7263", 3, 500, cliente2);

        System.out.println("=======TESTE MOVIMENTAÇÕES=======");
        System.out.println();
        System.out.println("*Saque Conta Corrente*");
        if(cc1.sacar(550)){
            System.out.println("Funcionou");
        }
        System.out.println();
        System.out.println("*Saque Conta Poupança*");
        if(cp1.sacar(400)){
            System.out.println("Funcionou");
        }
        System.out.println();
        System.out.println("*Saque Conta Pagamento*");
        if(contaPag1.sacar(495)){
            System.out.println("Funcionou");
        }
        System.out.println();
        System.out.println("*Deposito Conta Corrente*");
        if(cc1.depositar(100)){
            System.out.println("Funcionou");
        }
        System.out.println();
        System.out.println("*Transferencia Conta Corrente para Conta Pagamento*");
        if(cc1.transferir(contaPag1, 35)){
            System.out.println("Funcionou");
        }


        /*System.out.println("====================================================================");
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
        cc1.imprimir();
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
        if(cc1.transferir(cc2, 100)){
            System.out.println("Funcionou!");
        }
        System.out.println("====================================================================");
        System.out.println("TESTANDO MÉTODOS CONTA POUPANÇA");
        System.out.println();
        System.out.println("*Imprimir Conta Poupança*");
        cp1.imprimir();
        cp1.creditarTaxa();
        System.out.println();
        cp1.imprimir();
        System.out.println();
        cp2.imprimir();*/



    }
}
