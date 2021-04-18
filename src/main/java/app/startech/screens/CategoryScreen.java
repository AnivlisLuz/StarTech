/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.screens;

import app.startech.models.Category;
import app.startech.models.Level;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.NORTH;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
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
            button.setEnabled(category.getActive());
            button.addActionListener((action)->{
            LevelScreen levelScreen = new LevelScreen(category.getTitle(), category.getLevels());
            });
            panel.add(button);
            buttons.add(panel);
        }

        JPanel title = new JPanel(new BorderLayout());
        title.setBorder(new EmptyBorder(0, 0, 50, 0));

        JPanel options = new JPanel(new BorderLayout());
        options.setSize(new Dimension(200, 50));
        options.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton buton = new JButton("Realizar TEST");
        buton.setPreferredSize(new Dimension(200, 50));
        options.add(buton, EAST);

        add(buttons, CENTER);
        add(options, SOUTH);
        add(title, NORTH);

        setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CategoryScreen categoryScreen = new CategoryScreen(new Category[]{
                    new Category(1, "Secuencia de números", true, new Level[]{
                        new Level(1, "1 al 9", true),
                        new Level(2, "1 al 20", false),
                        new Level(3, "1 al 30", false),
                        new Level(4, "1 al 40", false),
                        new Level(5, "1 al 50", false)
                    }),
                    new Category(2, "Suma", true, new Level[]{
                        new Level(1, "1 al 14", true),
                        new Level(2, "1 al 50", false),
                        new Level(3, "1 al 30", false),
                        new Level(4, "1 al 40", false),
                        new Level(5, "1 al 50", false)
                    }),
                    new Category(3, "Resta", false, new Level[]{
                        new Level(1, "1 al 9", true),
                        new Level(2, "1 al 20", false),
                        new Level(3, "1 al 30", false),
                        new Level(4, "1 al 40", false),
                        new Level(5, "1 al 50", false)
                    }),
                    new Category(4, "Multiplicación", false, new Level[]{
                        new Level(1, "1 al 9", true),
                        new Level(2, "1 al 20", false),
                        new Level(3, "1 al 30", false),
                        new Level(4, "1 al 40", false),
                        new Level(5, "1 al 50", false)
                    }),
                    new Category(5, "División", false, new Level[]{
                        new Level(1, "1 al 9", true),
                        new Level(2, "1 al 20", false),
                        new Level(3, "1 al 30", false),
                        new Level(4, "1 al 40", false),
                        new Level(5, "1 al 50", false)
                    })
                });
            }
        });
    }
}
