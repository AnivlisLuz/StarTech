/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import data.CategoryManager;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author chovis
 */
public class Usuario {

    public static int valor = 0;
    private String nombre;
    private String edad;
    public CategoryManager category = new CategoryManager();

    public Usuario() {
    }

    public Usuario(String nombre, String edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public static ArrayList<Usuario> mostrar() {
        return usuarioSave.mostrar();
    }

    public static boolean verificarUsuario(String nombre) {

        ArrayList<Usuario> lista = mostrar();
        for (Usuario user : lista) {
            if (user.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

}
