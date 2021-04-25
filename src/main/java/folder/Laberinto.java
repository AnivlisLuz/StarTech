package folder;

public class Laberinto {

    private String titulo;
    private String condicion;
    private int nivel;
    private int vidas;
    private String mensaje;
    private Matriz matriz;

    public Laberinto(String titulo, int nivel, String mensaje, String condicion) {
        this.condicion = condicion;
        this.nivel = nivel;
        this.titulo = titulo;
        vidas = 3;
        this.mensaje = mensaje;
        mostrarMatriz();
    }
    
    public String getCondicion(){
        return condicion;
    }
    public void setVidas(){
        vidas--;
    }
    public void restaurarVidas(){
        vidas = 3;
    }
    public int getVidas(){
        return vidas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void mostrarMatriz() {
        if (titulo.equals("Secuencia")) {     // laberinto Secuencia tendria las siguientes matrices:
            if (nivel == 1) {                 // lvl 1 = tamaño 3                 
                matriz = new Secuencia(3);  // lvl 2 = tamaño 4
                matriz.generarLaberinto();  // lvl 3 = tamaño 6
                matriz.rellenarLaberinto(); // lvl 4 = tamaño 8
            } else {                          // lvl 5 = tamaño 10
                for (int i = 2; i < 6; i++) {
                    if (nivel == i) {
                        matriz = new Secuencia(i * 2);
                        matriz.generarLaberinto();
                        matriz.rellenarLaberinto();
                        break;
                    }
                }
            }
        } else if (titulo.equals("Suma")) {
            for (int i = 1; i < 10; i++) {
                if (nivel == i) {
                    matriz = new Suma(6, i + 1);
                    matriz.generarLaberinto();
                    matriz.rellenarLaberinto();
                    break;
                }
            }
        } else if (titulo.equals("Resta")) {
            for (int i = 1; i < 11; i++) {
                if (nivel == i) {
                    matriz = new Resta(6, i);
                    matriz.generarLaberinto();
                    matriz.rellenarLaberinto();
                    break;
                }
            }
        } else if (titulo.equals("Multiplicación")) {
            for (int i = 1; i < 10; i++) {
                if (nivel == i) {
                    matriz = new Multiplicacion(10, i + 1);
                    matriz.generarLaberinto();
                    matriz.rellenarLaberinto();
                    break;
                }
            }
        } else if (titulo.equals("Divición")) {
            for (int i = 1; i < 10; i++) {
                if (nivel == i) {
                    matriz = new Divicion(10, i + 1);
                    matriz.generarLaberinto();
                    matriz.rellenarLaberinto();
                    break;
                }
            }
        }
    }

    public Matriz getMatriz() {
        return matriz;
    }
}
