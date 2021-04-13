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
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.WEST;
import static java.awt.BorderLayout.SOUTH;
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
public class LevelScreen extends javax.swing.JFrame {

    private final String title;
    private final Level[] levels;

    public LevelScreen(String title, Level[] levels) {
        this.levels = levels;
        this.title = title;
        initComponent();
    }

    private void initComponent() {
        setSize(800, 500);
        setTitle("StarTech");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel buttons = new JPanel(new GridLayout(levels.length, 1));
        
        for (Level level : levels) {
            JPanel panel = new JPanel();
            JButton button = new JButton(level.getTitle());
            button.setPreferredSize(new Dimension(200, 50));
            panel.add(button);
            buttons.add(panel);
        }
        
        JPanel options = new JPanel(new BorderLayout());
        options.setSize(new Dimension(200, 50));
        options.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JButton buton = new JButton("Atras");        
        buton.setPreferredSize(new Dimension(200, 50));        
        options.add(buton, WEST);
        
        JPanel titleContainer = new JPanel ();
        JLabel titulo = new JLabel(title);
        titleContainer.add(titulo);
        
        add(titleContainer,NORTH);
        add(buttons, CENTER);
        add(options, SOUTH);
        
        setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LevelScreen levelScreen = new LevelScreen("Secuencia de números",new Level[]{
                    new Level(1, "1 al 9"), 
                    new Level(2, "1 al 20"),
                    new Level(3, "1 al 30"),
                    new Level(4, "1 al 40"),
                    new Level(5, "1 al 50")
                });
            }
        });
    }
}
