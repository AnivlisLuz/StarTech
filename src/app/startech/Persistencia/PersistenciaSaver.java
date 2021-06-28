/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.Persistencia;

import app.startech.login.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            
            FileWriter fwu = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter fb = new BufferedWriter(fwu);
            fb.write(usuario.getId()+";"+category+";"+level);
            fb.write("\n");
            fb.close();
            fwu.close();
            
        } catch (IOException e) {
            System.out.println("error 404" + e);
        }

    }
    private void escritura2 (String idUsuario, int category, int level, int index){
        BufferedReader file = null;
        try {
            int cont = 1;
            String line;
            String input = "";
            file = new BufferedReader(new FileReader(filePAth));
            while((line = file.readLine()) != null){
                if(index == cont)
                    input += idUsuario +";"+ category +";"+level+"\r\n";
                else
                    input += line+"\r\n";
                cont++;
            }
            FileOutputStream fileOut = new FileOutputStream(filePAth);
            fileOut.write(input.getBytes());
            fileOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersistenciaSaver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PersistenciaSaver.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(PersistenciaSaver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void buscarUsuario(Usuario usuario, int category, int level){
        int index = 1; 
        boolean enc = false;
        try {
            File file = new File(filePAth);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileReader fr = new FileReader(filePAth);
            BufferedReader bw = new BufferedReader(fr);
            String valor;
            while ((valor = bw.readLine()) != null) {
                String[] userData = valor.split(";");
                
                int usuarioAct = Integer.parseInt(userData[0]);
                int categoryAct = Integer.parseInt(userData[1]);
                if(userData[0].equals(usuario.getId()) && categoryAct == category){
                    escritura2(usuario.getId(), category, level, index);
                    enc = true;
                    break;
                }
                index++;
            }
            if(!enc){
                escritura(usuario, category, level);
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
