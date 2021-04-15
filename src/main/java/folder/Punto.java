
package folder;

public class Punto {
    private int x;
    private int y;
    
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean igual(Punto a){
        boolean res = false;
        if(x == a.getX() && y == a.getY()){
            res = true;
        }
        return res;
    }
}
