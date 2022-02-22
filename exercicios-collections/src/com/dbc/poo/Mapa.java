package com.dbc.poo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mapa {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o CPF:");
        String cpf = sc.next();
        System.out.println("Digite o nome:");
        String nome = sc.next();

        while(!cpf.equalsIgnoreCase("sair")){

            map.put(cpf, nome);

            System.out.println("Digite o cpf:");
            cpf = sc.next();

            if (cpf.equalsIgnoreCase("sair")) {
                break;
            } else{
                System.out.println("Digite o nome: ");
                nome = sc.next();
            }
        }

        System.out.println("Qual CPF deseja consultar: ");
        String procurarCPF = sc.next();

        if(map.get(procurarCPF) != null){
            System.out.println(map.get(procurarCPF));
            map.remove(procurarCPF);
        } else {
            System.out.println("CPF não encontrado");
        }

        System.out.println();
        System.out.println(map);


        sc.close();

    }
}
