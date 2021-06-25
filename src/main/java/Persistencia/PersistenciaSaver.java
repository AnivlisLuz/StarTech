/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import app.startech.data.DataController;
import app.startech.login.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Criss
 */
public class PersistenciaSaver {
    final private String filePAth = "./categoria.txt";
    

    //Metodo que permite crear el archivo de texto y escribir en el añadiendo al usuario en cada línea.
    public void escritura(Usuario usuario, int category, int level) {

        try {
            File file = new File(filePAth);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fwu = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter fb = new BufferedWriter(fwu);
            fb.write(usuario.getId()+";"+category+";"+level);
            fb.write("\n");
            fb.close();
            fwu.close();
            
            for(int i =0; i<= category; i++){
                
                for(int j=0; j<= level; j++){
                    
                }
            }
            
        } catch (IOException e) {
            System.out.println("error 404" + e);
        }

    }

    // Metodo que permite leer el contenido del archivo de texto y seleccionar al usuario.
    public ArrayList<Persistencia> lectura() {
        ArrayList<Persistencia> rest = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filePAth);
            BufferedReader bw = new BufferedReader(fr);
            String valor;
            while ((valor = bw.readLine()) != null) {
                String[] userData = valor.split(";");
                Persistencia act = new Persistencia(userData[0], userData[1], userData[2]);
                rest.add(act);
            }
        } catch (IOException e) {
            System.out.println("error 404" + e);
        }
        return rest;
    }
}
