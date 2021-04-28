package folder;

public class Multiplicacion extends Matriz {

    private int condicion;//condición para avanzar en el laberinto

    public Multiplicacion(int tamaño, int condicion) {
        super(tamaño);
        this.condicion = condicion;
    }

    //Método para crear un Laberinto según la condición o nivel
    public void rellenarLaberinto() {
        laberinto = lab.rellenarJ3(matriz, condicion);
    }
}
