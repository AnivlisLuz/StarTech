
package folder;

public abstract class Matriz {
    private int[][] matriz;
    private int[][] laberinto;
    private Punto   inicio;
    private Punto   meta;
    private Punto[] camino;
    private int pos;
    
    public Matriz(int tamaño){
        matriz = new int[tamaño][tamaño];
        laberinto = new int[tamaño][tamaño];
        inicio = null; meta = null;
        camino = new Punto[]{new Punto(0,0), new Punto(0, 1), new Punto(0, 2), new Punto(1, 0), new Punto(1, 2), new Punto(2, 0), new Punto(2, 2)};
        //camino = new ArrayList<Punto>();
        pos = 0;
    }
    
    public boolean verificarMovimiento(Punto p){
        Punto a = camino[pos];
        boolean res = false;
        if(p.igual(a)){
            res = true;
            pos++;
        }else{
            res = false;
        }
        return res;
    }
    abstract public void rellenarLaberinto();
    
    public void generarLaberinto(){
    
    }
    public void generarInicioMeta(){
    
    }
    public int[][] getLaberinto(){
        int[][] laberinto = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 0, 1}
        };
        return laberinto;
    }
    public Punto[] getCamino(){
        return camino;
    }
}
