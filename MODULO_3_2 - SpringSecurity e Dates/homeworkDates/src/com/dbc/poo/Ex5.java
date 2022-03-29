package com.dbc.poo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Ex5 {
    public static void main(String[] args){

        LocalDateTime dataAtual = LocalDateTime.of(2022, 3, 23, 21, 30, 0);

        System.out.println("Formato Brasil: " + dataAtual.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("pt-BR"))));
        System.out.println("Formato EUA: " + dataAtual.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.US)));
        System.out.println("Formato França: " + dataAtual.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.FRANCE)));

    }
}
