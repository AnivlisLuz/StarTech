/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crucigrama;

import java.awt.Button;

/**
 *
 * @author Criss
 */
public class VentanaCrucigrama {
    
    private Crucigrama crucigrama;
    
    public VentanaCrucigrama(){
        
    }
    
    public void mostrarCrucigrama(){
        char[][] cruci = crucigrama.getMatriz();
        int tamX = cruci.length;
        int tamY = cruci[0].length;
        int x=0, y=0, m=100, n=100;
        for(int i=0; i<tamX; i++){
            for(int j=0; j<tamY; j++){
                char act = cruci[i][j];
                if(act == '@'){
                    Button a = new Button();
                }else{
                    
                }
                x += m;
            }
            y += n;
        }
    }
}
