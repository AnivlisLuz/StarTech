/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.screens;

import app.startech.models.Category;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author luzch
 */
public class CategoryScreen extends javax.swing.JFrame {

    private final Category[] categories;

    public CategoryScreen(Category[] categories) {
        this.categories = categories;
        initComponent();
    }

    private void initComponent() {
        setSize(800, 500);
        setTitle("StarTech");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel buttons = new JPanel(new GridLayout(categories.length, 1));
        
        for (Category category : categories) {
            JPanel panel = new JPanel();
            JButton button = new JButton(category.getTitle());
            button.setPreferredSize(new Dimension(200, 50));
            panel.add(button);
            buttons.add(panel);
        }
        
        JPanel options = new JPanel(new BorderLayout());
        options.setSize(new Dimension(200, 50));
        options.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JButton buton = new JButton("Realizar TEST");        
        buton.setPreferredSize(new Dimension(200, 50));        
        options.add(buton, EAST);
        
        add(buttons, CENTER);
        add(options, SOUTH);
        
        setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CategoryScreen categoryScreen = new CategoryScreen(new Category[]{
                    new Category(1, "Secuencia de números"),
                    new Category(2, "Suma"),
                    new Category(3, "Resta"),
                    new Category(4, "Multiplicación"),
                    new Category(5, "División")
                });
            }
        });
    }
}
