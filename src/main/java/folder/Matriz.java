
package folder;

import java.util.ArrayList;
import laberintoc.LaberintoC;

public abstract class Matriz {
    private int tamaño;
    private int[][] matriz;
    protected int[][] laberinto;
    private Punto   inicio;
    private Punto   meta;
    //private ArrayList<Punto> camino;
    private Punto[] camino;
    private LaberintoC lab;
    private int pos;
    
    public Matriz(int tamaño){
        this.tamaño = tamaño;
        lab = new LaberintoC(tamaño);
        matriz = new int[tamaño][tamaño];
        laberinto = new int[tamaño][tamaño];
        inicio = null; meta = new Punto(2, 2);
        camino = new Punto[]{new Punto(0,0), new Punto(0, 1), new Punto(0, 2), new Punto(1, 0), new Punto(1, 2), new Punto(2, 0), new Punto(2, 2)};
        //camino = new ArrayList<Punto>();
        pos = 0;
    }
    
//    public void setCamino(){
//        camino = lab.getCamino();
//    }
    
    public Punto getMeta(){
        return meta;
    }
    
    public boolean verificarMovimiento(Punto p){
        //Punto a = camino.get(pos);
        Punto a = camino[pos];
        boolean res = false;
        if(p.igual(a)){
            res = true;
            pos++;
        }else{
            res = false;
        }
        return res;
    }
    abstract public void rellenarLaberinto();
    
    public void generarLaberinto(){
        matriz = lab.generarMatriz(tamaño);
    }
    public int[][] getLaberinto(){
//        int[][] laberinto = {
//            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
//            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
//            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
//            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
//            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
//            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
//            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
//            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
//            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0}
//        };
        return matriz;
    }
    public Punto[] getCamino(){
        return camino;
    }
    public void reset(){
        pos = 0;
    }
}
