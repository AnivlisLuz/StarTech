
package folder;

public class Secuencia extends Matriz {
    
    
    public Secuencia(int tamaño){
        super(tamaño);
    }
    
    public void rellenarLaberinto(){
//        laberinto = lab.generarCamino(matriz, 1);
          laberinto = lab.rellenarJ(matriz, 1);
    }
    

}
