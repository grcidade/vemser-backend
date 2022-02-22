package com.dbc.poo;

import java.util.Scanner;
import java.util.Stack;

public class Pilha {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> pilha = new Stack<>();

        int x = 1;
        while(x <= 15){

            System.out.println("Digite o numero " + x);
            int numero = sc.nextInt();
            if(numero % 2 == 0){
                System.out.println("Par! Adicionando na lista");
                pilha.add(numero);
            }else if(!pilha.isEmpty()){
                System.out.println("Impar! Retirando um valor da lista");
                pilha.pop();
            }else{
                System.out.println("Pilha vazia! Não é possível retirar um número.");
            }
            x++;
        }

        System.out.println();
        System.out.println("Esvaziando pilha!");
        while(!pilha.isEmpty()){
            System.out.println("Retirando: ");
            System.out.println(pilha.pop());
        }

        System.out.println();
        System.out.println("Pilha vazia: ");
        System.out.println(pilha);

        sc.close();

    }
}
