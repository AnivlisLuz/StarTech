/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and abierta the template in the editor.
 */
package laberinto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author Carlos
 */
public class LaberintoC
{
    //aux
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

    public LaberintoC(int x, int y)
    {
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

    private void init()
    {
        casillas = new Casilla[X][Y];
        for (int x = 0; x < X; x++)
            for (int y = 0; y < Y; y++)
                casillas[x][y] = new Casilla(x, y, false);
    }
    
    private void generarLaberinto()
    {
        generarLaberinto(0, 0);
    }
    
    private void generarLaberinto(int x, int y)
    {
        generarLaberinto(getCasilla(x, y));
    }
    
    private void generarLaberinto(Casilla ini)
    {
        if (ini == null) return;
        ini.abierta = false;
        ArrayList<Casilla> casillas = new ArrayList<>();
        casillas.add(ini);

        while (!casillas.isEmpty())
        {
            Casilla casilla;
            
            if (random.nextInt(10)==0)
                casilla = casillas.remove(random.nextInt(casillas.size()));
            else casilla = casillas.remove(casillas.size() - 1);
            
            ArrayList<Casilla> vecinos = new ArrayList<>();
            
            Casilla[] posiblesVecinos = new Casilla[]
            {
                getCasilla(casilla.x + 1, casilla.y),
                getCasilla(casilla.x    , casilla.y + 1),
                getCasilla(casilla.x - 1, casilla.y),
                getCasilla(casilla.x    , casilla.y - 1)
            };
            
            for (Casilla aux : posiblesVecinos)
            {
                if (aux == null || aux.pared || !aux.abierta) continue;
                vecinos.add(aux);
            }
            
            if (vecinos.isEmpty()) continue;
            
            Casilla seleccionada = vecinos.get(random.nextInt(vecinos.size()));
            seleccionada.abierta = false;
            casilla.addVecino(seleccionada);
            casillas.add(casilla);
            casillas.add(seleccionada);
        }
    }

    public Casilla getCasilla(int x, int y)
    {
        try
        {
            return casillas[x][y];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return null;
        }
    }

    public void solve()
    {
        this.solve(0, 0, X - 1, Y -1);
    }
    
    public void solve(int iniX, int iniY, int finX, int finY)
    {
        for (Casilla[] filaCasilla : this.casillas)
        {
            for (Casilla casilla : filaCasilla)
            {
                casilla.padre = null;
                casilla.visitado = false;
                casilla.enCamino = false;
                casilla.pisada = 0;
                casilla.distancia = -1;
            }
        }
        
        ArrayList<Casilla> casillasAbiertas = new ArrayList<>();
        Casilla casillaFin = getCasilla(finX, finY);
        
        if (casillaFin == null) return;
        {
            Casilla ini = getCasilla(iniX, iniY);
            if (ini == null) return;
            ini.distancia = getDistancia(ini, 0, casillaFin);
            ini.visitado = true;
            casillasAbiertas.add(ini);
        }
        boolean resolvifino = true;
        while (resolvifino) {
            if (casillasAbiertas.isEmpty()) return;
            Collections.sort(casillasAbiertas, new Comparator<Casilla>()
            {
                @Override
                public int compare(Casilla cas1, Casilla cas2)
                {
                    double diff = cas1.distancia - cas2.distancia;
                    if (diff > 0) return 1;
                    else if (diff < 0) return -1;
                    else return 0;
                }
            });
            Casilla act = casillasAbiertas.remove(0);
            if (act == casillaFin) break;
            for (Casilla vecino : act.vecinos)
            {
                double projDist = getDistancia(vecino,
                        act.pisada + 1, casillaFin);
                if (!vecino.visitado || projDist < vecino.distancia)
                {
                    vecino.padre = act;
                    vecino.visitado = true;
                    vecino.distancia = projDist;
                    vecino.pisada = act.pisada + 1;
                    
                    if (!casillasAbiertas.contains(vecino))
                        casillasAbiertas.add(vecino);
                }
            }
        }

        Casilla backtracking = casillaFin;
        backtracking.enCamino = true;
        while (backtracking.padre != null)
        {
            backtracking = backtracking.padre;
            backtracking.enCamino = true;
        }
    }

    public double getDistancia(Casilla act, double pisada, Casilla fin)
    {
        return pisada + Math.abs(act.x - fin.x) + Math.abs(act.y - act.x);
    }

    public void updateMat()
    {
        char blanco = ' ', pared = '#', casilla = ' ', camino = '*';
        for (int x = 0; x < matX; x ++)
            for (int y = 0; y < matY; y ++)
                mat[x][y] = blanco;

        for (int x = 0; x < matX; x ++)
            for (int y = 0; y < matY; y ++)
                if (x % 4 == 0 || y % 2 == 0)
                    mat[x][y] = pared;
        
        for (int x = 0; x < X; x++)
        {
            for (int y = 0; y < Y; y++)
            {
                Casilla act = getCasilla(x, y);
                int matX = x * 4 + 2, matY = y * 2 + 1;
                
                if (act.enCamino)
                {
                    mat[matX][matY] = camino;
                    
                    if (act.estaDebajo())
                        if (getCasilla(x, y + 1).enCamino)
                        {
                            mat[matX][matY + 1] = camino;
                            mat[matX + 1][matY + 1] = blanco;
                            mat[matX - 1][matY + 1] = blanco;
                        }
                        else
                        {
                            mat[matX][matY + 1] = casilla;
                            mat[matX + 1][matY + 1] = blanco;
                            mat[matX - 1][matY + 1] = blanco;
                        }
                    if (act.estaDerecha())
                        if (getCasilla(x + 1, y).enCamino)
                        {
                            mat[matX + 2][matY] = camino;
                            mat[matX + 1][matY] = camino;
                            mat[matX + 3][matY] = camino;
                        }
                        else
                        {
                            mat[matX + 2][matY] = casilla;
                            mat[matX + 1][matY] = casilla;
                            mat[matX + 3][matY] = casilla;
                        }
                }
                else
                {
                    mat[matX][matY] = casilla;
                    if (act.estaDebajo())
                    {
                        mat[matX][matY + 1] = casilla;
                        mat[matX + 1][matY + 1] = blanco;
                        mat[matX - 1][matY + 1] = blanco;
                    }
                    if (act.estaDerecha())
                    {
                        mat[matX + 2][matY] = casilla;
                        mat[matX + 1][matY] = casilla;
                        mat[matX + 3][matY] = casilla;
                    }
                }
            }
        }
    }

    public void dibujar()
    {
        System.out.println(this);
    }

    @Override
    public String toString()
    {
        updateMat();
        String output = "";
        for (int y = 0; y < matY; y++)
        {
            for (int x = 0; x < matX; x++)
            {
                output += mat[x][y];
            }
            output += "\n";
        }
        return output;
    }
    
    public static int[][] generarMatriz(int tamano)
    {
        LaberintoC laberinto = new LaberintoC(tamano);
        laberinto.solve();
        laberinto.updateMat();
        
        int[][] matriz = new int[laberinto.mat.length][(laberinto.mat.length) - (tamano * 2)];
        for (int i = 0; i<laberinto.mat.length; i++)
        {
            for (int j = 0; j<laberinto.mat[i].length; j++)
            {
                if (laberinto.mat[i][j] == '*')
                    matriz[i][j] = 1;
                else
                    matriz[i][j] = 0;
            }
        }
        
        int[][] auxMat = new int[tamano][tamano];
        int p = 2;
        for (int col = 0; col<auxMat.length; col++)
        {
            int q = 1;
            for (int fil = 0; fil<auxMat[col].length; fil++)
            {
                if (matriz[p][q] == 1)
                    auxMat[col][fil] = 1;
                else
                    auxMat[col][fil] = 0;
                q = q + 2;
            }
            p = p + 4;
        }
        
        return auxMat;
        
        
    }

    public static void main(String[] args)
    {
        /*
        int tamano = 10;
        Laberinto laberinto = new Laberinto(tamano);
        laberinto.solve();
        laberinto.dibujar();
        
        System.out.println(laberinto.mat[2][2]);
        System.out.println(laberinto.mat.length);
        
        int[][] matriz = new int[laberinto.mat.length][(laberinto.mat.length) - (tamano * 2)];
        for (int i = 0; i<laberinto.mat.length; i++)
        {
            for (int j = 0; j<laberinto.mat[i].length; j++)
            {
                if (laberinto.mat[i][j] == '*')
                    matriz[i][j] = 1;
                else
                    matriz[i][j] = 0;
            }
        }
        
        int[][] auxMat = new int[tamano][tamano];
        int p = 2;
        for (int col = 0; col<auxMat.length; col++)
        {
            int q = 1;
            for (int fil = 0; fil<auxMat[col].length; fil++)
            {
                if (matriz[p][q] == 1)
                    auxMat[col][fil] = 1;
                else
                    auxMat[col][fil] = 0;
                q = q + 2;
            }
            p = p + 4;
        }
        
        dibujarMatriz(matriz);
        dibujarMatriz(laberinto.mat);
        dibujarMatriz(auxMat);
        System.out.println(matriz.length);
        */
        
        dibujarMatriz(generarMatriz(5));
    }
    
    public static void dibujarMatriz(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[i].length; j++) {
            System.out.print(matrix[i][j] + "");
         }
         System.out.println();
      }
    }
    
    public static void dibujarMatriz(char[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[i].length; j++) {
            System.out.print(matrix[i][j] + "");
         }
         System.out.println();
      }
    }
}
