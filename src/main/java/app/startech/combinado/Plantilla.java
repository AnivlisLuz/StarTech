/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.combinado;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Plantilla {
    private Casilla[][] plantilla;
    
    private ArrayList<String> matrices = new ArrayList<>();
    
    private String[][] matriz;
    private String[][] matrizRes;
    
    public static int[][] generarNumeros(int [][] mat)
    {
        int[][] aux = new int[mat.length][mat.length];
        for (int i = 0; i < aux.length; i++)
            for (int j = 0; j < aux.length; j++)
                if (mat[i][j] == 0)
                    aux[i][j] = 0;
                else
                    if (mat[i][j] != 1)
                        do
                            aux[i][j] = getRandom(1, 15);
                        while(aux[i][j] == aux[getMenor(aux[i][j], mat)[0]][getMenor(aux[i][j], mat)[1]]);
                    else
                        aux[i][j] = getRandom(1, 15);
        return aux;
    }
    
    public void addMatrices()
    {
        int[][] aux =  {{1, 2, 0, 0, 0},
                        {0, 3, 4, 0, 0},
                        {0, 0, 5, 6, 0},
                        {0, 0, 0, 7, 8},
                        {0, 0, 0, 0, 9}};
    }
    
    public static int getRandom(int min, int max) 
    {
        return (int) ((Math.random() * (max - min)) + min);
    }
    
    public static int[] getMenor(int n, int[][] mat)
    {
        int[] xy = new int[2];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat.length; j++)
                if (mat[i][j] == n - 1)
                {
                    xy[0] = i;
                    xy[1] = j;
                }
        return xy;
    }
    
    public static void main(String[] args)
    {
        int[][] aux =  {{1, 2, 0, 0, 0},
                        {0, 3, 4, 0, 0},
                        {0, 0, 5, 6, 0},
                        {0, 0, 0, 7, 8},
                        {0, 0, 0, 0, 9}};
        
        mostrarMatriz(generarNumeros(aux));
    }
    
    public static void mostrarMatriz(int[][] matriz)
    {
        for (int i = 0; i<matriz.length; i++)
        {
            for (int j = 0; j<matriz[i].length; j++)
            {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
