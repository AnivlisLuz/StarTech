package app.startech.laberintos;

import app.startech.data.DataController;
import app.startech.matriz.Punto;
import app.startech.models.Category;
import app.startech.models.Level;
import app.startech.screens.CategoryScreen;
import app.startech.screens.LevelScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boton extends JButton implements ActionListener {

    private final String[] mensajeContinuar = {"Continuar"};//Mensaje/Boton cuando el usuario completa un laberinto
    private final String[] mensajeSinVidas = {"Menú"};//Mensaje/Boton para ir al menú de niveles
    private final String[] mensajeGameOver = {"Menú", "Volver a Intentar"};//Mesaje/Boton para ir al menú de niveles o para reiniciar el laberinto
    private final Punto p;
    private final Laberinto l;
    private final Category categoria;
    private final Level level;
    private final VentanaLaberinto ventana;
    private LevelScreen ventanaLevel;
    private CategoryScreen ventanaCategoria;

    public Boton(int posx, int posy, int ancho, int alto, Laberinto l, int i, int j, Category c, Level level, VentanaLaberinto ventana, CategoryScreen ventanaCategoria, LevelScreen ventanaLevel) {
        setBounds(posx, posy, ancho, alto);//posicion y tamaño del boton
        this.ventanaLevel = ventanaLevel;
        this.ventanaCategoria = ventanaCategoria;
        categoria = c;
        this.level = level;
        this.ventana = ventana;
        addActionListener(this);
        this.l = l;
        p = new Punto(i, j);
    }

    //Método para cambiar el texto del botón
    public void cambiarNombre(String nombre) {
        setText(nombre);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean correcto = l.getMatriz().verificarMovimiento(p); //Se verifica si el movimiento del usuario es correcto
        if (correcto) {
            setBackground(Color.GREEN); //button de color verde
            if (p.igual(l.getMatriz().getMeta())) { //si la posicion actual es la meta
                int i = JOptionPane.showOptionDialog(null, "Lo lograste!!!", "StarTech", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, mensajeContinuar, mensajeContinuar[0]);
                if (i == 0) {
                    //Siguinte nivel 
                    Level sig = categoria.nextLevel(level);
                    if (sig != null) { //si el siguiente nivel es distinto de null
                        sig.setActive(); //el button (nivel) se activa
                        java.awt.EventQueue.invokeLater(new Runnable() { //nuevo hilo
                            public void run() {
                                ventanaCategoria = new CategoryScreen(DataController.instance.getUsuarioActual().category.getAllCategories());
                                ventanaCategoria.setVisible(false);
                                ventanaLevel = new LevelScreen(categoria, ventanaCategoria);
                            }
                        });
                    } else { //el siguiente nivel es null, entonces se le activa la siguiente categoría
                        // Siguiente Categoria
                        Category cat = ventanaCategoria.nexCategory(categoria);
                        if (cat != null) { //la siguiente categoria es distinto de null
                            java.awt.EventQueue.invokeLater(new Runnable() {//nuevo hilo
                                public void run() {
                                    cat.setActive(true); //se le activa esa siguiente categoria
                                    cat.getLevels()[0].setActive(); //se le activa el primer nivel de la siguiente categoria
                                    new CategoryScreen(DataController.instance.getUsuarioActual().category.getAllCategories());
                                }
                            });
                        } else { //la siguiente categoria es null, quiere decir que acabo con todas las categorias
                            JOptionPane.showMessageDialog(null, "Felicidad!!! Ganaste");
                            ventanaCategoria.setVisible(true);
                            //System.exit(0); 
                        }
                    }
                    ventana.dispose(); //Se cierra la ventana del laberinto
                }
            }
        } else { // el movimiento del usuario es incorrecto
            setBackground(Color.red); //button de color rojo
            if (l.getVidas() == 0) { //Si el usuario ya no tiene vidas
                //ir a Menú
                int j = JOptionPane.showOptionDialog(null, "ohh no!!! ya no tienes vidas", "Game Over", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, mensajeSinVidas, mensajeSinVidas[0]);
                if (j == 0) {
                    ventanaLevel.setVisible(true); //Se muestra la ventana de niveles
                    ventana.dispose();  //Se cierra la ventana del laberinto
                    l.restaurarVidas(); //Se restaura las vidas del usuario
                }
            } else { //El usuario todavia tiene vidas
                int i = JOptionPane.showOptionDialog(null, "Vamos!!! tú puedes", "StarTech", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, mensajeGameOver, mensajeGameOver[0]);
                if (i == 0) {
                    //Menú principal
                    ventanaLevel.setVisible(true);
                    ventana.dispose();
                    l.restaurarVidas();
                } else {
                    //volver a intentar
                    ventana.refresh();
                    ventana.ocultarVida();
                    l.setVidas();

                }
            }
        }
    }
}
