package com.dbc.poo;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    public static void main(String[] args) {

        Queue<String> fila = new LinkedList<>();

        System.out.println("5 pessoas na fila: ");
        fila.add("Senha 1");
        fila.add("Senha 2");
        fila.add("Senha 3");
        fila.add("Senha 4");
        fila.add("Senha 5");
        System.out.println(fila);
        System.out.println();

        System.out.println("Duas pessoas atendidas");
        System.out.println(fila.poll());
        System.out.println(fila.poll());
        System.out.println(fila);
        System.out.println();

        System.out.println("Mais uma pessoa atendida");
        System.out.println(fila.poll());
        System.out.println(fila);

        System.out.println("mais 3 pessoas na fila: ");
        fila.add("Nova Senha 1");
        fila.add("Nova Senha 2");
        fila.add("Nova Senha 3");
        System.out.println(fila);
        System.out.println();

        System.out.println("Tres pessoas atendidas");
        System.out.println(fila.poll());
        System.out.println(fila.poll());
        System.out.println(fila.poll());
        System.out.println(fila);

        System.out.println();
        System.out.println("Restante da lista");
        System.out.println(fila);

    }
}
