/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.crucigrama;

/**
 *
 * @author Carlos
 */
public class Main {
    public static void main(String[] args)
    {
        MatrizCrucigrama mat = new MatrizCrucigrama("division");
        char[][] matriz = mat.getMat();
        char[][] matrizRes = mat.getMatRes();
        
        mostrarMatriz(matriz);
        System.out.println();
        mostrarMatriz(matrizRes);
    }
    
    public static void mostrarMatriz(char[][] matriz)
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
