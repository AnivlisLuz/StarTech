/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.screens;

import app.startech.models.Category;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static java.awt.BorderLayout.*;

/**
 *
 * @author luzch
 */
public class LearningScreen extends javax.swing.JFrame {

    private String title;
    private Category category;
    private CategoryScreen ventanaCategorias;
    
    public LearningScreen(Category category, CategoryScreen ventanaCategoria){
        
        title = category.getTitle();
        this.ventanaCategorias = ventanaCategorias;
        this.category = category;
        initComponent();
    
    }

    private void initComponent() {
        setSize(800,500);
        setTitle("StarTech");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel titleContainer = new JPanel();
        JLabel titulo = new JLabel(title);
        titulo.setFont(new Font(titulo.getFont().getFamily(), titulo.getFont().getStyle(), 20));
        titleContainer.setBorder(new EmptyBorder(10, 10, 10, 10));        
        titleContainer.add(titulo);

        JPanel imageContainer = new JPanel();
        JPanel optionsContainer = new JPanel();
        optionsContainer.setSize(new Dimension(200, 50));
        optionsContainer.setBorder(new EmptyBorder(10, 10, 10, 10));
        JButton atras = new JButton("Atras");
        atras.addActionListener((action) -> {
            dispose();
            ventanaCategorias.setVisible(true);
        });
        atras.setPreferredSize(new Dimension(200, 50));
        optionsContainer.add(atras, WEST);
        JButton start = new JButton("Jugar");
        start.addActionListener((action) -> {
       //     LevelScreen levelScreen = new LevelScreen(category, this);
            setVisible(false);
        });
        start.setPreferredSize(new Dimension(200, 50));
        optionsContainer.add(start, EAST);


        add(titleContainer, NORTH);
        add(imageContainer,CENTER);
        add(optionsContainer, SOUTH);

        setVisible(true);
    }
}
