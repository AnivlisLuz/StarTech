/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

/**
 *
 * @author Criss
 */
public class Divicion extends Matriz{
    
    private int condicion;
    
    public Divicion(int tamaño, int condicion){
        super(tamaño);
        this.condicion = condicion;
        rellenarLaberinto();
    }
    
    public void rellenarLaberinto(){
        laberinto = lab.rellenarJ3(matriz, condicion);
    }
}
