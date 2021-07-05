/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.screens;

import app.startech.login.Login;
import app.startech.models.Category;
import app.startech.preguntas.Cuestionario;
import app.startech.preguntas.GrupoPreguntas;
import app.startech.sopa.Ventana;

//import static app.startech.preguntas.Cuestionario.grupos;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static java.awt.BorderLayout.*;

/**
 * @author luzch
 */
public class CategoryScreen extends JFrame {

    private final Category[] categories;

    public CategoryScreen(Category[] categories) {
        this.categories = categories;
        initComponent();
        setLocationRelativeTo(null);
    }

    public Category nextCategory(Category categoria) {
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
        // Esta porción de código sirve para centrar
        setLocationRelativeTo(null);
        // Esta porción de código sirve para que no se cierra el programa cuando se
        // cierra una sola ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        // Se establece el contenedor de los botones
        JPanel buttons = new JPanel(new GridLayout(categories.length / 2, 1));
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
                if (category.getId() != 8) {
                    // onClose();
                    LevelScreen levelScreen = new LevelScreen(category, this);
                    setVisible(false);
                } else {
                    // onClose();
                    Ventana ventana = new Ventana(this);
                    setVisible(false);
                }
            });
            button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            button.setBackground(new java.awt.Color(240, 240, 240));
            button.setFont(new java.awt.Font("Comic Sans MS", 0, 15));
            panel.add(button);
            buttons.add(panel);
            panel.setBackground(new Color(0, 0, 0, 0));
        }
        // Se establece el contenedor de arriba para el titulo con un borde vacio
        JPanel title = new JPanel(new BorderLayout());
        title.setBorder(new EmptyBorder(0, 0, 50, 0));
        title.setBackground(new Color(0, 0, 0, 0));
        // Se establece el contenedor de abajo para los botones atras y realizar test
        // con la dimensión y un borde vacio
        JPanel options = new JPanel(new BorderLayout());
        options.setSize(new Dimension(200, 50));
        options.setBorder(new EmptyBorder(10, 10, 10, 10));
        options.setBackground(new Color(0, 0, 0, 0));
        // Se instancia el boton para hacer el test y su funcionamiento
        JButton startTest = new JButton("Realizar TEST");
        startTest.addActionListener((action) -> {
            Cuestionario test = new Cuestionario();
            setVisible(false);
        });
        startTest.setPreferredSize(new Dimension(200, 50));
        startTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startTest.setBackground(new java.awt.Color(240, 240, 240));
        startTest.setFont(new java.awt.Font("Comic Sans MS", 1, 15));
        options.add(startTest, EAST);
        // Se instancia el boton de atras, que lleva al login
        JButton atras = new JButton("Atras");
        atras.addActionListener((action) -> {
            Login abrir = new Login();
            abrir.setVisible(true);
            setVisible(false);
        });
        atras.setPreferredSize(new Dimension(200, 50));
        atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atras.setBackground(new java.awt.Color(240, 240, 240));
        atras.setFont(new java.awt.Font("Comic Sans MS", 1, 15));
        options.add(atras, WEST);
        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.setBackground(new Color(0, 0, 0, 0));
        // Se estable la ubicación de los distintos contenedores
        mainContainer.add(buttons, CENTER);
        mainContainer.add(options, SOUTH);
        mainContainer.add(title, NORTH);
        ImageIcon imagen = new javax.swing.ImageIcon(getClass().getResource("/app/startech/imagenes/fondo1.1.jpg"));
        JPanel backgroundPanel = new JPanel();
        JLabel background = new JLabel(imagen);
        backgroundPanel.add(background);
        backgroundPanel.setOpaque(false);
        add(mainContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 450));
        add(backgroundPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        setVisible(true);
    }

}
