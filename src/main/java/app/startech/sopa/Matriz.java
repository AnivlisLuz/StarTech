/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.sopa;

/**
 *
 * @author USER
 */
public class Matriz {
    private Cuadro[][] matriz;
    private int iniX;
    private int iniY;
    private int x;
    private int y;
    public Matriz(int x, int y){
        iniX=0;
        iniY=0;
        this.x=x;
        this.y=y;
        System.out.println(x+"*"+y);
        matriz =new Cuadro[y][x];
    }
    void anadir(Cuadro nuevo){
        if(iniX<x){
            matriz[iniY][iniX]=nuevo;
            iniX++;
        }else if(iniY<y){
            iniX=0;
            matriz[iniY][iniX]=nuevo;
            iniY++;
        }
    }
    public Cuadro[][] getMatriz(){
        return matriz;
    }
    
}
