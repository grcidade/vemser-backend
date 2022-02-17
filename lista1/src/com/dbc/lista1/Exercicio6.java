package com.dbc.lista1;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a palavra gostaria de traduzir:\n"
                        + "(Cachorro)\n"
                        + "(Tempo)\n"
                        + "(Amor)\n"
                        + "(Cidade)\n"
                        + "(Feliz)\n"
                        + "(Dog)\n"
                        + "(Time)\n"
                        + "(Love)\n"
                        + "(City)\n"
                        + "(Happy)\n");

        String palavra = sc.next();

        if(palavra.equalsIgnoreCase("cachorro")){
            System.out.println("A tradução de Cachorro é Dog");
        } else if(palavra.equalsIgnoreCase("dog")){
            System.out.println("A tradução de Dog é Cachorro");
        } else if(palavra.equalsIgnoreCase("tempo")){
            System.out.println("A tradução de Tempo é Time");
        } else if(palavra.equalsIgnoreCase("time")){
            System.out.println("A tradução de Time é Tempo");
        } else if(palavra.equalsIgnoreCase("amor")){
            System.out.println("A tradução de Amor é Love");
        } else if(palavra.equalsIgnoreCase("love")){
            System.out.println("A tradução de Love é Amor");
        } else if(palavra.equalsIgnoreCase("cidade")){
            System.out.println("A tradução de Cidade é City");
        } else if(palavra.equalsIgnoreCase("city")){
            System.out.println("A tradução de City é Cidade");
        } else if(palavra.equalsIgnoreCase("feliz")){
            System.out.println("A tradução de Feliz é Happy");
        } else if(palavra.equalsIgnoreCase("happy")){
            System.out.println("A tradução de Happy é Feliz");
        } else{
            System.out.println("Essa palavra não é válida");
        }

        sc.close();
    }
}
