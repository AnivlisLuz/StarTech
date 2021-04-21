/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import app.startech.models.Category;
import app.startech.models.Level;
import app.startech.screens.CategoryScreen;
import app.startech.screens.LevelScreen;
import data.DataController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

    
public class Boton extends JButton implements ActionListener {
    
    private Punto p;
    private Laberinto l;
    private String[] mensajeContinuar = {"Continuar"};
    private String[] mensajeGameOver = {"Menú", "Volver a Intentar"};
    private Category categoria;
    private Level level;
    private VentanaLaberinto ventana;
    private LevelScreen ventanaLevel;
    private CategoryScreen ventanaCategoria;
    
    public Boton(int posx, int posy, int ancho, int alto, Laberinto l, int i, int j, Category c, Level level, VentanaLaberinto ventana, CategoryScreen ventanaCategoria, LevelScreen ventanaLevel){
        setBounds(posx, posy, ancho, alto);
        this.ventanaLevel = ventanaLevel;
        this.ventanaCategoria = ventanaCategoria;
        categoria = c;
        this.level = level;
        this.ventana = ventana;
        addActionListener(this);
        this.l = l;
        p = new Punto(i, j);
    }

    public void cambiarNombre(String nombre){
        setText(nombre);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean correcto = l.getMatriz().verificarMovimiento(p);
        if(correcto){
            setBackground(Color.GREEN);
            if(p.igual(l.getMatriz().getMeta())){
                int i = JOptionPane.showOptionDialog(null, "Lo lograste!!!", "StarTech", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, mensajeContinuar, mensajeContinuar[0]);
                if(i==0){
                    //Siguinte nivel 
                    Level sig = categoria.nextLevel(level);
                    if(sig != null){
                        sig.setActive();
                        ventanaLevel.dispose();
                        ventanaLevel = new LevelScreen(categoria, ventanaCategoria);
                        ventanaLevel.setVisible(false);
                        new VentanaLaberinto(categoria, sig, ventanaLevel, ventanaCategoria).setVisible(true);
                    }else{
                        // Siguiente Categoria
                        Category cat = ventanaCategoria.nexCategory(categoria);
                        cat.setActive();
                        //ventanaCategoria.refresh();
                    }
                    ventana.dispose();
                }
            }
        }else{
            setBackground(Color.red);
            int i = JOptionPane.showOptionDialog(null, "Game Over", "StarTech", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, mensajeGameOver, mensajeGameOver[0]);
                if(i==0){
                    //Menú principal
                    ventanaLevel.setVisible(true);
                    ventana.dispose();
                }else{
                    ventana.refresh();
//                   //Reiniciar juego, mismo laberinto, menos vidas
//                    if(vidas == 0){
// //                      nuevo laberinto
//                   }else{
//                        //levelvidas--;
// //                       mismo laberinto, desde el inicio  
//                        
//                   }
                }
        }
    }
}
