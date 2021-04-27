
package folder;

import java.util.ArrayList;
import laberintoc.LaberintoC;
import static laberintoc.LaberintoC.generarMatrizSec;
import static laberintoc.LaberintoC.getCam;
import laberintoc.Punto;

public class Secuencia extends Matriz {
    
    public ArrayList<Punto> orden;
    public Secuencia(int tamaño){
        super(tamaño);
        rellenarLaberinto();
    }
    
    public void rellenarLaberinto(){
        //laberinto = lab.generarCamino(matriz, 1);
        
        /*
        int[][] matriz = lab.generarMatriz(tamaño);
        int[][] matrizCamino = lab.generarCamino(matriz, 1);
        
        ArrayList<Punto> ord = lab.generarCaminoSec(lab.getCam(matrizCamino), 1, 1);
        //laberinto = lab.generarMatrizSec(camino, matrizCamino);
        laberinto = lab.generarMatrizSec(orden, matrizCamino);
       */
        matriz = getMatriz();
        int[][] matrizCamino = lab.generarCamino(matriz, 1);
        ArrayList<Punto> orden = lab.generarCaminoSec(lab.getCamino(matrizCamino), 1, 1);
        
        
        laberinto = lab.generarMatrizSec(orden, matrizCamino);

    }
    

}
