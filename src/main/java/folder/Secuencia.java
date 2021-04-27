
package folder;

import java.util.ArrayList;
import static laberintoc.LaberintoC.getCamino;
import laberintoc.Punto;

public class Secuencia extends Matriz {

    public Secuencia(int tamaño) {
        super(tamaño);
        rellenarLaberinto();
    }

    public void rellenarLaberinto() {
        // laberinto = lab.generarCamino(matriz, 1);
        laberinto = lab.rellenarJ(matriz, 1);
    }

}
