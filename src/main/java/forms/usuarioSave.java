/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author chovis
 */
public class usuarioSave {
    
    private static ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
    public static void agregar(Usuario obj ){
      usuarios.add(obj);
    }   
     public static  ArrayList<Usuario> mostrar(){
      return usuarios ;
    }   
   
}
