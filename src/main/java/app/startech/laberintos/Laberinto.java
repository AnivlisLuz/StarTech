package app.startech.laberintos;

public class Laberinto {

    private final String titulo;
    private final String condicion;
    private final int nivel;
    private String dir1;
    private String dir2;
    private String dirFondo;
    private int vidas;
    private final String mensaje;
    private Matriz matriz;
    private final String reto;

    public Laberinto(String titulo, int nivel, String mensaje, String condicion, String reto) {
        this.condicion = condicion;
        this.reto = reto;
        this.nivel = nivel;
        this.titulo = titulo;
        vidas = 3;
        this.mensaje = mensaje;
    }

    public String getDir1() {
        return dir1;
    }

    public String getDir2() {
        return dir2;
    }

    public String getDirFondo() {
        return dirFondo;
    }
    
    public String getReto(){
        return reto;
    }

    //Retorna la condición. Ejem: Suma de uno en uno
    public String getCondicion() {
        return condicion;
    }

    //Disminuye la cantidad de vidas
    public void setVidas() {
        vidas--;
    }

    //Restaura toda las vidas
    public void restaurarVidas() {
        vidas = 3;
    }

    //Retorna la cantidad de vidas
    public int getVidas() {
        return vidas;
    }

    //Retorna el título. Ejm: Secuencia
    public String getTitulo() {
        return titulo;
    }

    //Retorna el mensaje. Ejm: tu puedes!!!
    public String getMensaje() {
        return mensaje;
    }

    //Genera el laberinto según la categoría (título) y el nivel
    public void mostrarMatriz() {
        if (titulo.equals("Secuencia")) {       // laberinto Secuencia tendria las siguientes matrices:
            dir2 = "/app/startech/imagenes/decorate/7.png";
            dir1 = "/app/startech/imagenes/decorate/8.png";
            dirFondo = "/app/startech/imagenes/fondo1.4.jpg";
            if (nivel == 1) {                   // lvl 1 = tamaño 3 
                matriz = new Secuencia(3);      // lvl 2 = tamaño 4
                matriz.generarLaberinto();      // lvl 3 = tamaño 6
                matriz.rellenarLaberinto();     // lvl 4 = tamaño 8
            } else {                            // lvl 5 = tamaño 10
                for (int i = 2; i < 6; i++) {
                    if (nivel == i) {
                        matriz = new Secuencia(i * 2);
                        matriz.generarLaberinto();
                        matriz.rellenarLaberinto();
                        break;
                    }
                }
            }
        } else if (titulo.equals("Suma")) {         // laberinto Suma todas sus matrices son de tamaño 6
            dir2 = "/app/startech/imagenes/decorate/3.png";
            dir1 = "/app/startech/imagenes/decorate/4.png";
            dirFondo = "/app/startech/imagenes/fondo1.2.jpg";
            for (int i = 1; i < 10; i++) {          // su condición sube de acuerdo al nivel de 2 a 10
                if (nivel == i) {
                    matriz = new Suma(6, i + 1);
                    matriz.generarLaberinto();
                    matriz.rellenarLaberinto();
                    break;
                }
            }
        } else if (titulo.equals("Resta")) {        // laberinto Resta todas sus matrices son de tamaño 6
            dir2 = "/app/startech/imagenes/decorate/5.png";
            dir1 = "/app/startech/imagenes/decorate/6.png";
            dirFondo = "/app/startech/imagenes/fondo1.3.jpg";
            for (int i = 1; i < 11; i++) {          // su condición sube de acuerdo al nivel de 1 a 10
                if (nivel == i) {
                    matriz = new Resta(6, i);
                    matriz.generarLaberinto();
                    matriz.rellenarLaberinto();
                    break;
                }
            }
        } else if (titulo.equals("Multiplicación")) {   // laberinto Multiplicación todas sus matrices son de tamaño 10
            dir2 = "/app/startech/imagenes/decorate/1.png";
            dir1 = "/app/startech/imagenes/decorate/2.png";
            dirFondo = "/app/startech/imagenes/fondo1.1.jpg";
            for (int i = 1; i < 10; i++) {              // su condición sube de acuerdo al nivel de 2 a 10
                if (nivel == i) {
                    matriz = new Multiplicacion(10, i + 1);
                    matriz.generarLaberinto();
                    matriz.rellenarLaberinto();
                    break;
                }
            }
        } else if (titulo.equals("División")) {         // laberinto Divición todas sus matrices son de tamaño 10
            dir2 = "/app/startech/imagenes/decorate/9.png";
            dir1 = "/app/startech/imagenes/decorate/10.png";
            dirFondo = "/app/startech/imagenes/fondo1.5.jpg";
            for (int i = 1; i < 10; i++) {              // su condición sube de acuerdo al nivel de 2 a 10
                if (nivel == i) {
                    matriz = new Divicion(10, i + 1);
                    matriz.generarLaberinto();
                    matriz.rellenarLaberinto();
                    break;
                }
            }
        }
    }

    //Retorna la matriz 
    public Matriz getMatriz() {
        return matriz;
    }
}
