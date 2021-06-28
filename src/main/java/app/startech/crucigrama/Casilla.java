/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.crucigrama;

/**
 *
 * @author Carlos
 */
public class Casilla {
    private int x;
    private int y;
    private char contenido;
    
    public Casilla (int x, int y, char contenido)
    {
        this.x = x;
        this.y = y;
        this.contenido = contenido;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public boolean esNumero()
    {
        boolean es = false;
        if (contenido == '1' || 
            contenido == '2' ||
            contenido == '3' ||
            contenido == '4' ||
            contenido == '5' ||
            contenido == '6' ||
            contenido == '7' ||
            contenido == '8' ||
            contenido == '9')
            es = true;
        return es;
    }
    
    public char getContenido()
    {
        return contenido;
    }
}
