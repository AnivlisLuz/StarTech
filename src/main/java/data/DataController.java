/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import app.startech.models.Category;
import app.startech.models.Level;
import folder.Laberinto;
import forms.Usuario;
import java.util.ArrayList;

/**
 *
 * @author luzch
 */
public class DataController {

    final public static DataController instance = new DataController();

    public DataController() {        
         usuarios.add(new Usuario("a","10"));
         usuarios.add(new Usuario("b","20"));
    }
    
    public ArrayList<Usuario> usuarios = new ArrayList();
    private Usuario usuarioActual = null;



    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;       
        
    }    

    public void setUsuarioActual(int index) {
        usuarioActual=usuarios.get(index);
    }

}
