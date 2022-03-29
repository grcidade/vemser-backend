package com.dbc.poo;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Ex6 {
    public static void main(String[] args){

        LocalDateTime horaAtual = LocalDateTime.now().atZone(ZoneId.of("UTC-03:00")).toLocalDateTime();
        LocalDateTime horarioShow = LocalDateTime.of(2024, 9, 14, 18, 30, 0).atZone(ZoneId.of("UTC+01:00")).toLocalDateTime();

        long diferencaAnos = ChronoUnit.YEARS.between(horaAtual, horarioShow);
        long diferencaMeses = ChronoUnit.MONTHS.between(horaAtual, horarioShow);
        long diferencaDias = ChronoUnit.DAYS.between(horaAtual, horarioShow);
        long diferencaHoras = ChronoUnit.HOURS.between(horaAtual, horarioShow);
        long diferencaMinutos = ChronoUnit.MINUTES.between(horaAtual, horarioShow);
        long diferencaSegundos = ChronoUnit.SECONDS.between(horaAtual, horarioShow);

        System.out.println("Faltam :"
        + "\nAnos: " + diferencaAnos
        + "\nMeses: " + diferencaMeses + " (" + Period.ofMonths((int) diferencaMeses).normalized().getYears() + " ANOS E " + Period.ofMonths((int) diferencaMeses).normalized().getMonths() + " MESES)"
        + "\nDias: " + diferencaDias
        + "\nHoras: " + diferencaHoras
        + "\nMinutos: " + diferencaMinutos
        + "\nSegundos: " + diferencaSegundos);

    }
}
