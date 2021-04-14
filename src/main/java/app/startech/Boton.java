package app.startech;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

    
public class Boton extends JButton implements ActionListener {
    
    
    public Boton(int posx, int posy, int ancho, int alto){
        setBounds(posx, posy, ancho, alto);
        addActionListener(this);
    }
    
    public void cambiarNombre(String nombre){
        setText(nombre);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setBackground(Color.red);
    }
}
