package com.dbc.lista1;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int refazer = 0;
        do{
            refazer = 2;
            System.out.println("Digite suas quatro notas:");
            System.out.println("N1:");
            double n1 = sc.nextDouble();
            System.out.println("N2:");
            double n2 = sc.nextDouble();
            System.out.println("N3:");
            double n3 = sc.nextDouble();
            System.out.println("N4:");
            double n4 = sc.nextDouble();

            double notaFinal = ((n1 + n2 + n3 + n4)/4);

            if(notaFinal <= 5.0){
                System.out.println("Você está reprovado, sua nota foi: " + String.format("%.1f", notaFinal));
            } else if(notaFinal <= 6.9){
                System.out.println("Você está em exame, sua nota foi: " + String.format("%.1f", notaFinal));
            } else if(notaFinal <= 10){
                System.out.println("Você está aprovado, sua nota foi: " + String.format("%.1f", notaFinal));
            } else{
                System.out.println("Erro! notas podem ter sido digitadas errado.");
                System.out.println("Gostaria de tentar novamente? (1 - sim / 2 - não)");
                refazer = sc.nextInt();
            }
        }while(refazer == 1);

        sc.close();
    }
}
