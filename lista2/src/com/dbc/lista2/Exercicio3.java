package com.dbc.lista2;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int jogadoresCadastrados = 0;
        double maiorAltura = 0;
        double mediaAlturas = 0;
        int maisVelho = 0;
        double maisPesado = 0;

        System.out.println("Digite o nome do jogador: ");
        String nomeJogador = sc.next();

        while(!nomeJogador.equalsIgnoreCase("sair")){
            System.out.println("Digite a altura do jogador: ");
            double altura = sc.nextDouble();
            mediaAlturas += altura;
            if(altura > maiorAltura){
                maiorAltura = altura;
            }

            System.out.println("Digite a idade do jogador: ");
            int idade = sc.nextInt();
            if(idade > maisVelho){
                maisVelho = idade;
            }

            System.out.println("Digite o peso do jogador: ");
            double peso = sc.nextDouble();
            if(peso > maisPesado){
                maisPesado = peso;
            }

            jogadoresCadastrados++;

            System.out.println("Digite o nome do jogador: ");
            nomeJogador = sc.next();
        }

        mediaAlturas /= jogadoresCadastrados;

        System.out.println("========================================================================");
        System.out.println("Quantidade de jogadores cadastrados: " + jogadoresCadastrados + "\n"
                        + "Altura do maior jogador: " + maiorAltura + "\n"
                        + "Jogador mais velho: " + maisVelho + " anos\n"
                        + "Jogador mais pesado: " + maisPesado + "kg\n"
                        + "Média da altura dos jogadores: " + String.format("%.2f", mediaAlturas) + "\n");

        sc.close();
    }
}
