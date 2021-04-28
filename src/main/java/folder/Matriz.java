package folder;

import java.util.ArrayList;
import laberintoc.LaberintoC;
import laberintoc.Punto;

public abstract class Matriz {

    public int tamaño;
    protected int[][] matriz;//matriz de ceros y unos
    protected int[][] laberinto;//laberinto relleno de números 
    private Punto meta;
    private ArrayList<Punto> camino;//camino del laberinto
    protected LaberintoC lab;
    private int pos;

    public Matriz(int tamaño) {
        this.tamaño = tamaño;
        lab = new LaberintoC(tamaño);
        matriz = new int[tamaño][tamaño];
        laberinto = new int[tamaño][tamaño];
        meta = new Punto(tamaño - 1, tamaño - 1);
        camino = new ArrayList<Punto>();
        pos = 0;
    }

    //Punto final en el camino correcto del laberinto
    public Punto getMeta() {
        return meta;
    }

    //Método para verificar el avance del usuario en el laberinto
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

    //Método abstracto para rellenar el laberinto segun la categoria
    abstract public void rellenarLaberinto();

    //genera la matriz de ceros y unos, y el camino 
    public void generarLaberinto() {
        matriz = lab.generarMatriz(tamaño);
        int[][] matAux = lab.generarCamino(matriz, 1);
        camino = lab.getCamino(matAux);
    }

    //retorna el laberinto
    public int[][] getLaberinto() {
        return laberinto;
    }

    //pone en cero la posicion. para la verificacion segun el camino
    public void reset() {
        pos = 0;
    }
}
