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
public class Combinado {
    private String[][] matriz;
    private String[][] matrizRes;
    
    public Combinado()
    {
        Plantilla plantilla = new Plantilla();
        
        matriz = plantilla.getMatriz();
        matrizRes = plantilla.getMatrizRes();
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
        Combinado combinado = new Combinado();
        
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
