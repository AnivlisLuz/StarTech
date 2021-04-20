/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.screens;

import app.startech.models.Category;
import app.startech.models.Level;
import data.DataController;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.NORTH;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import preguntas.Cuestionario;
import static preguntas.Cuestionario.grupos;

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

    private void initComponent() {
        setSize(800, 500);
        setTitle("StarTech");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel buttons = new JPanel(new GridLayout(categories.length, 1));
        buttons.setBackground(Color.blue);
        for (Category category : categories) {
            JPanel panel = new JPanel();
            JButton button = new JButton(category.getTitle());
            button.setPreferredSize(new Dimension(200, 50));
            button.setEnabled(category.getActive());
            button.addActionListener((action) -> {
                LevelScreen levelScreen = new LevelScreen(category);
            });
            panel.add(button);
            buttons.add(panel);
            panel.setBackground(new Color(0, 0, 0, 0));
        }

        JPanel title = new JPanel(new BorderLayout());
        title.setBorder(new EmptyBorder(0, 0, 50, 0));

        JPanel options = new JPanel(new BorderLayout());
        options.setSize(new Dimension(200, 50));
        options.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton buton = new JButton("Realizar TEST");
        buton.addActionListener((action) -> {
            Cuestionario test = new Cuestionario(grupos);
        });
        buton.setPreferredSize(new Dimension(200, 50));
        options.add(buton, EAST);

        add(buttons, CENTER);
        add(options, SOUTH);
        add(title, NORTH);

        setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            CategoryScreen categoryScreen = new CategoryScreen(DataController.exampleCategory);
        });
    }
}
