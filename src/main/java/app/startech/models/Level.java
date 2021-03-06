/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.models;

import app.startech.laberintos.Laberinto;

/**
 * @author luzch
 */
public class Level {

    private final int id;
    private final String title;
    private final Laberinto laberinto;
    private boolean active;

    public Level(int id, String title, boolean active, Laberinto laberinto) {
        this.laberinto = laberinto;
        this.id = id;
        this.title = title;
        this.active = active;
    }

    public void setActive() {
        active = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean active() {
        return active;
    }

    public Laberinto getLaberinto() {
        return laberinto;
    }

    public void setActive(boolean b) {
        active = true;
    }
}
