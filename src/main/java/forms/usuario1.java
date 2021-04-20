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
public class usuario1 {
    private String nombre;
    private String edad;
    
    public String getNombre()
    {
        return nombre;
    }
    public String getEdad()
    {
        return edad;
    }
    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }
    public void setEdad(String edad)
    {
        this.edad=edad;
    }
   public static  Vector mostrar()
   {
       return usuarioSave.mostrar();
   }
   public static int verificarUsuario(String nombre)
   {
       Vector lista = mostrar();
       usuario1 obj;
       for( int i=0;i<lista.size();i++)
       {
           obj= (usuario1) lista.elementAt(i);
           if(obj.getNombre().equalsIgnoreCase(nombre))
           {
               return  i;
           }
       }
       return -1;
   }
           
}

