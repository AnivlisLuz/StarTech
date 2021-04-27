
package folder;

import java.util.ArrayList;
//import static laberintoc.LaberintoC.getCamino;
//import laberintoc.Punto;

public class Secuencia extends Matriz {
    
    
    public Secuencia(int tamaño){
        super(tamaño);
        rellenarLaberinto();
    }
    
    public void rellenarLaberinto(){
        //laberinto = lab.generarCamino(matriz, 1);
//        
//        int[][] matriz = lab.generarMatriz(tamaño);
//        int[][] matrizCamino = lab.generarCamino(matriz, 1);
//        ArrayList<Punto> orden = lab.generarCaminoSec(lab.getCamino(matrizCamino), 1, 1);
//        
//        
//        laberinto = lab.generarMatrizSec(orden, matrizCamino);
        laberinto = lab.rellenarJ(matriz, 1);
    }
    

}
