package com.dbc.lista2;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] mat = new int[5][4];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                System.out.println("Digite o valor da linha " + (i + 1) + " e coluna " + (j + 1));
                mat[i][j] = sc.nextInt();
            }
        }

        double nfAlunoUm = (mat[0][1] * 0.6) + (mat[0][2] * 0.4);
        double nfAlunoDois = (mat[1][1] * 0.6) + (mat[1][2] * 0.4);
        double nfAlunoTres = (mat[2][1] * 0.6) + (mat[2][2] * 0.4);
        double nfAlunoQuatro = (mat[3][1] * 0.6) + (mat[3][2] * 0.4);
        double nfAlunoCinco = (mat[4][1] * 0.6) + (mat[4][2] * 0.4);

        System.out.println("=====================================================");
        if(nfAlunoUm > nfAlunoDois && nfAlunoUm > nfAlunoTres && nfAlunoUm > nfAlunoQuatro && nfAlunoUm > nfAlunoCinco){
            System.out.println("A matricula com a maior nota foi a: " +  mat[0][0]);
        } else if(nfAlunoDois > nfAlunoUm && nfAlunoDois > nfAlunoTres && nfAlunoDois > nfAlunoQuatro && nfAlunoDois > nfAlunoCinco){
            System.out.println("A matricula com a maior nota foi a: " +  mat[1][0]);
        } else if(nfAlunoTres > nfAlunoUm && nfAlunoTres > nfAlunoDois && nfAlunoTres > nfAlunoQuatro && nfAlunoTres > nfAlunoCinco){
            System.out.println("A matricula com a maior nota foi a: " +  mat[2][0]);
        } else if(nfAlunoQuatro > nfAlunoUm && nfAlunoQuatro > nfAlunoDois && nfAlunoQuatro > nfAlunoTres && nfAlunoQuatro > nfAlunoCinco){
            System.out.println("A matricula com a maior nota foi a: " +  mat[3][0]);
        } else if(nfAlunoCinco > nfAlunoUm && nfAlunoCinco > nfAlunoDois && nfAlunoCinco > nfAlunoTres && nfAlunoCinco > nfAlunoQuatro){
            System.out.println("A matricula com a maior nota foi a: " +  mat[4][0]);
        }

        double mediaNotaFinal = (mat[0][3] + mat[1][3] + mat[2][3] + mat[3][3] + mat[4][3]);
        mediaNotaFinal /= 5;

        System.out.println();
        System.out.println("A média de notas finais foi: " + String.format("%.2f", mediaNotaFinal));

        printMat(mat);

        sc.close();
    }

    static void printMat(int[][] matriz){
        int sizeH = matriz.length;
        int sizeV = matriz[0].length;
        for(int i = 0; i < sizeH; i++){
            System.out.print("| ");
            for(int j = 0; j < sizeV; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
    }
}
