package com.dbc.lista2;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] vect = new double[20];

        for(int i = 0; i < vect.length; i++){
            System.out.println("Digite o numero " + (i + 1));
            vect[i] = sc.nextDouble();
        }

        System.out.println("==========================================================");
        for(int i = vect.length - 1; i >= 0; i--){
            System.out.println(vect[i]);
        }

        sc.close();
    }
}
