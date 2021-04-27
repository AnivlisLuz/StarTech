/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import java.util.ArrayList;
import laberintoc.Punto;

/**
 *
 * @author Criss
 */
public class Multiplicacion extends Matriz {

    private int condicion;

    public Multiplicacion(int tamaño, int condicion) {
        super(tamaño);
        this.condicion = condicion;
        rellenarLaberinto();
    }

    public void rellenarLaberinto() {
        laberinto = lab.rellenarJ3(matriz, condicion);
    }
}
