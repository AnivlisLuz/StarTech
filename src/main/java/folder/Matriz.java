package folder;

import java.util.ArrayList;
import laberintoc.LaberintoC;
import laberintoc.Punto;

public abstract class Matriz {

    protected int tamaño;
    protected int[][] matriz;
    protected int[][] laberinto;
    private Punto inicio;
    private Punto meta;
    protected ArrayList<Punto> camino;
    //private Punto[] camino;
    protected LaberintoC lab;
    private int pos;

    public Matriz(int tamaño) {
        this.tamaño = tamaño;
        lab = new LaberintoC(tamaño);
        matriz = new int[tamaño][tamaño];
        laberinto = new int[tamaño][tamaño];
        inicio = null;
        meta = new Punto(tamaño - 1, tamaño - 1);
        //camino = new Punto[]{new Punto(0,0), new Punto(0, 1), new Punto(0, 2), new Punto(1, 0), new Punto(1, 2), new Punto(2, 0), new Punto(2, 2)};
        camino = new ArrayList<Punto>();
        pos = 0;
    }

//    public void setCamino(){
//        camino = lab.getCamino();
//    }
    public Punto getMeta() {
        return meta;
    }

    public boolean verificarMovimiento(Punto p) {
        Punto a = camino.get(pos);
        //Punto a = camino[pos];
        boolean res = false;
        if (p.igual(a)) {
            res = true;
            pos++;
        } else {
            res = false;
        }
        return res;
    }

    abstract public void rellenarLaberinto();
    
    public int[][] getMatriz()
    {
        matriz = lab.generarMatriz(tamaño);
        int[][] matAux = lab.generarCamino(matriz,1);
        camino = lab.getCamino(matAux);
        return matriz;
    }

    public void generarLaberinto() {
        matriz = lab.generarMatriz(tamaño);
        int[][] matAux = lab.generarCamino(matriz,1);
        camino = lab.getCamino(matAux);
    }

    public int[][] getLaberinto() {
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

    public ArrayList<Punto> getCamino() {
        return camino;
    }
    // public Punto[] getCamino(){
    //     return camino;
    // }

    public void reset() {
        pos = 0;
    }
}
