package com.dbc.lista1;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o valor consumido:");
        double valorConsumido = sc.nextDouble();
        System.out.println("Digite o valor pago:");
        double valorPago = sc.nextDouble();

        double troco;
        if(valorPago < valorConsumido){
            System.out.println("O valor pago deve ser maior que o valor consumido!");
        } else{
            troco = valorPago - valorConsumido;
            System.out.println("O troco foi: " + String.format("%.2f", troco) + "R$");
        }

        sc.close();
    }
}
