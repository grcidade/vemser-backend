package com.dbc.lista1;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Valor da hora em reais:");
        double horaReais = sc.nextDouble();
        System.out.println("Horas normais trabalhadas:");
        double horaNormalTrabalhada = sc.nextDouble();
        System.out.println("Horas extras 50%:");
        double horaExtraCinquenta = sc.nextDouble();
        System.out.println("Horas extras 100%:");
        double horaExtraCem = sc.nextDouble();

        double salarioBruto = ((horaNormalTrabalhada * horaReais) + (horaExtraCinquenta * horaReais * 1.5) + (horaExtraCem * horaReais * 2));
        System.out.println("Salario bruto: " + String.format("%.2f", salarioBruto ));

        sc.close();
    }
}
