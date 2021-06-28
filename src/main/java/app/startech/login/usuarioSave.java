/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.login;

import java.util.ArrayList;

/**
 * @author chovis
 */
public class usuarioSave {

    private static final ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public static void agregar(Usuario obj) {
        usuarios.add(obj);
    }

    public static ArrayList<Usuario> mostrar() {
        return usuarios;
    }

}
