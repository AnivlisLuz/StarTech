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

    //Declaración de atributos de la clase.
    private static ArrayList<Punto> puntos = new ArrayList<>();
    private ArrayList<Punto> camJ;
    private int X, Y;
    private int matX, matY;
    private char[][] mat;
    private Casilla[][] casillas;
    private Random random = new Random();

    //Constructor únicamente con el parámetro de tamaño.
    public LaberintoC(int tamano) {
        this(tamano, tamano);
    }

    //Constructor con coordenadas x e y, que en este contexto sería el tamaño.
    public LaberintoC(int x, int y) {
        X = x;
        Y = y;
        matX = x * 4 + 1;
        matY = y * 2 + 1;
        mat = new char[matX][matY];
        camJ = new ArrayList<>();
        init();
        generarLaberinto();
    }

    //Método para inicializar el laberinto y para generar una matriz de casillas que no son pared del laberinto.
    private void init() {
        casillas = new Casilla[X][Y];
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                casillas[x][y] = new Casilla(x, y, false);
            }
        }
    }

    //Parte del método para generar laberinto, este llama al método del mismo nombre pero con la coordenada inicial de (0,0)
    private void generarLaberinto() {
        generarLaberinto(0, 0);
    }
    
    //Segunda parte del método para generar la matriz de casillas, esta mandará la casilla inical que sea ingresada.
    private void generarLaberinto(int x, int y) {
        generarLaberinto(getCasilla(x, y));
    }

    //Éste método rellena la matriz a partir de una casilla inicial.
    private void generarLaberinto(Casilla ini) {
        //Si la casilla inical ingresada no tiene ningún valor el método para.
        if (ini == null) {
            return;
        }
        //Se declara el parámetro de casilla abierta o disponible como false.
        ini.abierta = false;
        ArrayList<Casilla> casillas = new ArrayList<>();
        casillas.add(ini);

        //Ciclo que se repite hasta que el arreglo de casilla esté vacío.
        while (!casillas.isEmpty()) {
            Casilla casilla;

            //Se genera un número al azar
            if (random.nextInt(10) == 0) {
                //Se elimina una posición aleatoria del arreglo.
                casilla = casillas.remove(random.nextInt(casillas.size()));
            } else {
                //Se elimina una posición aleatoria del arreglo.
                casilla = casillas.remove(casillas.size() - 1);
            }

            ArrayList<Casilla> vecinos = new ArrayList<>();

            //Se genera un arreglo con posibles vecinos.
            Casilla[] posiblesVecinos = new Casilla[]{
                getCasilla(casilla.x + 1, casilla.y),
                getCasilla(casilla.x, casilla.y + 1),
                getCasilla(casilla.x - 1, casilla.y),
                getCasilla(casilla.x, casilla.y - 1)
            };

            //Se le añaden vecinos al arreglo.
            for (Casilla aux : posiblesVecinos) {
                if (aux == null || aux.pared || !aux.abierta) {
                    continue;
                }
                vecinos.add(aux);
            }

            if (vecinos.isEmpty()) {
                continue;
            }

            //Se añade una casilla al azar al arreglo de vecinos.
            Casilla seleccionada = vecinos.get(random.nextInt(vecinos.size()));
            seleccionada.abierta = false;
            casilla.addVecino(seleccionada);
            casillas.add(casilla);
            casillas.add(seleccionada);
        }
    }

    //Método para devolver una casilla.
    public Casilla getCasilla(int x, int y) {
        try {
            return casillas[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    //Método que "Resuelve el laberinto" (Sirve para generar el camino de la matriz).
    public void solve() {
        this.solve(0, 0, X - 1, Y - 1);
    }

    public void solve(int iniX, int iniY, int finX, int finY) {
        //Se genera un arreglo de nuevas casillas.
        for (Casilla[] filaCasilla : this.casillas) {
            for (Casilla casilla : filaCasilla) {
                casilla.padre = null;
                casilla.visitado = false;
                casilla.enCamino = false;
                casilla.pisada = 0;
                casilla.distancia = -1;
            }
        }

        //Se genera un nuevo arreglo de las casillas disponibles o abiertas.
        ArrayList<Casilla> casillasAbiertas = new ArrayList<>();
        //Se declara una nueva casilla final.
        Casilla casillaFin = getCasilla(finX, finY);

        //Se obtiene la distancia entre la casilla inicial y la final y se declara las casillas como visitadas.
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
        
        //Comprobación para saber si se está resolviendo.
        boolean resolviendo = true;
        while (resolviendo) {
            if (casillasAbiertas.isEmpty()) {
                return;
            }
            //Sobreescritura del método compare para comparar la distancia de dos casillas.
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
            
            //Se remueve la casilla actual de las casillas disponibles.
            Casilla act = casillasAbiertas.remove(0);
            
            //Si la casilla actual es igual a la casilla final el método termina.
            if (act == casillaFin) {
                break;
            }
            
            //Se declaran los atributos de pisada y visitada de las casillas.
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

        //Si la casilla "backtracking" forma parte del camino, se declara como la casilla padre.
        Casilla backtracking = casillaFin;
        backtracking.enCamino = true;
        while (backtracking.padre != null) {
            backtracking = backtracking.padre;
            backtracking.enCamino = true;
        }
    }

    //Método para obtener la distancia de dos casillas.
    public double getDistancia(Casilla act, double pisada, Casilla fin) {
        return pisada + Math.abs(act.x - fin.x) + Math.abs(act.y - act.x);
    }

    //Convierte la matriz de Casillas en una matriz gráfica de caracteres.
    public void updateMat() {
        char blanco = ' ', pared = '#', casilla = ' ', camino = '*';
        //Se declara toda la matriz en blanco.
        for (int x = 0; x < matX; x++) {
            for (int y = 0; y < matY; y++) {
                mat[x][y] = blanco;
            }
        }

        //Si la posición es múltiplo de 4 y de 2, se declara como pared.
        for (int x = 0; x < matX; x++) {
            for (int y = 0; y < matY; y++) {
                if (x % 4 == 0 || y % 2 == 0) {
                    mat[x][y] = pared;
                }
            }
        }

        //Se hace un recorrido iterativo de la matriz.
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                Casilla act = getCasilla(x, y);
                int matX = x * 4 + 2, matY = y * 2 + 1;

                //Si la posición actual está en medio del camino:
                if (act.enCamino) {
                    if (matX % 2 == 0 && matX % 4 != 0 && matY % 2 != 0) {
                        Punto punto = new Punto(1, true, matX, matY);
                        puntos.add(punto);
                    }

                    //Se declara como camino.
                    mat[matX][matY] = camino;

                    //Se comprueba la casilla que está debajo y se le ponen los caracteres correspondientes.
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
                    //Se comprueba la casilla que está a la derecha y se le ponen los caracteres correspondientes.
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
                    //Se comprueba la casilla que está debajo y se le ponen los caracteres correspondientes.
                    if (act.estaDebajo()) {
                        mat[matX][matY + 1] = casilla;
                        mat[matX + 1][matY + 1] = blanco;
                        mat[matX - 1][matY + 1] = blanco;
                    }
                    //Se comprueba la casilla que está a la derecha y se le ponen los caracteres correspondientes.
                    if (act.estaDerecha()) {
                        mat[matX + 2][matY] = casilla;
                        mat[matX + 1][matY] = casilla;
                        mat[matX + 3][matY] = casilla;
                    }
                }
            }
        }
    }

    //Método para generar un número aleatorio dado un número mínimo y un número máximo.
    public static int getRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    //A partir de la matriz de caracteres generada en el método Solve y updateMat, se genera una matriz de 1 y 0, dado un tamaño.
    public int[][] generarMatriz(int tamano) {
        //Se construye una nueva matriz aleatoria de caracteres a partir de un tamaño.
        LaberintoC laberinto = new LaberintoC(tamano);
        laberinto.solve();
        laberinto.updateMat();

        //Se sustituye los caracteres '*' por 1, y los demás por 0 a través de un recorrido iterativo.
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

        //Ahora se construye una nueva matriz de 1 y 0 pero más pequeña, dado el tamaño que pusimos.
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

    //Primero se genera una nueva matriz de Puntos y se hace un llamado al método recursivo.
    public int[][] generarCamino(int[][] mat, int condicion) {
        Punto[][] matriz = new Punto[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                matriz[i][j] = new Punto(mat[i][j], false, i, j);
            }
        }
        return generarCamino(0, 0, condicion, matriz);
    }

    //El método recursivo que tiene la función de hacer un recorrido por amplitud para devolver el camino en orden en forma de un arreglo
    //de puntos.
    public int[][] generarCamino(int x, int y, int condicion, Punto mat[][]) {
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
                camJ.add(new Punto(x, y));
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
    
    //Se recibe una cordenada y una matriz y se devuelven los vecinos de ese punto.
    private ArrayList<Integer> obtenerVecinos(int i, int j, int[][] mat){
        ArrayList<Integer> res = new ArrayList<>();
        if(esValido(i-1,j, mat)){
            res.add(mat[i-1][j]);
        }
        if(esValido(i+1,j, mat)){
            res.add(mat[i+1][j]);
        }
        if(esValido(i,j-1, mat)){
            res.add(mat[i][j-1]);
        }
        if(esValido(i,j+1, mat)){
            res.add(mat[i][j+1]);
        }
        return res;
    }
    
    //Se recibe una coordenada y una matriz y se verifica si ese Punto es válido.
    private boolean esValido(int i, int j, int[][] mat){
        boolean res = false;
        if(i >= 0 && j>=0 && i<mat.length && j<mat.length){
            res = true;
        }
        return res;
    }
    
    //Se limpian los unos que restaron del recorrido por amplitud.
    private int[][] limpiarUnos(int[][] matAux){
        int[][] res = new int[matAux.length][matAux.length];
        int pos = 0;
        while(pos < camJ.size()){
            int i = camJ.get(pos).getPosX();
            int j = camJ.get(pos).getPosY();
            res[i][j] = 1;
            pos++;
        }
        return res;
    }
    
    
    public int[][] rellenarJ(int[][] matAux, int condicion){
        int[][] res = limpiarUnos(matAux);
        for(int a=0; a<camJ.size(); a++){
            Punto act = camJ.get(a);
            if(a == 0){
                act.setValor(1);
            }else{
                Punto ant = camJ.get(a-1);
                act.setValor(ant.getValor()+condicion);
            }
        }
        int pos = 0;
        while(pos < camJ.size()){
            Punto aux = camJ.get(pos);
            int x = aux.getPosX(); int y = aux.getPosY();
            res[x][y] = camJ.get(pos).getValor();
            pos++;
        }
        
        for(int i=0; i<res.length; i++){
            for(int j= 0; j<res.length; j++){
                int act = res[i][j];
                if(act == 0){
                    ArrayList<Integer> vecinos = obtenerVecinos(i,j, res);
                    Random  rnd = new Random();
                    int rand = (int)(rnd.nextDouble()*(camJ.get(camJ.size()-1).getValor()+5)+2);
                    while(esIgualAVecino(rand, vecinos, condicion)){
                        rand = (int)(rnd.nextDouble()*(camJ.get(camJ.size()-1).getValor()+5)+2);
                    }
                    res[i][j] = rand;
                }
            }
        }
        return res;
    }
    public int[][] rellenarJ2(int[][] matAux, int condicion){
        int[][] res = limpiarUnos(matAux);
        for(int a=0; a<camJ.size(); a++){
            Punto act = camJ.get(a);
            if(a == 0){
                act.setValor(camJ.size()*condicion);
            }else{
                Punto ant = camJ.get(a-1);
                act.setValor(ant.getValor()-condicion);
            }
        }
        int pos = 0;
        while(pos < camJ.size()){
            Punto aux = camJ.get(pos);
            int x = aux.getPosX(); int y = aux.getPosY();
            res[x][y] = camJ.get(pos).getValor();
            pos++;
        }
        for(int i=0; i<res.length; i++){
            for(int j= 0; j<res.length; j++){
                int act = res[i][j];
                if(act == 0){
                    ArrayList<Integer> vecinos = obtenerVecinos(i,j, res);
                    Random  rnd = new Random();
                    int rand = (int)(rnd.nextDouble()*(camJ.get(1).getValor()+5)+2);
                    while(esIgualAVecino2(rand, vecinos, condicion)){
                        rand = (int)(rnd.nextDouble()*(camJ.get(1).getValor()+5)+2);
                    }
                    res[i][j] = rand;
                }
            }
        }
        
        return res;
    }
    public int[][] rellenarJ3(int[][] matAux, int condicion){
        int[][] res = limpiarUnos(matAux);
        for(int a=0; a<camJ.size(); a++){
            Punto act = camJ.get(a);
            if(a == 0){
                act.setValor(condicion);
            }else{
                int rand = (int)(Math.random()*12+1);
                act.setValor(rand*condicion);
            }
        }
        int pos = 0;
        while(pos < camJ.size()){
            Punto aux = camJ.get(pos);
            int x = aux.getPosX(); int y = aux.getPosY();
            res[x][y] = camJ.get(pos).getValor();
            pos++;
        }
        for(int i=0; i<res.length; i++){
            for(int j= 0; j<res.length; j++){
                int act = res[i][j];
                if(act == 0){
                    Random  rnd = new Random();
                    int rand = (int)(rnd.nextDouble()*100+1);
                    while(esIgualAVecino3(rand, condicion)){
                        rand = (int)(rnd.nextDouble()*100+1);
                    }
                    res[i][j] = rand;
                }
            }
        }
        
        return res;
    }
    
    //Dado un ArrayList se devuelve el menor de los componentes.
    public int getMenor(ArrayList<Integer> arr) {
        int n = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (n > arr.get(i)) {
                n = arr.get(i);
            }
        }
        return n;
    }

    //Dado un ArrayList se devuelve el mayor de los componentes.
    public int getMayor(ArrayList<Integer> arr) {
        int n = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (n < arr.get(i)) {
                n = arr.get(i);
            }
        }
        return n;
    }

    //Devuelve si un Punto es vecino de otro.
    private boolean esIgualAVecino(int n, ArrayList<Integer> vecinos, int condicion) {
        boolean res = false;
        for (int i = 0; i < vecinos.size(); i++) {
            if (n == (vecinos.get(i)+condicion)){
                res = true;
                break;
            }
        }
        return res;
    }
    
    //Devuelve si un Punto es vecino de otro.
    private boolean esIgualAVecino2(int n, ArrayList<Integer> vecinos, int condicion) {
        boolean res = false;
        for (int i = 0; i < vecinos.size(); i++) {
            if (n == (vecinos.get(i)-condicion)){
                res = true;
                break;
            }
        }
        return res;
    }
    
    //Devuelve si un Punto es vecino de otro.
    private boolean esIgualAVecino3(int n, int condicion) {
        boolean res = false;
            if (n%condicion == 0){
                res = true;
            }
        return res;
    }

    //Devuelve si un punto es una pared o no.
    public boolean noEsPared(int[][] mat, int x, int y) {
        return !(x < 0 || x >= mat.length || y < 0 || y >= mat.length) && (mat[x][y] != 0);
    }

    //Devuelve una matriz con las paredes generadas a partir del arreglo de camino.
    public int[][] genPar(int[][] mat, ArrayList<Punto> camino) {
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
    
    //Devuelve el punto mayor de un arreglo.
    public int getPuntoMayor(int x, int y, ArrayList<Punto> camino) {
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

    //Devuelve el resultado de un punto, si es válido o no.
    public boolean esValido(Punto[][] mat, int x, int y) {
        return !(x < 0 || x >= mat.length || y < 0 || y >= mat.length) && (mat[x][y].getValor() != 0 && !mat[x][y].getVisitada());
    }

    //Devuelve el camino de putnos ordenado en forma de arreglo.
    public ArrayList<Punto> getCamino(int[][] mat) {
        ArrayList<Punto> camino = new ArrayList<Punto>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != 0) {
                    camino.add(new Punto(mat[i][j], i, j));
                }
            }
        }
        camino = ordenar(camino);
        camJ = camino;
        return camino;
    }

    //Devuelve el camino de putnos ordenado en forma de arreglo.
    public ArrayList<Punto> getCam(int[][] mat) {
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

    //Dado un arreglo, lo devuelve ordenado en base al índice numérico.
    public ArrayList<Punto> ordenar(ArrayList<Punto> arr) {
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

    //Devuelve un camino de múltiplos en forma de arreglo.
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

    //Devuelve una matriz con no múltiplos y con el camino generado en el método generarCaminoMult integrado.
    public int[][] generarMatrizMult(ArrayList<Punto> camino, int mult, int[][] mat) {
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

    //A partir de una arreglo, un número inicial y una condición, devuelve un ArrayList de Puntos ordenados para una secuencia numérica.
    public ArrayList<Punto> generarCaminoSec(ArrayList<Punto> arr, int ini, int condicion) {
        ArrayList<Punto> camino = new ArrayList<Punto>();
        int aux = ini;
        for (int i = 0; i < arr.size(); i++) {
            camino.add(new Punto(aux, i, arr.get(i).getPosX(), arr.get(i).getPosY()));
            aux = aux + condicion;
        }
        return camino;
    }

    //Dada una matriz, la invierte.
    public int[][] invertirMatriz(int[][] mat) {
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

    //Dado un ArrayList de Puntos, lo invierte.
    public ArrayList<Punto> invertirCamino(ArrayList<Punto> camino) {
        Collections.reverse(camino);
        return camino;
    }

    //A pertir de un ArrayList de Puntos y una matriz de de enteros, devuelve todo unificado.
    public int[][] generarMatrizSec(ArrayList<Punto> camino, int[][] mat) {
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
}
