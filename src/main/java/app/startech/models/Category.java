/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.models;

import preguntas.Pregunta;

/**
 *
 * @author luzch
 */
public class Category {

    private final int id;
    private final String title;
    private boolean active;
    private Level[] levels;

    public Category(int id, String title, boolean active, Level[] level) {
        this.id = id;
        this.title = title;
        this.active = active;
        this.levels = level;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Level[] getLevels() {
        return levels;
    }

}
