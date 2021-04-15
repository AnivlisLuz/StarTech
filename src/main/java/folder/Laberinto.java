
package folder;

public class Laberinto{
    
    private String titulo; 
    private int     nivel;
    private int     vidas; 
    private String  mensaje; 
    private Matriz  matriz; 
   
    public Laberinto(String titulo, int nivel, String mensaje){
        this.nivel = nivel;
        this.titulo = titulo;
        vidas = 3;
        this.mensaje = mensaje;
        matriz = null;
    }
    
    public void mostrarMatriz(){
        if(titulo.equals("Secuencia")){
            for (int i = 1; i < 6; i++) {
                if(nivel == i){
                    matriz = new Secuencia(i*3);
                    matriz.generarLaberinto();
                    matriz.rellenarLaberinto();
                    break;
                }
            }
        }else if(titulo.equals("Suma")){
            for (int i = 1; i < 10; i++) {
                if (nivel == i) {
                    matriz = new Suma(6, i+1);
                    matriz.generarLaberinto();
                    matriz.rellenarLaberinto();
                    break;
                }
            }
        }else if(titulo.equals("Resta")){
            for (int i = 1; i < 11; i++) {
                if (nivel == i) {
                    matriz = new Resta(6, i);
                    matriz.generarLaberinto();
                    matriz.rellenarLaberinto();
                    break;
                }
            }
        }else if(titulo.equals("Multiplicacion")){
            for (int i = 1; i < 10; i++) {
                if (nivel == i) {
                    matriz = new Multiplicacion(10, i+1);
                    matriz.generarLaberinto();
                    matriz.rellenarLaberinto();
                    break;
                }
            }
        }else if(titulo.equals("Divicion")){
            for (int i = 1; i < 10; i++) {
                if (nivel == i) {
                    matriz = new Divicion(10, i+1);
                    matriz.generarLaberinto();
                    matriz.rellenarLaberinto();
                    break;
                }
            }
        }
    }
    public Matriz getMatriz(){
        return matriz;
    }
}
