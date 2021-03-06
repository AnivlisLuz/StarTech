/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.login;

import app.startech.data.DataController;

import java.io.*;
import java.util.ArrayList;

/**
 * @author chovis
 */
public class UserSaver {

    final private String filePAth = "./usuario.txt";

    //Metodo que permite crear el archivo de texto y escribir en el añadiendo al usuario en cada línea.
    public void escritura(Usuario usuario) {

        try {
            File file = new File(filePAth);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fwu = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter fb = new BufferedWriter(fwu);
            fb.write(usuario.toFile());
            fb.write("\n");
            fb.close();
            fwu.close();

            DataController.instance.usuarios.add(usuario);
            DataController.instance.setUsuarioActual(usuario);
        } catch (IOException e) {
            System.out.println("error 404" + e);
        }

    }

    // Metodo que permite leer el contenido del archivo de texto y seleccionar al usuario.
    public ArrayList<Usuario> lectura() {
        ArrayList<Usuario> result = new ArrayList<Usuario>();
        try {
            FileReader fr = new FileReader(filePAth);
            BufferedReader bw = new BufferedReader(fr);
            String valor;
            while ((valor = bw.readLine()) != null) {
                String[] userData = valor.split(";");
                Usuario usuario = new Usuario(userData[0], userData[1], userData[2]);
                result.add(usuario);
            }
        } catch (IOException e) {
            System.out.println("error 404" + e);
        }
        return result;
    }

}
