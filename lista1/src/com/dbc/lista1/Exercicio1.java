package com.dbc.lista1;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome:" );
        String name = sc.next();
        System.out.println("Digite sua idade:");
        int age = sc.nextInt();
        System.out.println("Digite sua cidade:");
        String city = sc.next();
        System.out.println("Digite seu estado:");
        String state = sc.next();

        System.out.print("Olá, seu nome é " + name + ", você tem " + age + " anos, é da cidade de " + city + ", situada no estado de " + state + ".");

        sc.close();
    }
}
