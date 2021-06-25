
package Convinados;

//import app.startech.combinado.MatrizCombinado;
import app.startech.laberintos.Laberinto;

public class Combinado extends Laberinto{
    private String titulo;
    private String condicion;
    private int nivel;
  //  private MatrizCombinado mat;
    private String[][] matriz;
    private String[][] matrizAux;
    private int vidas;
    
    public Combinado(String titulo, String condicion, int nivel){
        super(titulo,nivel,"",condicion);
        this.titulo = titulo;
        this.condicion = condicion;
        this.nivel = 1;
        vidas = 3;
    }

    public String[][] getCombinadoMatriz() {
        return matriz;
    }

    public String[][] getMatrizAux() {
        String[][] a={{"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","6","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","-3","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","3","#","#","+3","9","+2","#","#","#","#","#","#"},
                    {"#","+7","#","#","6","#","11","#","#","#","#","#","#"},
                    {"#","10","+2","12","-6","#","-5","6","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"}};
        return a;
//return matrizAux;
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
            //mat = new MatrizCombinado(nivel);
            //matriz = mat.getMat();
            //matrizAux = mat.getMatRes();
            matriz = generarCrucigrama(nivel);
            matrizAux = getMatrizAux();
        }else if(nivel == 2){
            //mat = new MatrizCombinado(nivel);
            //matriz = mat.getMat();
            //matrizAux = mat.getMatRes();
            matriz = generarCrucigrama(nivel);
            matrizAux = getMatrizAux();
        }else if(nivel == 3){
            //mat = new MatrizCombinado(nivel);
            //matriz = mat.getMat();
            //matrizAux = mat.getMatRes();
            matriz = generarCrucigrama(nivel);
            matrizAux = getMatrizAux();
        }else{
            //mat = new MatrizCombinado(nivel);
            //matriz = mat.getMat();
            //matrizAux = mat.getMatRes();
            matriz = generarCrucigrama(nivel);
            matrizAux = getMatrizAux();
        }
    }

//    public Matriz getMatriz() {
//        return matriz;
//    }
    public String[][] generarCrucigrama(int nivel){
        String[][] a={{"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","6","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","-3","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","@","#","#","+3","@","+2","#","#","#","#","#","#"},
                    {"#","+7","#","#","@","#","@","#","#","#","#","#","#"},
                    {"#","@","+2","@","-6","#","-5","@","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"},
                    {"#","#","#","#","#","#","#","#","#","#","#","#","#"}};
        return a;
    }

}
