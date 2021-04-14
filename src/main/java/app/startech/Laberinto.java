package app.startech;


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
            if(nivel == 1){
                matriz = new Secuencia(3, 1);
                matriz.generarLaberinto();
                matriz.rellenarLaberinto();
            }
        }
    }
    public int[][] getLaberinto(){
        return matriz.getLaberinto();
    }
}
