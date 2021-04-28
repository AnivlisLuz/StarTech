package folder;

public class Suma extends Matriz {

    private int condicion;//Condición para avanzar en el laberinto

    public Suma(int tamaño, int condicion) {
        super(tamaño);
        this.condicion = condicion;
    }

    //Método para crear un Laberinto según la condición o nivel
    public void rellenarLaberinto() {
        laberinto = lab.rellenarJ(matriz, condicion);
    }
}
