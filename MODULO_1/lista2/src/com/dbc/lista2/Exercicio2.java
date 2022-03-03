package com.dbc.lista2;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha um número: ");
        int numeroEscolhido = sc.nextInt();

        System.out.println("Qual numero você acha que é?");
        int numeroAdivinhado = sc.nextInt();

        while(numeroEscolhido != numeroAdivinhado){
            if(numeroAdivinhado < numeroEscolhido){
                System.out.println("O número a ser encontrado é maior do que você digitou");
            } else{
                System.out.println("O número a ser encontrado é menor do que você digitou");
            }
            System.out.println("Tente novamente: ");
            numeroAdivinhado = sc.nextInt();
        }
        System.out.println("Parabéns você acertou!");

        sc.close();
    }
}
