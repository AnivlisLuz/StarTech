/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.crucigrama;

/**
 *
 * @author Carlos
 */
public class MatrizCrucigrama {
    /*
    MatrizCrucigrama mat = new MatrizCrucigrama("restas");
    char[][] matriz = mat.getMat();
    char[][] matrizRes = mat.getRes();
    */
    
    private char[][] mat;
    private final char[][] matRes;
    
    public MatrizCrucigrama(String operacion)
    {
        Plantilla plantilla = new Plantilla(operacion);
        mat = plantilla.getMatriz();
        matRes = plantilla.getMatizRes();
    }
    
    public char[][] getMat()
    {
        return mat;
    }
    
    public char[][] getMatRes()
    {
        return matRes;
    }
}
