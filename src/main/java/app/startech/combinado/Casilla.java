/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.combinado;

/**
 *
 * @author Carlos
 */
public class Casilla {
    private int x;
    private int y;
    private String contenido;
    
    private String resultado;
    
    public Casilla(int x, int y, String contenido)
    {
        this.x = x;
        this.y = y;
        this.contenido = contenido;
    }
    
    public Casilla(int x, int y, String contenido, String rsultado)
    {
        this.x = x;
        this.y = y;
        this.contenido = contenido;
        this.resultado = resultado;
    }
}
