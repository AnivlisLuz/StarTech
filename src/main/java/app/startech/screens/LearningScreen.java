/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.screens;

import app.startech.models.Category;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import static java.awt.BorderLayout.*;

/**
 *
 * @author luzch
 */
public class LearningScreen extends GamePanel {
    private Category category;
    private String title;
    private String audio;
    private String content;
    private BufferedImage iconOp;
    private String image;
    private LevelScreen ventanaCategorias;

    public LearningScreen(Category category, LevelScreen ventanaCategorias) {
        this.category = category;
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
        setSize(800, 540);
        setTitle("StarTech");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        JPanel titleContainer = new JPanel();
        JLabel titulo = new JLabel(title);
        titulo.setFont(new java.awt.Font("Impact", 1, 38));
        titleContainer.setBorder(new EmptyBorder(0, 0, 0, 0));

        titleContainer.setBackground(new Color(0, 0, 0, 0));
        titleContainer.add(titulo);

        JPanel centralContainer = new JPanel();

        centralContainer.setBackground(new Color(0, 0, 0, 0));
        JPanel contentContainer = new JPanel();

        contentContainer.setBackground(new Color(0, 0, 0, 0));
        contentContainer.setLayout(new BorderLayout());
        centralContainer.add(contentContainer, NORTH);
        JTextArea contenido = new JTextArea(content);
        contenido.setBackground(new Color(0, 0, 0, 0));
        contenido.setWrapStyleWord(true);
        contenido.setLineWrap(true);
        contenido.setEditable(false);
        contenido.setSize(new Dimension(610, 10));
        contenido.setBorder(new EmptyBorder(0, 0, 0, 0));

        contenido.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
        contentContainer.add(contenido, CENTER);
        JLabel icon = new JLabel();
        icon.setBorder(new EmptyBorder(0, 0, 0, 0));
        if (iconOp != null)
            icon.setIcon(new ImageIcon(iconOp));
        contentContainer.add(icon, EAST);

        JPanel imageContainer = new JPanel();
        centralContainer.add(imageContainer, SOUTH);
        JLabel gifCointainer = new JLabel();
        gifCointainer.setBorder(new EmptyBorder(0, 100, 0, 100));
        gifCointainer.setIcon(new ImageIcon(getClass().getResource(image)));

        imageContainer.setBackground(new Color(0, 0, 0, 0));
        imageContainer.add(gifCointainer);

        JPanel optionsContainer = new JPanel();

        optionsContainer.setBackground(new Color(0, 0, 0, 0));
        optionsContainer.setSize(new Dimension(600, 40));
        optionsContainer.setBorder(new EmptyBorder(0, 0, 0, 0));
        JButton atras = new JButton("Atras");
        atras.addActionListener((action) -> {
            onClose();
            dispose();
            ventanaCategorias.setVisible(true);
        });
        atras.setPreferredSize(new Dimension(200, 40));
        atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atras.setBackground(new java.awt.Color(240, 240, 240));
        atras.setFont(new java.awt.Font("Comic Sans MS", 1, 15));
        optionsContainer.add(atras, WEST);

        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.setBackground(new Color(100, 100, 100, 0));
        mainContainer.add(titleContainer, NORTH);
        mainContainer.add(centralContainer, CENTER);
        mainContainer.add(optionsContainer, SOUTH);

        ImageIcon imagen = new javax.swing.ImageIcon(getClass().getResource("/app/startech/imagenes/fondo1.1.jpg"));
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(100, 100, 100, 50));

        JLabel background = new JLabel(imagen);
        mainPanel.add(background);
        mainPanel.setOpaque(false);

        add(mainContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));
        add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        setVisible(true);
        playSound("/app/startech/resources/fondo.wav", true);

    }

    private ArrayList<Clip> audios = new ArrayList();

    private void playSound(String url, boolean loop) {

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(url));
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

class GamePanel extends JFrame implements ActionListener {

    Timer timer = new Timer(0, this);

    public GamePanel() {
        timer.start();// Start the timer here.
    }

    public void actionPerformed(ActionEvent ev) {
        repaint();

    }
}