package com.dbc.lista2;

import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] mat = new int[4][4];
        int eMaiorQueDez = 0;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length; j++){
                System.out.println("Digite o valor da linha " + (i + 1) + " e coluna " + (j + 1));
                mat[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length; j++){
                if(mat[i][j] >= 10){
                 eMaiorQueDez++;
                 System.out.println("Valor maior que dez: " + mat[i][j] + " no index [" + i + "," + j + "] da matriz");
                }
            }
        }

        if(eMaiorQueDez == 1){
            System.out.println("Ao todo é " + eMaiorQueDez + " valor que dez");
        } else{
            System.out.println("Ao todo são " + eMaiorQueDez + " maiores que dez");
        }

        sc.close();
    }
}
