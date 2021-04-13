/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.models;

/**
 *
 * @author luzch
 */
public class Category {

    private int id;
    private String title;

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
}
