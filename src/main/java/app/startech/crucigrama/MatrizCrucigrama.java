/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.crucigrama;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class MatrizCrucigrama {
    char[][] matriz =   {{'3','+','2','=','@','#','#','#','@','+','4','=','8'},
                        {'#','#','#','#','+','#','#','#','+','#','#','#','#'},
                        {'#','#','#','#','1','#','#','#','5','#','6','#','#'},
                        {'#','#','#','#','=','#','#','#','=','#','+','#','#'},
                        {'#','#','3','#','@','+','@','=','@','#','2','#','#'},
                        {'#','#','+','#','#','#','+','#','#','#','=','#','#'},
                        {'#','#','2','#','#','#','@','+','@','=','@','#','#'},
                        {'#','#','=','#','#','#','=','#','+','#','#','#','#'},
                        {'#','#','@','+','@','=','7','#','@','+','@','=','7'},
                        {'#','#','#','#','+','#','#','#','=','#','+','#','#'},
                        {'#','#','#','#','6','+','@','=','9','#','4','#','#'},
                        {'#','#','#','#','=','#','#','#','#','#','=','#','#'},
                        {'4','+','@','=','8','#','@','+','3','=','@','#','#'},
                        {'#','#','+','#','#','#','+','#','#','#','#','#','#'},
                        {'#','#','2','#','#','#','5','#','#','#','#','#','#'},
                        {'#','#','=','#','#','#','=','#','#','#','#','#','#'},
                        {'#','#','@','+','@','=','@','#','#','#','#','#','#'}};
    private Casilla[][] plantilla;
    private ArrayList<Casilla> numeros;
    
    public MatrizCrucigrama()
    {
        plantilla = new Plantilla(matriz).getPlantilla();
    }
    
    public void mostrarPlantilla()
    {
        for (int i = 0; i<plantilla.length; i++)
        {
            for (int j = 0; j<plantilla[i].length; j++)
            {
                if (!plantilla[i][j].esNumero())
                    System.out.println(" " + "");
                else
                    System.out.println(plantilla[i][j].getContenido() + "");
            }
        }
    }
}
