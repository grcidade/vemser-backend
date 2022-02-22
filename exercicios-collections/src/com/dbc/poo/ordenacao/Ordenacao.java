package com.dbc.poo.ordenacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ordenacao {
    public static void main(String[] args) {

        List<Pessoa> list = new ArrayList<>();

        list.add(new Pessoa("Jose", 12));
        list.add(new Pessoa("Carlos", 16));
        list.add(new Pessoa("Carlos", 17));
        list.add(new Pessoa("Joao", 11));
        list.add(new Pessoa("Jose", 20));
        System.out.println(list);

        list.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o2.getIdade() - o1.getIdade();
            }
        });

        System.out.println();
        System.out.println(list);

        list.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {

                int comparacaoUm = o1.getNome().compareTo(o2.getNome());

                if(comparacaoUm != 0){
                    return comparacaoUm;
                }
                return o1.getIdade() - o2.getIdade();
            }
        });

        System.out.println();
        System.out.println(list);


    }
}
