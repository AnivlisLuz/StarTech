/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.screens;

import app.startech.imagenes.Images;
import app.startech.models.Category;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.*;

import static java.awt.BorderLayout.*;

/**
 *
 * @author luzch
 */
public class LearningScreen extends javax.swing.JFrame {

    private String title;
    private String content;
    private BufferedImage iconOp;
    private String image;
    private Category category;
    private CategoryScreen ventanaCategorias;

    public LearningScreen(Category category, CategoryScreen ventanaCategorias) {
        title = category.getTitle();
        content = category.getContent();
        iconOp = Images.getDivision();
        image = category.getImage();
        this.ventanaCategorias = ventanaCategorias;
        this.category = category;
        initComponent();

        playSound("https://www2.cs.uic.edu/~i101/SoundFiles/StarWars60.wav", false);
    }

    private void initComponent() {
        setSize(800, 500);
        setTitle("StarTech");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel titleContainer = new JPanel();
        JLabel titulo = new JLabel(title);
        titulo.setFont(new Font(titulo.getFont().getFamily(), titulo.getFont().getStyle(), 20));
        titleContainer.setBorder(new EmptyBorder(10, 10, 10, 10));
        titleContainer.add(titulo);

        JPanel centralContainer = new JPanel();
        JPanel contentContainer = new JPanel();
        contentContainer.setLayout(new BorderLayout());
        centralContainer.add(contentContainer, NORTH);
        JTextArea contenido = new JTextArea(content);
        contenido.setWrapStyleWord(true);
        contenido.setLineWrap(true);
        contenido.setEditable(false);
        contenido.setSize(new Dimension(600, 10));
        contenido.setBorder(new EmptyBorder(0, 00, 0, 0));

        contenido.setFont(new Font(contenido.getFont().getFamily(), contenido.getFont().getStyle(), 15));
        contentContainer.add(contenido, CENTER);
        JLabel icon = new JLabel();
        icon.setBorder(new EmptyBorder(0, 0, 0, 00));
        icon.setIcon(new javax.swing.ImageIcon(iconOp));
        contentContainer.add(icon, EAST);

        JPanel imageContainer = new JPanel();
        centralContainer.add(imageContainer, SOUTH);
        JLabel gifCointainer = new JLabel();
        gifCointainer.setBorder(new EmptyBorder(0, 500, 0, 500));
        try {
            gifCointainer.setIcon(new javax.swing.ImageIcon(new URL(image)));
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        imageContainer.add(gifCointainer);

        JPanel optionsContainer = new JPanel();
        optionsContainer.setSize(new Dimension(200, 50));
        optionsContainer.setBorder(new EmptyBorder(10, 10, 10, 10));
        JButton atras = new JButton("Atras");
        atras.addActionListener((action) -> {
            onClose();
            dispose();
            ventanaCategorias.setVisible(true);
        });
        atras.setPreferredSize(new Dimension(150, 50));
        optionsContainer.add(atras, WEST);
        JButton start = new JButton("Jugar");
        start.addActionListener((action) -> {
            onClose();
            // LevelScreen levelScreen = new LevelScreen(category, this);
            setVisible(false);
        });
        start.setPreferredSize(new Dimension(150, 50));
        optionsContainer.add(start, EAST);

        add(titleContainer, NORTH);
        add(centralContainer, CENTER);
        add(optionsContainer, SOUTH);

        setVisible(true);
        playSound("https://file-examples-com.github.io/uploads/2017/11/file_example_WAV_1MG.wav", true);
    }

    private ArrayList<Clip> audios = new ArrayList();

    private void playSound(String url, boolean loop) {

        try {

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new URL(url));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            if (loop)
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            audios.add(clip);
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    private void onClose() {
        for (Clip clip : audios) {
            try {
                clip.stop();
            } catch (Exception ex) {
            }
        }
    }
}
