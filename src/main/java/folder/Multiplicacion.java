/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import java.util.ArrayList;
import laberintoc.Punto;

/**
 *
 * @author Criss
 */
public class Multiplicacion extends Matriz{
    
    private int condicion;
    
    public Multiplicacion(int tamaño, int condicion){
        super(tamaño);
        this.condicion = condicion;
        rellenarLaberinto();
    }
    
    public void rellenarLaberinto(){
        //laberinto = lab.generarCamino(matriz, condicion);  
//        
//        int[][] matriz = lab.generarMatriz(tamaño);
//        int[][] matrizCamino = lab.generarCamino(matriz, 1);
//        ArrayList<Punto> orden = lab.generarCaminoMult(lab.getCam(matrizCamino), condicion);
//        laberinto = lab.generarMatrizMult(orden, (condicion), matriz);

        laberinto = lab.rellenarJ3(matriz, condicion);
    }
}
