/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.Persistencia;

/**
 *
 * @author Criss
 */
public class Persistencia {
    
    private String idUsuario;
    private String idCategory;
    private String level;
    
    public Persistencia(String idUsuario, String idCategory, String level){
        this.idUsuario = idUsuario;
        this.idCategory = idCategory;
        this.level = level;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public String getLevel() {
        return level;
    }
    
    
}
