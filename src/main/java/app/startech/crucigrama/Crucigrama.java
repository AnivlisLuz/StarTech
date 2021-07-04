
package app.startech.crucigrama;

import app.startech.crucigrama.MatrizCrucigrama;
import app.startech.laberintos.Laberinto;
import app.startech.laberintos.Matriz;

public class Crucigrama extends Laberinto{
    private String titulo;
    private String condicion;
    private int nivel;
    private MatrizCrucigrama mat;
    private String dir1;
    private String dir2;
    private String dirFondo;
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

    public String getDir1() {
        return dir1;
    }

    public String getDir2() {
        return dir2;
    }

    public String getDirFondo() {
        return dirFondo;
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
            dir2 = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\7.png";
            //ImageIcon dir2 = new ImageIcon(getClass().getResource("/app/startech/imagenes/decorate/7.png"));
            dir1 = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\8.png";
            dirFondo = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\fondo1.4.jpg";
            mat = new MatrizCrucigrama("suma");
            matriz = mat.getMat();
            matrizAux = mat.getMatRes();
        }else if(nivel == 2){
            dir2 = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\3.png";
            dir1 = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\4.png";
            dirFondo = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\fondo1.2.jpg";
            mat = new MatrizCrucigrama("resta");
            matriz = mat.getMat();
            matrizAux = mat.getMatRes();
        }else if(nivel == 3){
            dir2 = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\5.png";
            dir1 = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\6.png";
            dirFondo = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\fondo1.3.jpg";
            mat = new MatrizCrucigrama("multiplicacion");
            matriz = mat.getMat();
            matrizAux = mat.getMatRes();
        }else if(nivel == 4){
            dir2 = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\1.png";
            dir1 = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\2.png";
            dirFondo = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\fondo1.1.jpg";
            mat = new MatrizCrucigrama("division");
            matriz = mat.getMat();
            matrizAux = mat.getMatRes();
        }else{
            dir2 = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\9.png";
            dir1 = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\decorate\\10.png";
            dirFondo = "C:\\Users\\Criss\\Documents\\GitHub\\StarTech\\src\\main\\java\\app\\startech\\imagenes\\fondo1.5.jpg";
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
