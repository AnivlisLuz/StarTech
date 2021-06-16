
package Crucigrama;

import app.startech.laberintos.Matriz;

public class Crucigrama {
    private String titulo;
    private String condicion;
    private int nivel;
    //private Matriz matriz;
    private char[][] matriz;
    private char[][] matrizAux;
    private int vidas;
    
    public Crucigrama(String titulo, String condicion, int nivel){
        this.titulo = titulo;
        this.condicion = condicion;
        this.nivel = 1;
        vidas = 3;
    }

    public String getCondicion() {
        return condicion;
    }
    
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
    
    public void mostrarMatriz(){
        if(nivel == 1){
            matriz = generarCrucigrama(nivel);
        }else if(nivel == 2){
            matriz = generarCrucigrama(nivel);
        }else if(nivel == 3){
            matriz = generarCrucigrama(nivel);
        }else if(nivel == 4){
            matriz = generarCrucigrama(nivel);
        }else{
            matriz = generarCrucigrama(nivel);
        }
    }

//    public Matriz getMatriz() {
//        return matriz;
//    }
    public char[][] generarCrucigrama(int nivel){
        char[][] a={{'#','#','#','#','#','#','#','#','#','#','#','#','#'},
                    {'#','@','+','3','=','7','#','#','#','#','#','#','#'},
                    {'#','#','#','+','#','#','#','#','#','#','#','#','#'},
                    {'#','#','#','1','+','6','=','@','#','#','#','#','#'},
                    {'#','#','#','=','#','#','#','+','#','#','#','#','#'},
                    {'#','2','+','@','=','@','#','2','#','#','#','#','#'},
                    {'#','#','#','#','#','+','#','=','#','#','#','#','#'},
                    {'#','#','#','#','#','3','#','9','#','#','#','#','#'},
                    {'#','#','#','#','#','=','#','#','#','#','#','#','#'},
                    {'#','#','#','#','#','9','#','#','#','#','#','#','#'},
                    {'#','#','#','#','#','#','#','#','#','#','#','#','#'},
                    {'#','#','#','#','#','#','#','#','#','#','#','#','#'},
                    {'#','#','#','#','#','#','#','#','#','#','#','#','#'}};
        return a;
    }

    public char[][] getMatriz() {
        return matriz;
    }

    char[][] getMatrizAux() {
        matrizAux = new char[][]{{'#','#','#','#','#','#','#','#','#','#','#','#','#'},
                                 {'#','4','+','3','=','7','#','#','#','#','#','#','#'},
                                 {'#','#','#','+','#','#','#','#','#','#','#','#','#'},
                                 {'#','#','#','1','+','6','=','7','#','#','#','#','#'},
                                 {'#','#','#','=','#','#','#','+','#','#','#','#','#'},
                                 {'#','2','+','4','=','6','#','2','#','#','#','#','#'},
                                 {'#','#','#','#','#','+','#','=','#','#','#','#','#'},
                                 {'#','#','#','#','#','3','#','9','#','#','#','#','#'},
                                 {'#','#','#','#','#','=','#','#','#','#','#','#','#'},
                                 {'#','#','#','#','#','9','#','#','#','#','#','#','#'},
                                 {'#','#','#','#','#','#','#','#','#','#','#','#','#'},
                                 {'#','#','#','#','#','#','#','#','#','#','#','#','#'},
                                 {'#','#','#','#','#','#','#','#','#','#','#','#','#'}};
        return matrizAux;
    }
    
    
}
