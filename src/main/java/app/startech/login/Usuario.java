/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.login;

import app.startech.data.CategoryManager;
import app.startech.data.DataController;

import java.util.ArrayList;

/**
 * @author chovis
 */
public class Usuario {

    public static int valor = 0;
    public CategoryManager category = new CategoryManager();
    private String nombre;
    private String edad;
    private String id;

    public Usuario() {
    }

    public Usuario(String id, String nombre, String edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Usuario(String nombre, String edad) {
        this.id = DataController.instance.usuarios.size() + 1 + "";
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String toFile() {
        return id+";"+nombre + ";" + edad;
    }

    public static boolean esLetra(String nombre) {
        if (nombre.length() > 20) {
            return false;
        }
        for (int i = 0; i < nombre.length(); i++) {
            char letra = nombre.toUpperCase().charAt(i);
            int valorAski = (int) letra;
            if (valorAski != 165 && (valorAski < 65 || valorAski > 90)) {
                return false;
            }
        }
        return true;
    }

}
