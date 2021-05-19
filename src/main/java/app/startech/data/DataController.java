/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.data;

import app.startech.login.UserSaver;
import app.startech.login.Usuario;

import java.util.ArrayList;

/**
 * @author luzch
 */
public class DataController {

    final public static DataController instance = new DataController();
    public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private Usuario usuarioActual = null;
    public DataController() {
        load();
    }

    private void load() {
        UserSaver userSaver = new UserSaver();
        usuarios = userSaver.lectura();
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;

    }

    public void setUsuarioActual(int index) {
        usuarioActual = usuarios.get(index);
    }

}
