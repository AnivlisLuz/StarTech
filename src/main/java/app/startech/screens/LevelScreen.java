/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.screens;

import app.startech.crucigrama.VentanaCrucigrama1;
import app.startech.laberintos.VentanaLaberinto;
import app.startech.models.Category;
import app.startech.models.Level;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import app.startech.Convinados.VentanaCombinado;
import app.startech.Convinados.VentanaCombinado1;
import app.startech.crucigrama.VentanaCrucigrama;

import java.awt.*;

import static java.awt.BorderLayout.*;

/**
 * @author luzch
 */
public class LevelScreen extends JFrame {

    private final String title;
    private final Level[] levels;
    private final Category category;
    private final CategoryScreen ventanaCategorias;

    public LevelScreen(Category category, CategoryScreen ventanaCategorias) {
        levels = category.getLevels();
        title = category.getTitle();
        this.ventanaCategorias = ventanaCategorias;
        this.category = category;
        initComponent();
        setLocationRelativeTo(null);
    }

    private void initComponent() {
        // Se coloca el tamaño de la pantalla por defecto
        setSize(800, 500);
        // Se configura el titulo
        setTitle("StarTech");
        // Esta porción de código sirve para centrar
        setLocationRelativeTo(null);
        // Esta porción de código sirve para que no se cierra el programa cuando se
        // cierra una sola ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se establece la distribución de los botones
        JPanel buttons = new JPanel(new GridLayout(levels.length <= 5 ? levels.length : levels.length / 2, 1));
        // Se itiera los niveles, intanciando un panel, ponendo titulo a cada boton y
        // estableciendo una dimensión
        for (Level level : levels) {
            JPanel panel = new JPanel();
            JButton button = new JButton(level.getTitle());
            button.setPreferredSize(new Dimension(200, 50));
            button.setEnabled(level.active());
            button.addActionListener((action) -> {
                if (category.getId() == 6) {
                    new VentanaCrucigrama(category, level, this, ventanaCategorias).setVisible(true);
                    setVisible(false);
                } else if (category.getId() == 7) {
                    new VentanaCombinado1(category, level, this, ventanaCategorias).setVisible(true);
                    setVisible(false);
                } else {
                    new VentanaLaberinto(category, level, this, ventanaCategorias).setVisible(true);
                    setVisible(false);
                }

            });
            panel.add(button);
            buttons.add(panel);
        }
        // Se estableceel contenedor de abajo para el boton de Atras, con dimensión y
        // borde vacio.
        JPanel options = new JPanel(new BorderLayout());
        options.setSize(new Dimension(200, 50));
        options.setBorder(new EmptyBorder(10, 10, 10, 10));
        // Se instancia el boton de atras, que lleva a la ventana de categorias
        JButton buton = new JButton("Atras");
        buton.addActionListener((action) -> {
            dispose();
            ventanaCategorias.setVisible(true);
        });
        buton.setPreferredSize(new Dimension(200, 50));
        options.add(buton, WEST);
        // Se establece el contenedor de arriba para el titulo dando un tamaño y un
        // borde vacio
        JPanel titleContainer = new JPanel();
        JLabel titulo = new JLabel(title);
        titulo.setFont(new Font(titulo.getFont().getFamily(), titulo.getFont().getStyle(), 20));
        titleContainer.setBorder(new EmptyBorder(10, 10, 10, 10));
        titleContainer.add(titulo);
        // se estable la ubicación de los distintos contenedores
        add(titleContainer, NORTH);
        add(buttons, CENTER);
        add(options, SOUTH);

        setVisible(true);

    }
}
