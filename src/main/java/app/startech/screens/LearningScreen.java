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
    private String audio;
    private String content;
    private BufferedImage iconOp;
    private String image;
    private CategoryScreen ventanaCategorias;

    public LearningScreen(Category category, CategoryScreen ventanaCategorias) {
        title = category.getTitle();
        audio = category.getAudio();
        content = category.getContent();
        iconOp = category.getIcon();
        image = category.getImage();
        this.ventanaCategorias = ventanaCategorias;
        initComponent();

        playSound(audio, false);
    }

    private void initComponent() {
        setSize(800, 500);
        setTitle("StarTech");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel titleContainer = new JPanel();
        JLabel titulo = new JLabel(title);
        titulo.setFont(new Font(titulo.getFont().getFamily(), titulo.getFont().getStyle(), 30));
        titleContainer.setBorder(new EmptyBorder(0, 0, 0, 0));
        titleContainer.add(titulo);

        JPanel centralContainer = new JPanel();
        JPanel contentContainer = new JPanel();
        contentContainer.setLayout(new BorderLayout());
        centralContainer.add(contentContainer, NORTH);
        JTextArea contenido = new JTextArea(content);
        contenido.setBackground(new Color(0, 0, 0, 0));
        contenido.setWrapStyleWord(true);
        contenido.setLineWrap(true);
        contenido.setEditable(false);
        contenido.setSize(new Dimension(600, 10));
        contenido.setBorder(new EmptyBorder(0, 0, 0, 20));

        contenido.setFont(new Font(contenido.getFont().getFamily(), contenido.getFont().getStyle(), 20));
        contentContainer.add(contenido, CENTER);
        JLabel icon = new JLabel();
        icon.setBorder(new EmptyBorder(0, 0, 0, 20));
        if (iconOp != null)
            icon.setIcon(new javax.swing.ImageIcon(iconOp));
        contentContainer.add(icon, EAST);

        JPanel imageContainer = new JPanel();
        centralContainer.add(imageContainer, SOUTH);
        JLabel gifCointainer = new JLabel();
        gifCointainer.setBorder(new EmptyBorder(0, 100, 0, 100));
        try {
            gifCointainer.setIcon(new javax.swing.ImageIcon(new URL(image)));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        imageContainer.add(gifCointainer);

        JPanel optionsContainer = new JPanel();
        optionsContainer.setSize(new Dimension(600, 40));
        optionsContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
        JButton atras = new JButton("Atras");
        atras.addActionListener((action) -> {
            onClose();
            dispose();
            ventanaCategorias.setVisible(true);
        });
        atras.setPreferredSize(new Dimension(200, 40));
        optionsContainer.add(atras, WEST);
        JButton start = new JButton("Jugar");
        start.addActionListener((action) -> {
            onClose();
            // LevelScreen levelScreen = new LevelScreen(category, this);
            setVisible(false);
        });
        start.setPreferredSize(new Dimension(200, 40));
        optionsContainer.add(start, EAST);

        add(titleContainer, NORTH);
        add(centralContainer, CENTER);
        add(optionsContainer, SOUTH);

        setVisible(true);
        playSound("https://github.com/AnivlisLuz/StarTech/releases/download/gifs/fondo.wav", true);
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
