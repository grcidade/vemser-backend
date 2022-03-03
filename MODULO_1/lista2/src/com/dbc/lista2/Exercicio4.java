package com.dbc.lista2;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] vect = new double[3];

        for(int i = 0; i < vect.length; i++){
            System.out.println("Digite o numero " + (i + 1));
            vect[i] = sc.nextDouble();
        }

        if(vect[0] < vect[1] && vect[0] < vect[2]){
            System.out.println("O menor número está na posiçaõ 0 do vetor");
        } else if(vect[1] < vect[0] && vect[1] < vect[2]){
            System.out.println("O menor número está na posiçaõ 1 do vetor");
        } else if(vect[2] < vect[0] && vect[2] < vect[1]){
            System.out.println("O menor número está na posiçaõ 2 do vetor");
        } else{
            System.out.println("Erro! Os números precisam ser diferentes");
        }

        sc.close();
    }
}
