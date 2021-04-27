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
public class Suma extends Matriz{
    
    private int condicion;
    
    public Suma(int tamaño, int condicion){
        super(tamaño);
        this.condicion = condicion;
    }
    
    public void rellenarLaberinto(){
//        laberinto = lab.generarCamino(matriz, condicion);   
        laberinto = lab.rellenarJ(matriz, condicion);
    }
}
