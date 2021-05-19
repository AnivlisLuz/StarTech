package app.startech.laberintos;

public class Resta extends Matriz {

    private final int condicion;//condición para avanzar en el laberinto

    public Resta(int tamaño, int condicion) {
        super(tamaño);
        this.condicion = condicion;
    }

    //Método para crear un Laberinto de restas, según la condición dada.
    public void rellenarLaberinto() {
        laberinto = lab.rellenarJ2(matriz, condicion);
    }
}
