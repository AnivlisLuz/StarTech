/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author chovis
 */
public class saveUser {
    
    public static void escritura(String nombre, String edad){
        
        
       try{
          File file =new File("E:\\usuario.txt");
          if(!file.exists()){
             file.createNewFile();
             
          }
          FileWriter fwu=new FileWriter(file.getAbsoluteFile(),true);
          
          BufferedWriter fb= new BufferedWriter(fwu);
          
          fb.write(nombre);
          fb.newLine();
          fb.write(edad);
          fb.newLine();
          //fwu.write(97);
          fb.close();
          fwu.close();
          
       }  
       catch(IOException e){
           System.out.println("error 404"+e);
       }
       
    }
    
    public static boolean lectura(String nombre)
    {
       boolean  verificar=false;
       try{
       FileReader fr= new FileReader("E:\\usuario.txt");
       BufferedReader bw = new BufferedReader(fr);
       String valor = null;
       while((valor=bw.readLine())!=null)
       {
           
          // String [] word= record.split(" ");
           if(valor.equals(nombre)){
               verificar =true;
           }
       }
     
           return verificar;
           
       }
      catch(IOException e){
           System.out.println("error 404"+e);
       }
       
         // int valor = fr.read();
          //while(valor!= -1)
        //  {
           //   System.out.print((char)valor);
          //    valor= fr.read() ;
         // }
          //fr.close();
         //  FileReader fr = new FileReader("Usuarios\\" + nombreUsuario + "\\" + categoria + ".txt");
           
    }
    
}
