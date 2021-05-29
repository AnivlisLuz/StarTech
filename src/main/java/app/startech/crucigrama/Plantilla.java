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
public class Plantilla {
    private char[][] matriz;
   
    public Plantilla(char[][] matriz)
    {
        this.matriz = matriz;
    }
    
    public Casilla[][] getPlantilla()
    {
        Casilla[][] plantilla = new Casilla[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz.length; j++)
            {
                plantilla[i][j] = new Casilla(i,j,matriz[i][j]);
            }
        }
        return plantilla;
    }
}
