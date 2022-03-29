package com.dbc.poo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Infome sua data de nascimento: ");
        LocalDate dataAniversario = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataAtual = LocalDate.now();

        if(dataAniversario.withYear(dataAtual.getYear()).isAfter(dataAtual)){
            Period period = Period.between(dataAtual, dataAniversario.withYear(dataAtual.getYear()));
            System.out.println("Faltam " + period.getDays() + " dias e " + period.getMonths() + " meses para seu próximo aniversario!");
        } else {
            Period period = Period.between(dataAtual, dataAniversario.withYear(dataAtual.getYear() + 1));
            System.out.println("Faltam " + period.getDays() + " dias e " + period.getMonths() + " meses para seu próximo aniversario!");
        }
    }

}

