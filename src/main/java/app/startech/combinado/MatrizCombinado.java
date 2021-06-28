/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.combinado;

/**
 *
 * @author Carlos
 */
public class MatrizCombinado {
    private String[][] matriz;
    private String[][] matrizRes;
    
    public MatrizCombinado()
    {
        Plantilla plantilla = new Plantilla();
        
        matriz = plantilla.getMatriz();
        mostrarMatrizString(matriz);
        matrizRes = plantilla.getMatrizRes();
        mostrarMatrizString(matrizRes);
    }

    public String[][] getMatriz()
    {
        return matriz;
    }

    public String[][] getMatrizRes()
    {
        return matrizRes;
    }
    
    public static void main(String[] args)
    {
        MatrizCombinado combinado = new MatrizCombinado();
        
        mostrarMatrizString(combinado.matriz);
        mostrarMatrizString(combinado.matrizRes);
    }
    
    private static void mostrarMatrizString(String[][] matriz)
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
