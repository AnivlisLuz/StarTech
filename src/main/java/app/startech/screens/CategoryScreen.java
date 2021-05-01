/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.screens;

import app.startech.models.Category;
import forms.Login;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.WEST;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import preguntas.GrupoPreguntas;

/**
 *
 * @author luzch
 */
public class CategoryScreen extends javax.swing.JFrame {

    private final Category[] categories;

    public CategoryScreen(Category[] categories) {
        this.categories = categories;
        initComponent();
        setLocationRelativeTo(null);
    }

    public Category nexCategory(Category categoria) {
        Category res = null;
        for (int i = 0; i < categories.length; i++) {
            Category cat = categories[i];
            if (categoria.equals(cat)) {
                if (i + 1 == categories.length) {
                    res = null;
                } else {
                    res = categories[i + 1];
                }
                break;
            }
        }
        return res;
    }

    public void setCategories() {

    }

    private void initComponent() {
        // Se coloca el tamaño de la pantalla por defecto
        setSize(800, 500);
        // Se configura el titulo
        setTitle("StarTech");
        //Esta porción de código sirve para centrar
        setLocationRelativeTo(null);
        //Esta porción de código sirve para que no se cierra el programa cuando se cierra una sola ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se establece el contenedor de los botones
        JPanel buttons = new JPanel(new GridLayout(categories.length, 1));
        buttons.setBackground(new Color(0, 0, 0, 0));
        // Se itera categorias
        for (Category category : categories) {
            // Se crea una nueva instancia de panel
            JPanel panel = new JPanel();
            // Se coloca el titulo de categoria al boton
            JButton button = new JButton(category.getTitle());
            button.setPreferredSize(new Dimension(200, 50));
            // Habilita y deshabilita según la categoria
            button.setEnabled(category.getActive());
            // Se ejecuta la accion al hacer click
            button.addActionListener((action) -> {
                LevelScreen levelScreen = new LevelScreen(category, this);
                setVisible(false);
            });
            
            panel.add(button);
            buttons.add(panel);
            panel.setBackground(new Color(0, 0, 0, 0));
        }
        // Se establece el contenedor de arriba para el titulo con un borde vacio
        JPanel title = new JPanel(new BorderLayout());
        title.setBorder(new EmptyBorder(0, 0, 50, 0));
        // Se establece el contenedor de abajo para los botones atras y realizar test con la dimensión y un borde vacio
        JPanel options = new JPanel(new BorderLayout());
        options.setSize(new Dimension(200, 50));
        options.setBorder(new EmptyBorder(10, 10, 10, 10));
        // Se instancia el boton para hacer el test y su funcionamiento
        JButton startTest = new JButton("Realizar TEST");
        startTest.addActionListener((action) -> {
            GrupoPreguntas.showQuestionary();
            setVisible(false);
        });
        startTest.setPreferredSize(new Dimension(200, 50));
        options.add(startTest, EAST);
        // Se instancia el boton de atras, que lleva al login
        JButton atras = new JButton("Atras");
        atras.addActionListener((action) -> {
            Login abrir = new Login();
            abrir.setVisible(true);
            setVisible(false);
        });
        atras.setPreferredSize(new Dimension(200, 50));
        options.add(atras, WEST);
        // Se estable la ubicación de los distintos contenedores
        add(buttons, CENTER);
        add(options, SOUTH);
        add(title, NORTH);

        setVisible(true);
    }

}
