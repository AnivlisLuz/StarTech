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
    
    private ArrayList<int[][]> matrices = new ArrayList<>();
    
    private String[][] matriz;
    private String[][] matrizRes;
    
    public Plantilla()
    {
        addMatrices();
        int rand = getRandom(1, 5);
        
        int[][] matAux1 = matrices.get(rand);
        int[][] matAux2 = quitarNumeros(matAux1, generarNumeros(matAux1));
        
        matrizRes = setOperaciones(matAux2, matAux1);
        matriz = ocultarNumeros(clonar(matrizRes), matAux1);
    }

    public String[][] getMatriz()
    {
        return matriz;
    }

    public String[][] getMatrizRes()
    {
        return matrizRes;
    }
    
    private int[][] generarNumeros(int [][] mat)
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
                        while(aux[i][j] == aux[getMenor(mat[i][j], mat)[0]][getMenor(mat[i][j], mat)[1]]);
                    else
                        aux[i][j] = getRandom(1, 15);
        return aux;
    }
    
    private void addMatrices()
    {
        int[][] mat1 = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {2, 0, 6, 7, 8, 9, 0, 0, 0, 0},
                        {3, 4, 5, 0, 0, 10, 0, 0, 0, 0},
                        {0, 0, 0, 0, 12, 11, 0, 19, 20, 21},
                        {0, 0, 0, 0, 13, 0, 0, 18, 0, 22},
                        {0, 0, 0, 0, 14, 15, 16, 17, 0, 23},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 24},
                        {0, 0, 0, 0, 0, 0, 0, 27, 26, 25},
                        {0, 0, 0, 0, 0, 0, 0, 28, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 29, 30, 31}};
        
        int[][] mat2 = {{1, 2, 3, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 4, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 5, 0, 0, 10, 11, 12, 0, 0},
                        {0, 0, 6, 7, 8, 9, 0, 13, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 14, 0, 0},
                        {0, 0, 0, 0, 0, 0, 16, 15, 0, 0},
                        {0, 0, 0, 0, 0, 0, 17, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 18, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 19, 20, 21, 22},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 23}};
        
        int[][] mat3 = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 4, 5, 6, 0, 14, 15, 16, 0, 0},
                        {0, 3, 0, 7, 0, 13, 0, 17, 0, 0},
                        {1, 2, 0, 8, 0, 12, 0, 18, 0, 0},
                        {0, 0, 0, 9, 10, 11, 0, 19, 20, 21},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        
        int[][] mat4 = {{0, 0, 0, 0, 16, 17, 18, 19, 20, 21},
                        {0, 0, 0, 0, 15, 0, 0, 0, 0, 0},
                        {0, 11, 12, 13, 14, 0, 0, 0, 0, 0},
                        {0, 10, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 9, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 6, 0, 0, 0, 0, 0, 0, 0},
                        {3, 4, 5, 0, 0, 0, 0, 0, 0, 0},
                        {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        
        int[][] mat5 = {{1, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 4, 5, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 6, 0, 0, 0, 0, 0, 0, 0},
                        {9, 8, 7, 0, 0, 0, 0, 0, 0, 0},
                        {10, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {11, 0, 17, 18, 19, 0, 0, 0, 0, 0},
                        {12, 0, 16, 0, 20, 0, 0, 0, 0, 0},
                        {13, 14, 15, 0, 21, 0, 26, 27, 28, 29},
                        {0, 0, 0, 0, 22, 23, 24, 25, 0, 0}};
        
        matrices.add(mat1);
        matrices.add(mat2);
        matrices.add(mat3);
        matrices.add(mat4);
        matrices.add(mat5);
    }
    
    private String[][] setOperaciones (int[][] mat, int[][] mat2)
    {
        String[][] aux = new String[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat.length; j++)
                if(mat[i][j] == -1)
                   aux[i][j] = getOperacion(mat[getMenor(mat2[i][j], mat2)[0]][getMenor(mat2[i][j], mat2)[1]], 
                                            mat[getMayor(mat2[i][j], mat2)[0]][getMayor(mat2[i][j], mat2)[1]]);
                else
                    if(mat[i][j] == 0)
                        aux[i][j] = "#";
                    else
                        aux[i][j] = "" + mat[i][j];
        return aux;
    }
    
    private String[][] ocultarNumeros (String[][] mat, int[][] mat2)
    {
        String[][] aux = mat;
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat.length; j++)
                if (mat2[i][j]%2 != 0 && mat2[i][j] != 1)
                    aux[i][j] = "@";
        return aux;
    }
    
    private int[][] quitarNumeros(int[][] mat1, int[][] mat2)
    {
        int[][] aux = mat2;
        for (int i = 0; i < mat1.length; i++)
            for (int j = 0; j < mat1.length; j++)
                if (mat1[i][j] == 0)
                    aux[i][j] = 0;
                else
                    if (mat1[i][j]%2 == 0)
                        aux[i][j] = -1;
        return aux;
    }
    
    private int getRandom(int min, int max) 
    {
        return (int) ((Math.random() * (max - min)) + min);
    }
    
    private int[] getMayor(int n, int[][] mat)
    {
        int[] xy = new int[2];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat.length; j++)
                if (mat[i][j] == n + 1)
                {
                    xy[0] = i;
                    xy[1] = j;
                }
        return xy;
    }
    
    private int[] getMenor(int n, int[][] mat)
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
    
    public String getOperacion(int n, int m)
    {
        String aux = "";
        if(n == m)
            aux = "*1";
        else
            if (n > m)
                if (n%m == 0)
                    aux = "÷" + getMultiplo(m, n); 
                else 
                    aux = "-" + (n-m);
            else
                if (m%n == 0)
                    aux = "*" + getMultiplo(n, m); 
                else 
                    aux = "+" + (m-n);
        return aux;
    }
    
    public int getMultiplo(int menor, int mayor)
    {
        int multiplo = 0;
        for (int i = 1; multiplo == 0; i++)
            if (((menor * i) % mayor) == 0)
                multiplo = i;
        return multiplo;
    }
    
    private String[][] clonar(String[][] mat)
    {
        String[][] aux = new String[mat.length][mat.length];
        for (int i = 0; i<mat.length; i++)
            for (int j = 0; j<mat.length; j++)
                aux[i][j] = mat[i][j];
        return aux;
    }
}
