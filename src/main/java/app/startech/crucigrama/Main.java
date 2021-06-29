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
        MatrizCrucigrama mat = new MatrizCrucigrama("combinados");
        char[][] matriz = mat.getMat();
        char[][] matrizRes = mat.getMatRes();
        
        mostrarMatriz(dibujar(matriz));
        System.out.println();
        mostrarMatriz(dibujar(matrizRes));
    }
    
    public static char[][] dibujar(char[][] matriz)
    {
        char[][] aux = new char[13][13];
        for (int i = 0; i < 13; i++)
            for (int j = 0; j < 13; j++)
                if (matriz[i][j] == '#')
                    aux[i][j] = ' ';
                else
                    if (matriz[i][j] == '@')
                        aux[i][j] = '%';
                    else
                        aux[i][j] = matriz[i][j];
        return aux;
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
