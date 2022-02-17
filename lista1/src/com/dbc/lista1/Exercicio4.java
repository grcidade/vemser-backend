package com.dbc.lista1;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite qual estado deseja: (1 - RS / 2 - SC / 3 - MG)");
        int estado = sc.nextInt();

        switch (estado){
            case 1:
                System.out.println("Escolha a cidade: (1 - Cachoeirinha / 2 - Canoas)");
                int cidadeRS = sc.nextInt();
                switch (cidadeRS){
                    case 1:
                        System.out.println("Habitantes: 130.112\n"
                                + "Densidade Populacional: 2.959,9 ha./km²\n"
                                + "Área territorial: 44.018 km²");
                    break;
                    case 2:
                        System.out.println("Habitantes: 346.616\n"
                                + "Densidade Populacional: 2.643,9 ha./km²\n"
                                + "Área territorial: 131.097 km²");
                    break;
                }
            break;
            case 2:
                System.out.println("Escolha a cidade: (1 - Sombrio / 2 - Florianópolis)");
                int cidadeSC = sc.nextInt();
                switch (cidadeSC){
                    case 1:
                        System.out.println("Habitantes: 30.374\n"
                                + "Densidade Populacional: 212,8 ha./km²\n"
                                + "Área territorial: 142.745 km²");
                    break;
                    case 2:
                        System.out.println("Habitantes: 500.973\n"
                                + "Densidade Populacional: 746,0 ha./km²\n"
                                + "Área territorial: 675,400 km²");
                    break;
                }
            break;
            case 3:
                System.out.println("Escolha a cidade: (1 - Uberlândia / 2 - Belo Horizonte)");
                int cidadeMG = sc.nextInt();
                switch (cidadeMG){
                    case 1:
                        System.out.println("Habitantes: 691.305\n"
                                + "Densidade Populacional: 168,0 ha./km²\n"
                                + "Área territorial: 4.115 km²");
                    break;
                    case 2:
                        System.out.println("Habitantes: 2.530.701\n"
                                + "Densidade Populacional: 7.580,2 ha./km²\n"
                                + "Área territorial: 330,9 km²");
                    break;
                }
            break;
        }

        sc.close();
    }
}
