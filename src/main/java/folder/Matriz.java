
package folder;

import java.util.ArrayList;
import laberintoc.LaberintoC;

public abstract class Matriz {
    private int tamaño;
    protected int[][] matriz;
    protected int[][] laberinto;
    private Punto   inicio;
    private Punto   meta;
    private ArrayList<Punto> camino;
    //private Punto[] camino;
    protected LaberintoC lab;
    private int pos;
    
    public Matriz(int tamaño){
        this.tamaño = tamaño;
        lab = new LaberintoC(tamaño);
        matriz = new int[tamaño][tamaño];
        laberinto = new int[tamaño][tamaño];
        inicio = null; meta = null;
        //camino = new Punto[]{new Punto(0,0), new Punto(0, 1), new Punto(0, 2), new Punto(1, 0), new Punto(1, 2), new Punto(2, 0), new Punto(2, 2)};
        camino = new ArrayList<Punto>();
        pos = 0;
    }
    
//    public void setCamino(){
//        camino = lab.getCamino();
//    }
    
    public Punto getMeta(){
        meta = camino.get(camino.size()-1);
        return meta;
    }
    
    public boolean verificarMovimiento(Punto p){
        Punto a = camino.get(pos);
        //Punto a = camino[pos];
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
       ArrayList<laberintoc.Punto> a = LaberintoC.getCamino(matriz);
       for(laberintoc.Punto aux : a){
           int x = aux.getPosX();
           int y = aux.getPosY();
           Punto n = new Punto(x, y);
           camino.add(n);
       }
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
        return laberinto;
    }
    public ArrayList<Punto> getCamino(){
        return camino;
    }
    /*public Punto[] getCamino(){
        return camino;
    }*/
    public void reset(){
        pos = 0;
    }
}
