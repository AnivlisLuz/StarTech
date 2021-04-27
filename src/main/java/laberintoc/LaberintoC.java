/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and abierta the template in the editor.
 */
package laberintoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Carlos
 */
public class LaberintoC {

    //aux
    private static ArrayList<Punto> puntos = new ArrayList<>();
    private int aux1;
    private int aux2;
    private int[][] auxMat;
    //fin aux
    private int X, Y;
    private int matX, matY;
    private char[][] mat;
    private Casilla[][] casillas;
    private Random random = new Random();

    public LaberintoC(int tamano) {
        this(tamano, tamano);
    }

    public LaberintoC(int x, int y) {
        X = x;
        Y = y;
        matX = x * 4 + 1;
        matY = y * 2 + 1;
        //aux
        aux1 = x;
        aux2 = y;
        auxMat = new int[aux1][aux2];
        //fin aux
        mat = new char[matX][matY];
        init();
        generarLaberinto();
    }

    private void init() {
        casillas = new Casilla[X][Y];
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                casillas[x][y] = new Casilla(x, y, false);
            }
        }
    }

    private void generarLaberinto() {
        generarLaberinto(0, 0);
    }

    private void generarLaberinto(int x, int y) {
        generarLaberinto(getCasilla(x, y));
    }

    private void generarLaberinto(Casilla ini) {
        if (ini == null) {
            return;
        }
        ini.abierta = false;
        ArrayList<Casilla> casillas = new ArrayList<>();
        casillas.add(ini);

        while (!casillas.isEmpty()) {
            Casilla casilla;

            if (random.nextInt(10) == 0) {
                casilla = casillas.remove(random.nextInt(casillas.size()));
            } else {
                casilla = casillas.remove(casillas.size() - 1);
            }

            ArrayList<Casilla> vecinos = new ArrayList<>();

            Casilla[] posiblesVecinos = new Casilla[]{
                getCasilla(casilla.x + 1, casilla.y),
                getCasilla(casilla.x, casilla.y + 1),
                getCasilla(casilla.x - 1, casilla.y),
                getCasilla(casilla.x, casilla.y - 1)
            };

            for (Casilla aux : posiblesVecinos) {
                if (aux == null || aux.pared || !aux.abierta) {
                    continue;
                }
                vecinos.add(aux);
            }

            if (vecinos.isEmpty()) {
                continue;
            }

            Casilla seleccionada = vecinos.get(random.nextInt(vecinos.size()));
            seleccionada.abierta = false;
            casilla.addVecino(seleccionada);
            casillas.add(casilla);
            casillas.add(seleccionada);
        }
    }

    public Casilla getCasilla(int x, int y) {
        try {
            return casillas[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public void solve() {
        this.solve(0, 0, X - 1, Y - 1);
    }

    public void solve(int iniX, int iniY, int finX, int finY) {
        for (Casilla[] filaCasilla : this.casillas) {
            for (Casilla casilla : filaCasilla) {
                casilla.padre = null;
                casilla.visitado = false;
                casilla.enCamino = false;
                casilla.pisada = 0;
                casilla.distancia = -1;
            }
        }

        ArrayList<Casilla> casillasAbiertas = new ArrayList<>();
        Casilla casillaFin = getCasilla(finX, finY);

        if (casillaFin == null) {
            return;
        }
        {
            Casilla ini = getCasilla(iniX, iniY);
            if (ini == null) {
                return;
            }
            ini.distancia = getDistancia(ini, 0, casillaFin);
            ini.visitado = true;
            casillasAbiertas.add(ini);
        }
        boolean resolvifino = true;
        while (resolvifino) {
            if (casillasAbiertas.isEmpty()) {
                return;
            }
            Collections.sort(casillasAbiertas, new Comparator<Casilla>() {
                @Override
                public int compare(Casilla cas1, Casilla cas2) {
                    double diff = cas1.distancia - cas2.distancia;
                    if (diff > 0) {
                        return 1;
                    } else if (diff < 0) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            Casilla act = casillasAbiertas.remove(0);
            if (act == casillaFin) {
                break;
            }
            for (Casilla vecino : act.vecinos) {
                double projDist = getDistancia(vecino,
                        act.pisada + 1, casillaFin);
                if (!vecino.visitado || projDist < vecino.distancia) {
                    vecino.padre = act;
                    vecino.visitado = true;
                    vecino.distancia = projDist;
                    vecino.pisada = act.pisada + 1;

                    if (!casillasAbiertas.contains(vecino)) {
                        casillasAbiertas.add(vecino);
                    }
                }
            }
        }

        Casilla backtracking = casillaFin;
        backtracking.enCamino = true;
        while (backtracking.padre != null) {
            backtracking = backtracking.padre;
            backtracking.enCamino = true;
        }
    }

    public double getDistancia(Casilla act, double pisada, Casilla fin) {
        return pisada + Math.abs(act.x - fin.x) + Math.abs(act.y - act.x);
    }

    public void updateMat() {
        char blanco = ' ', pared = '#', casilla = ' ', camino = '*';
        for (int x = 0; x < matX; x++) {
            for (int y = 0; y < matY; y++) {
                mat[x][y] = blanco;
            }
        }

        for (int x = 0; x < matX; x++) {
            for (int y = 0; y < matY; y++) {
                if (x % 4 == 0 || y % 2 == 0) {
                    mat[x][y] = pared;
                }
            }
        }

        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                Casilla act = getCasilla(x, y);
                int matX = x * 4 + 2, matY = y * 2 + 1;

                if (act.enCamino) {
                    if (matX % 2 == 0 && matX % 4 != 0 && matY % 2 != 0) {
                        Punto punto = new Punto(1, true, matX, matY);
                        puntos.add(punto);
                    }

                    mat[matX][matY] = camino;

                    if (act.estaDebajo()) {
                        if (getCasilla(x, y + 1).enCamino) {
                            mat[matX][matY + 1] = camino;
                            mat[matX + 1][matY + 1] = blanco;
                            mat[matX - 1][matY + 1] = blanco;
                        } else {
                            mat[matX][matY + 1] = casilla;
                            mat[matX + 1][matY + 1] = blanco;
                            mat[matX - 1][matY + 1] = blanco;
                        }
                    }
                    if (act.estaDerecha()) {
                        if (getCasilla(x + 1, y).enCamino) {
                            mat[matX + 2][matY] = camino;
                            mat[matX + 1][matY] = camino;
                            mat[matX + 3][matY] = camino;
                        } else {
                            mat[matX + 2][matY] = casilla;
                            mat[matX + 1][matY] = casilla;
                            mat[matX + 3][matY] = casilla;
                        }
                    }
                } else {
                    mat[matX][matY] = casilla;
                    if (act.estaDebajo()) {
                        mat[matX][matY + 1] = casilla;
                        mat[matX + 1][matY + 1] = blanco;
                        mat[matX - 1][matY + 1] = blanco;
                    }
                    if (act.estaDerecha()) {
                        mat[matX + 2][matY] = casilla;
                        mat[matX + 1][matY] = casilla;
                        mat[matX + 3][matY] = casilla;
                    }
                }
            }
        }
    }

    public static int getRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int[][] generarMatriz(int tamano) {
        LaberintoC laberinto = new LaberintoC(tamano);
        laberinto.solve();
        laberinto.updateMat();

        int[][] matriz = new int[laberinto.mat.length][(laberinto.mat.length) - (tamano * 2)];
        for (int i = 0; i < laberinto.mat.length; i++) {
            for (int j = 0; j < laberinto.mat[i].length; j++) {
                if (laberinto.mat[i][j] == '*') {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }

        int[][] auxMat = new int[tamano][tamano];
        int p = 2;
        for (int col = 0; col < auxMat.length; col++) {
            int q = 1;
            for (int fil = 0; fil < auxMat[col].length; fil++) {
                if (matriz[p][q] == 1) {
                    auxMat[col][fil] = 1;
                } else {
                    auxMat[col][fil] = 0;
                }
                q = q + 2;
            }
            p = p + 4;
        }

        return auxMat;
    }

    public static int[][] generarCamino(int[][] mat, int condicion) {
        Punto[][] matriz = new Punto[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                matriz[i][j] = new Punto(mat[i][j], false, i, j);
            }
        }
        return generarCamino(0, 0, condicion, matriz);
    }

    public static int[][] generarCamino(int x, int y, int condicion, Punto mat[][]) {
        int[][] matAux = new int[mat.length][mat.length];
        if (x == mat.length - 1 && y == mat.length - 1) {
            //Se "limpia" la parte del camino que no se utilizó.
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    if (!mat[i][j].getVisitada()) {
                        mat[i][j].setValor(0);
                    }
                }
            }

            //Se crea una matriz de enteros con los valores de la matriz anterior.
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    matAux[i][j] = mat[i][j].getValor();
                }
            }

            //Se asegura que la primera casilla sea igual a 1
            matAux[0][0] = 1;
        } else {
            //Se verifica si la casilla de la derecha es válida
            if (esValido(mat, x, y + 1)) {
                mat[x][y + 1].setVisitada(true);
                mat[x][y + 1].setValor(condicion + 1);
                matAux = generarCamino(x, y + 1, condicion + 1, mat);
            } else {
                //Se verifica si la casilla de abajo es válida
                if (esValido(mat, x + 1, y)) {
                    mat[x + 1][y].setVisitada(true);
                    mat[x + 1][y].setValor(condicion + 1);
                    matAux = generarCamino(x + 1, y, condicion + 1, mat);
                } else {
                    //Se verifica si la casilla de la izquierda es válida
                    if (esValido(mat, x, y - 1)) {
                        mat[x][y - 1].setVisitada(true);
                        mat[x][y - 1].setValor(condicion + 1);
                        matAux = generarCamino(x, y - 1, condicion + 1, mat);
                    } else {
                        //Se verifica si la casilla de arriba es válida
                        if (esValido(mat, x - 1, y)) {
                            mat[x - 1][y].setVisitada(true);
                            mat[x - 1][y].setValor(condicion + 1);
                            matAux = generarCamino(x - 1, y, condicion + 1, mat);
                        }
                    }
                }
            }
        }
        return matAux;
    }

    public static int getMenor(ArrayList<Integer> arr) {
        int n = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (n > arr.get(i)) {
                n = arr.get(i);
            }
        }
        return n;
    }

    public static int getMayor(ArrayList<Integer> arr) {
        int n = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (n < arr.get(i)) {
                n = arr.get(i);
            }
        }
        return n;
    }

    public static boolean esIgualAVecino(int n, ArrayList<Integer> vecinos) {
        boolean es = false;
        for (int i = 0; i < vecinos.size(); i++) {
            if (n == vecinos.get(i));
            es = true;
            break;
        }
        return es;
    }

    public static boolean noEsPared(int[][] mat, int x, int y) {
        return !(x < 0 || x >= mat.length || y < 0 || y >= mat.length) && (mat[x][y] != 0);
    }

    public static int[][] generarParedes(int[][] mat) {
        int[][] matAux = mat;
        for (int i = 0; i < matAux.length; i++) {
            for (int j = 0; j < matAux.length; j++) {
                if (matAux[i][j] == 0) {
                    ArrayList<Integer> vecinos = new ArrayList<Integer>();

                    if (noEsPared(matAux, i - 1, j - 1)) {
                        vecinos.add(matAux[i - 1][j - 1]);
                    }
                    if (noEsPared(matAux, i, j - 1)) {
                        vecinos.add(matAux[i][j - 1]);
                    }
                    if (noEsPared(matAux, i + 1, j - 1)) {
                        vecinos.add(matAux[i + 1][j - 1]);
                    }
                    if (noEsPared(matAux, i - 1, j)) {
                        vecinos.add(matAux[i - 1][j]);
                    }
                    if (noEsPared(matAux, i + 1, j)) {
                        vecinos.add(matAux[i + 1][j]);
                    }
                    if (noEsPared(matAux, i - 1, j + 1)) {
                        vecinos.add(matAux[i - 1][j + 1]);
                    }
                    if (noEsPared(matAux, i, j + 1)) {
                        vecinos.add(matAux[i][j + 1]);
                    }
                    if (noEsPared(matAux, i + 1, j + 1)) {
                        vecinos.add(matAux[i + 1][j + 1]);
                    }
                    /*
                    int rand;
                    do
                    {
                        rand = getRandom(getMenor(vecinos), getMayor(vecinos) + 5);
                    }
                    while(!esIgualAVecino(rand, vecinos));
                     */
                    int rand = getRandom(getMayor(vecinos) + 1, getMayor(vecinos) + 5);

                    matAux[i][j] = rand;
                }
            }
        }
        return matAux;
    }

    public static int[][] genPar(int[][] mat, ArrayList<Punto> camino) {
        int[][] matAux = mat;
        for (int i = 0; i < matAux.length; i++) {
            for (int j = 0; j < matAux.length; j++) {
                if (matAux[i][j] == 0) {
                    int puntoMayor = getPuntoMayor(i, j, camino);
                    matAux[i][j] = getRandom(puntoMayor + 5, puntoMayor + 10);
                }
            }
        }
        return matAux;
    }

    public static int getPuntoMayor(int x, int y, ArrayList<Punto> camino) {
        ArrayList<Integer> puntos = new ArrayList<Integer>();
        for (int i = 0; i < camino.size(); i++) {
            if (x == camino.get(i).getPosX()) {
                puntos.add(camino.get(i).getValor());
            }

            if (y == camino.get(i).getPosY()) {
                puntos.add(camino.get(i).getValor());
            }
        }
        return getMayor(puntos);
    }

    public static boolean esValido(Punto[][] mat, int x, int y) {
        return !(x < 0 || x >= mat.length || y < 0 || y >= mat.length) && (mat[x][y].getValor() != 0 && !mat[x][y].getVisitada());
    }

    public static ArrayList<Punto> getCamino(int[][] mat) {
        ArrayList<Punto> camino = new ArrayList<Punto>();
        for (int i = 0; i<mat.length; i++)
                for (int j = 0; j<mat.length; j++)
                    if (mat[i][j] != 0)
                        camino.add(new Punto(mat[i][j], mat[i][j], i, j));
        camino = ordenar(camino);
        return camino;
    }

    // +++
    public static ArrayList<Punto> getCam(int[][] mat) {
        ArrayList<Punto> camino = new ArrayList<Punto>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != 0) {
                    camino.add(new Punto(mat[i][j], mat[i][j], i, j));
                }
            }
        }
        camino = ordenar(camino);
        return camino;
    }

    public static ArrayList<Punto> ordenar(ArrayList<Punto> arr) {
        ArrayList<Punto> aux = arr;
        for (int i = 0; i < aux.size() - 1; i++) {
            for (int j = 0; j < aux.size() - i - 1; j++) {
                if (aux.get(j).getValor() > aux.get(j + 1).getValor()) {
                    Collections.swap(aux, j, j + 1);
                }
            }
        }
        return aux;
    }

    public static ArrayList<Punto> generarCaminoMult(ArrayList<Punto> arr, int mult) {
        ArrayList<Punto> camino = new ArrayList<Punto>();
        for (int i = 0; i < arr.size(); i++) {
            int rand = 0;
            do {
                rand = getRandom(1, arr.size() + 10);
            } while (rand % mult != 0);
            //Se genera un Punto con (valor, orden, posX, posY).
            camino.add(new Punto(rand, i, arr.get(i).getPosX(), arr.get(i).getPosY()));
        }
        return camino;
    }

    public static int[][] generarMatrizMult(ArrayList<Punto> camino, int mult, int[][] mat) {
        int[][] matAux = mat;
        //Se crea una matriz con valores que no son múltiplos de mult.
        for (int i = 0; i < matAux.length; i++) {
            for (int j = 0; j < matAux.length; j++) {
                int rand;
                do {
                    rand = getRandom(1, camino.size() + 10);
                } while (rand % mult == 0);

                matAux[i][j] = rand;
            }
        }
        //Se sustituyen los valores correspondientes al camino.
        for (int i = 0; i < camino.size(); i++) {
            matAux[camino.get(i).getPosX()][camino.get(i).getPosY()] = camino.get(i).getValor();
        }

        return matAux;
    }

    public static ArrayList<Punto> generarCaminoSec(ArrayList<Punto> arr, int ini, int condicion) {
        ArrayList<Punto> camino = new ArrayList<Punto>();
        int aux = ini;
        for (int i = 0; i < arr.size(); i++) {
            camino.add(new Punto(aux, i, arr.get(i).getPosX(), arr.get(i).getPosY()));
            aux = aux + condicion;
        }
        return camino;
    }

    public static int[][] invertirMatriz(int[][] mat) {
        int[][] matInv = new int[mat.length][mat.length];
        int p = 0;
        for (int i = mat.length - 1; i >= 0; i--) {
            int q = 0;
            for (int j = mat.length - 1; j >= 0; j--) {
                matInv[p][q] = mat[i][j];
                q++;
            }
            p++;
        }
        return matInv;
    }

    public static ArrayList<Punto> invertirCamino(ArrayList<Punto> camino) {
        Collections.reverse(camino);
        return camino;
    }

    public static int[][] generarMatrizSec(ArrayList<Punto> camino, int[][] mat) {
        int[][] matAux = mat;
        for (int i = 0; i < matAux.length; i++) {
            for (int j = 0; j < matAux.length; j++) {
                if (matAux[i][j] == 0) {
                    int puntoMayor = getPuntoMayor(i, j, camino);
                    matAux[i][j] = getRandom(puntoMayor + 1, puntoMayor + 5);
                }
            }
        }

        for (int i = 0; i < camino.size(); i++) {
            matAux[camino.get(i).getPosX()][camino.get(i).getPosY()] = camino.get(i).getValor();
        }

        return matAux;
    }

    
    public static void main(String[] args)
    {
        /*
        int[][] arr = {
            {1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
            {1, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}
        };
        */
        int[][] mat = generarMatriz(10);
        dibujarMatriz(mat);
        System.out.println();
        
        int camino[][] = generarCamino(mat, 1);
        ArrayList<Punto> cam = getCamino(camino);
        ArrayList<Punto> orden = getCam(camino);
        ArrayList<Punto> orden2 = generarCaminoSec(orden, 1, 1);
        
        System.out.println();
        
        int[][] matSec = generarMatrizSec(orden2, camino);
        
        dibujarMatriz(matSec);
        
        System.out.println();
        
        dibujarMatriz(invertirMatriz(matSec));
        
        System.out.println();
        
        dibujarCamino(orden2);
        
        ArrayList<Punto> camMult = generarCaminoMult(orden, 3);
        
        int[][] matMult = generarMatrizMult(camMult, 3, mat);
        
        dibujarMatriz(matMult);
        /*
        dibujarOrden(orden);
        dibujarMatriz(camino);
        System.out.println();
        dibujarMatriz(genPar(camino, cam));*/
        
        /*
        Para crear una nueva matriz de secuencia (Secuencia o suma)
        
        int[][] matriz = generarMatriz(tamaño);
        int[][] matrizCamino = generarCamino(matriz, 1); siempre tiene que ser 1, es para generar el orden.
        ArrayList<Punto> orden = generarCaimnoSec(getCam(matrizCamino), (número inicial de la matriz), (condición, es decir número que se suma));
                            |
                            |---> Éste es el ArrayList con el orden de puntos para hacer la verificación.
        
        int[][] matrizSecuencia = generarMatrizSec(orden, matrizCamino); ---> Ésta es la matriz con los números para rellenar los botones.
        
        --------------- ***** --------------- ***** --------------- ***** ---------------
        
        Para crear una nueva matriz de resta
        
        *Todos los pasos anteriores
        int[][] matrizResta = invertirMatriz(matrizSeciencia); ---> Ésta es la matriz con los números para rellenar los botones.
        ArrayList<Punto> ordenResta = invertirCamino(orden); ---> Éste es el ArrayList con el orden de puntos para hacer la verificación.
        
        --------------- ***** --------------- ***** --------------- ***** ---------------
        
        Para crear una nueva matriz de Multiplicación o de División
        
        int[][] matriz = generarMatriz(tamaño);
        int[][] matrizCamino = generarCamino(matriz, 1);
        ArrayList<Punto> orden = generarCaminoMult(getCam(matrizCamino, (Condición, es decir los múltiplos que tendrá el camino));
                            |
                            |---> Éste es el ArrayList con el orden de puntos para hacer la verificación.
        
        int[][] matrizMultiplos = generarMatrizMult(orden, (condición), matriz); ---> Ésta es la matriz con los números para rellenar los botones.
        
        */
    }
    
    
    
    public static void dibujarCamino(ArrayList<Punto> arr)
    {
        for (int i = 0; i < arr.size(); i++)
        {
            System.out.println(arr.get(i).getValor());
        }
    }

    public static void dibujarOrden(ArrayList<Punto> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).getOrden());
        }
    }

    public static void dibujarMatriz(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dibujarMatriz(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "");
            }
            System.out.println();
        }
    }
}
