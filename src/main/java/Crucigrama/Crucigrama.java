
package Crucigrama;

import app.startech.crucigrama.MatrizCrucigrama;
import app.startech.laberintos.Laberinto;
import app.startech.laberintos.Matriz;

public class Crucigrama extends Laberinto{
    private String titulo;
    private String condicion;
    private int nivel;
    private MatrizCrucigrama mat;
    private char[][] matriz;
    private char[][] matrizAux;
    private int vidas;
    
    public Crucigrama(String titulo, String condicion, int nivel){
        super(titulo,nivel,"",condicion);
        this.titulo = titulo;
        
        this.condicion = condicion;
        this.nivel = nivel;
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
            mat = new MatrizCrucigrama("suma");
            matriz = mat.getMat();
            matrizAux = mat.getMatRes();
        }else if(nivel == 2){
            mat = new MatrizCrucigrama("resta");
            matriz = mat.getMat();
            matrizAux = mat.getMatRes();
        }else if(nivel == 3){
            mat = new MatrizCrucigrama("multiplicacion");
            matriz = mat.getMat();
            matrizAux = mat.getMatRes();
        }else if(nivel == 4){
            mat = new MatrizCrucigrama("division");
            matriz = mat.getMat();
            matrizAux = mat.getMatRes();
        }else{
            mat = new MatrizCrucigrama("combinados");
            matriz = mat.getMat();
            matrizAux = mat.getMatRes();
        }
    }

//    public Matriz getMatriz() {
//        return matriz;
//    }
//    public char[][] generarCrucigrama(int nivel){
//        char[][] a={{'#','#','#','#','#','#','#','#','#','#','#','#','#'},
//                    {'#','@','+','3','=','7','#','#','#','#','#','#','#'},
//                    {'#','#','#','+','#','#','#','#','#','#','#','#','#'},
//                    {'#','#','#','1','+','6','=','@','#','#','#','#','#'},
//                    {'#','#','#','=','#','#','#','+','#','#','#','#','#'},
//                    {'#','2','+','@','=','@','#','2','#','#','#','#','#'},
//                    {'#','#','#','#','#','+','#','=','#','#','#','#','#'},
//                    {'#','#','#','#','#','3','#','9','#','#','#','#','#'},
//                    {'#','#','#','#','#','=','#','#','#','#','#','#','#'},
//                    {'#','#','#','#','#','9','#','#','#','#','#','#','#'},
//                    {'#','#','#','#','#','#','#','#','#','#','#','#','#'},
//                    {'#','#','#','#','#','#','#','#','#','#','#','#','#'},
//                    {'#','#','#','#','#','#','#','#','#','#','#','#','#'}};
//        return a;
//    }

    public char[][] getCrucigramaMatriz() {
        return matriz;
    }

    char[][] getMatrizAux() {
        return matrizAux;
    }
    
    
}
