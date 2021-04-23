
package folder;

public class Secuencia extends Matriz {
    
    
    public Secuencia(int tamaño){
        super(tamaño);
        rellenarLaberinto();
    }
    
    public void rellenarLaberinto(){
        laberinto = lab.generarCamino(matriz, 1);
    }
    

}
