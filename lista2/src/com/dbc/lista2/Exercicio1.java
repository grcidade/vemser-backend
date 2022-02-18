package com.dbc.lista2;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do produto: ");
        String produto = sc.next();
        System.out.println("Digite o valor do produto: ");
        double valorProduto = sc.nextDouble();
        double[] vect = new double[10];
        double desconto = 0.05;

        for(int i = 0; i < vect.length; i++){
            double somaDesconto = 0.05;
            vect[i] = valorProduto - (valorProduto * desconto);
            desconto += somaDesconto;
            System.out.println((i + 1) + " x R$" + String.format("%.2f", vect[i]) + " = R$" + String.format("%.2f",(vect[i] * (i +1))));
        }

        sc.close();
    }
}
