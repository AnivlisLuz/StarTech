
package Crucigrama;

import app.startech.laberintos.Matriz;

public class Crucigrama {
    private String titulo;
    private int nivel;
    //private Matriz matriz;
    private char[][] matriz;
    private int vidas;
    
    public Crucigrama(String titulo, int nivel){
        this.titulo = titulo;
        this.nivel = nivel;
        vidas = 3;
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
    
    public void mostrarMatriz(){
        if(nivel == 1){
            matriz = generarCrucigrama(nivel);
        }else if(nivel == 2){
            matriz = generarCrucigrama(nivel);
        }else if(nivel == 2){
            matriz = generarCrucigrama(nivel);
        }else if(nivel == 2){
            matriz = generarCrucigrama(nivel);
        }else{
            matriz = generarCrucigrama(nivel);
        }
    }

//    public Matriz getMatriz() {
//        return matriz;
//    }
    public char[][] generarCrucigrama(int nivel){
        char[][] a={{'#','#','#','#'},
                    {'#','@','4','#'},
                    {'#','@','4','#'},
                    {'#','@','4','#'}};
        return a;
    }

    public char[][] getMatriz() {
        return matriz;
    }
    
    
}
