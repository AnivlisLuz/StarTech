/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.Vector;

/**
 *
 * @author chovis
 */
public class usuarioSave {
    
    private static Vector<usuario1> datos= new Vector<usuario1>();
    public static void agregar(usuario1 obj ){
      datos.addElement(obj);
    }   
     public static  Vector mostrar(){
      return datos ;
    }   
   
}
