/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class Metodos {
    public String addNiveles(String categoria, String nombreUsuario)
    {
        int niveles = 0;
        try
        {
            FileReader fr = new FileReader("Usuarios\\" + nombreUsuario + "\\" + categoria + ".txt");
            BufferedReader bw = new BufferedReader(fr);
            String linea;
            while ((linea = bw.readLine()) != null)
            {
                niveles++;
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se encontraron datos para este usuario.");
        }
        return niveles + "";
    }
}
