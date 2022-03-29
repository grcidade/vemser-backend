package com.dbc.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args){

        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime horarioBrasil = LocalTime.parse(LocalTime.now(ZoneId.of("UTC-03:00")).format(format));
        LocalTime horarioAustralia = LocalTime.parse(LocalTime.now(ZoneId.of("UTC+10:00")).format(format));
        LocalTime horarioJapao = LocalTime.parse(LocalTime.now(ZoneId.of("UTC+09:00")).format(format));
        LocalTime horarioRussia = LocalTime.parse(LocalTime.now(ZoneId.of("UTC+03:00")).format(format));
        LocalTime horarioDubai= LocalTime.parse(LocalTime.now(ZoneId.of("UTC+04:00")).format(format));
        LocalTime horarioEUA = LocalTime.parse(LocalTime.now(ZoneId.of("UTC-07:00")).format(format));

        System.out.println("Horário Brasil - " + horarioBrasil + "\n"
        + "Horário Australia - " + horarioAustralia + "\n"
        + "Horário Japão -  " + horarioJapao + "\n"
        + "Horário Russia - " + horarioRussia + "\n"
        + "Horário Dubai - " + horarioDubai + "\n"
        + "Horário EUA - " + horarioEUA);


    }
}
