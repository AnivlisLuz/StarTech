
package Crucigrama;

import javax.swing.JTextField;

public class Celda {
    private JTextField a;
    private int i;
    private int j;
    
    public Celda(JTextField a, int i, int j){
        this.a = a;
        this.i = i;
        this.j = j;
    }

    public JTextField getA() {
        return a;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
    
    
}
