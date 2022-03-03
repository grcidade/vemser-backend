package com.dbc.lista2;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] vect = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        System.out.println("Qual número procura?");
        int numeroProcurado = sc.nextInt();
        boolean msg = true;

        for(int i = 0; i < vect.length; i++){
            if(vect[i] == numeroProcurado){
                System.out.println("Existe esse número e está na posição " + i + " do vetor");
                msg = false;
            }
        }

        if(msg){
            System.out.println("Não existe o valor procurado");
        }


        sc.close();
    }
}
