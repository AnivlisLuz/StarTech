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
import javax.swing.JOptionPane;

    
public class Boton extends JButton implements ActionListener {
    
    private Punto p;
    private Matriz matriz;
    private String[] mensajeContinuar = {"Continuar"};
    private String[] mensajeGameOver = {"Menú", "Volver a Intentar"};
    
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
            if(p.igual(matriz.getMeta())){
                int i = JOptionPane.showOptionDialog(null, "Lo lograste!!!", "StarTech", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, mensajeContinuar, mensajeContinuar[0]);
                if(i==0){
                    //Siguinte nivel 
                }
            }
        }else{
            setBackground(Color.red);
            int i = JOptionPane.showOptionDialog(null, "Game Over", "StarTech", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, mensajeGameOver, mensajeGameOver[0]);
                if(i==0){
                    //Menú principal
                }else{
                    //Reiniciar juego, mismo laberinto, menos vidas
//                    if(vidas == 0){
//                        nuevo laberinto
//                    }else{
//                        vidas--;
//                        mismo laberinto, desde el inicio  
//                    }
                }
        }
    }
}
