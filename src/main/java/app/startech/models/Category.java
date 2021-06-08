/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.models;

/**
 * @author luzch
 */
public class Category {

    private final int id;
    private final String title;
    private final String image;

    private final Level[] levels;
    private boolean active;

    public Category(int id, String title,String image, boolean active, Level[] level) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.active = active;
        this.levels = level;
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

    public String getImage() {
        return image;
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

    // Se obtiene el siguiente nivel, si esque lo tuviera
    public Level nextLevel(Level level) {
        Level res = null;
        for (int i = 0; i < levels.length; i++) {
            Level lev = levels[i];
            if (level.equals(lev)) {
                if (i + 1 == levels.length) {
                    res = null;
                } else {
                    res = levels[i + 1];
                }
                break;
            }
        }
        return res;
    }

}
