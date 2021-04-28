package folder;

public class Secuencia extends Matriz {

    public Secuencia(int tamaño) {
        super(tamaño);
    }

    //Método para crear un Laberinto de Secuencia
    public void rellenarLaberinto() {
        laberinto = lab.rellenarJ(matriz, 1);
    }

}
