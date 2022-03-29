package com.dbc.poo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args){

        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataMaisQuinzeDiasEDezHoras = dataAtual.plusDays(15).plusHours(10);
        Period periodo = Period.between(dataAtual.toLocalDate(), dataMaisQuinzeDiasEDezHoras.toLocalDate());

        System.out.println("Dia da semana: " + dataMaisQuinzeDiasEDezHoras.getDayOfWeek() + "\n" +
                "Dia do ano (corrido): " + dataMaisQuinzeDiasEDezHoras.getDayOfYear());


    }
}
