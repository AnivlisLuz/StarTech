/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.combinado;
import app.startech.matriz.LaberintoC;
import app.startech.matriz.Punto;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class MatrizCombinado {
    private int tamano;
    private Casilla[][] matriz;
    
    public MatrizCombinado(int tamano)
    {
        this.tamano = tamano;
    }
    
    private void setMatriz()
    {
        int aux[][];
        int aux2[][];
        LaberintoC camino = new LaberintoC(tamano);
        aux = camino.generarMatriz(tamano);
        aux2 = camino.generarCamino(aux, 1);
    }
}
