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
    
    public Category nexCategory(Category categoria){
        Category res = null;
        for(int i= 0; i < categories.length ; i++){
            Category cat = categories[i];
            if(categoria.equals(cat)){
                if(i+1 == categories.length){
                    res = null;
                }else{
                res = categories[i+1]; 
                }
                break;
            }
        }
        return res;
    }
    
    public void refresh(){
        initComponent();
    }
    public void setCategories(){
        
    }
    private void initComponent() {
        setSize(800, 500);
        setTitle("StarTech");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel buttons = new JPanel(new GridLayout(categories.length, 1));
        buttons.setBackground(Color.blue);
        for (Category category : categories) {
            JPanel panel = new JPanel();
            JButton button = new JButton(category.getTitle());
            button.setPreferredSize(new Dimension(200, 50));
            button.setEnabled(category.getActive());
            button.addActionListener((action) -> {
                LevelScreen levelScreen = new LevelScreen(category, this);
                setVisible(false);
            });
            panel.add(button);
            buttons.add(panel);
            panel.setBackground(new Color(0, 0, 0, 0));
        };

        JPanel title = new JPanel(new BorderLayout());
        title.setBorder(new EmptyBorder(0, 0, 50, 0));

        JPanel options = new JPanel(new BorderLayout());
        options.setSize(new Dimension(200, 50));
        options.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton buton = new JButton("Realizar TEST");
        buton.addActionListener((action) -> {
            GrupoPreguntas.showQuestionary();
            setVisible(false);
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
            DataController.secuencia.setActive(true);
            CategoryScreen categoryScreen = new CategoryScreen(DataController.getAllCategories());
        });
    }
}
