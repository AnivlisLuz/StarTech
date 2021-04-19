/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

    
public class Boton extends JButton implements ActionListener {
    
    private Punto p;
    private Matriz matriz;
    
    public Boton(int posx, int posy, int ancho, int alto, Matriz matriz, int i, int j){
        setBounds(posx, posy, ancho, alto);
        addActionListener(this);
        this.matriz = matriz;
        p = new Punto(i, j);
    }
    
    public void cambiarNombre(String nombre){
        setText(nombre);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean correcto = matriz.verificarMovimiento(p);
        if(correcto){
            setBackground(Color.GREEN);
        }else{
            setBackground(Color.red);
        }
    }
}
