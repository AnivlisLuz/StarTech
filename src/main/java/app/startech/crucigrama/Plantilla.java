/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.crucigrama;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Carlos
 */
public class Plantilla {
    private Casilla[][] plantilla;
    
    private ArrayList<char[][]> matrices = new ArrayList<>();
    private ArrayList<ArrayList<Casilla>> operaciones = new ArrayList<>();
    
    private char[][] matriz;
    private char[][] matrizRes;
    
    ArrayList<Casilla> numeros = new ArrayList<>();
    
    public Plantilla(String operacion)
    {
        int rand = getRandom(1, 5);
        
        if (operacion.equals("suma"))
            addSumas(rand);
        if (operacion.equals("resta"))
            addRestas(rand);
        if (operacion.equals("multiplicacion"))
            addMultiplicaciones(rand);
        if (operacion.equals("division"))
            addDivisiones(rand);
        if (operacion.equals("combinados"))
            addCombinado(rand);
        
        matriz = quitarNum(matrizRes);
        
        /*
        int n = getRandom(1, 5);
        
        matriz = matrices.get(n);
        matrizRes = clonar(matrices.get(n));
        
        setPlantilla();
        setNumeros();
        quitarNumeros();
        */
    }
    
    public void setPlantilla()
    {
        Casilla[][] aux = new Casilla[matriz.length][matriz[0].length];
        for (int i = 0; i < aux.length; i++)
        {
            for (int j = 0; j < aux[i].length; j++)
            {
                aux[i][j] = new Casilla(i,j,matriz[i][j]);
            }
        }
        plantilla = aux;
    }
    
    public void setNumeros()
    {
        for (int i = 0; i<plantilla.length; i++)
            for (int j = 0; j<plantilla[i].length; j++)
                if (plantilla[i][j].esNumero())
                    numeros.add(plantilla[i][j]);
    }
    
    public void quitarNumeros()
    {
        Random r = new Random();
        for (int i = 0; i <= 8; i++)
        {
            int n = r.nextInt(numeros.size());
            matriz[numeros.get(n).getX()][numeros.get(n).getY()] = '@';
        }
    }
    
    public char[][] clonar(char[][] mat)
    {
        char[][] aux = new char[mat.length][mat.length];
        for (int i = 0; i<mat.length; i++)
            for (int j = 0; j<mat.length; j++)
                aux[i][j] = mat[i][j];
        return aux;
    }
    
    public char[][] getMatriz()
    {
        return matriz;
    }
    
    public char[][] getMatizRes()
    {
        return matrizRes;
    }
    
    //Enviar el parámetro aleatorio para decidir la matriz.
    private void addSumas(int n)
    {
        if (n==1)
        {                                           //j
            //                0       2       4       6       8      10      12
            char[][] m1 =  {{'3','+','2','=','5','#','#','#','4','+','4','=','8'}, //0
                            {'#','#','#','#','+','#','#','#','+','#','#','#','='},
                            {'#','#','#','#','1','#','#','#','5','#','#','#','5'}, //2
                            {'#','#','#','#','=','#','#','#','=','#','#','#','+'},
                            {'#','#','8','#','6','+','3','=','9','#','#','#','3'}, //4
                            {'#','#','=','#','#','#','+','#','#','#','#','#','#'},
                            {'3','+','3','=','6','#','4','+','2','=','6','#','#'}, //6   i
                            {'#','#','+','#','#','#','=','#','+','#','#','#','#'},
                            {'#','#','5','+','2','=','7','#','1','+','2','=','7'}, //8
                            {'#','#','#','#','+','#','#','#','=','#','#','#','#'},
                            {'#','#','#','#','6','#','5','+','3','=','8','#','#'}, //10
                            {'#','#','#','#','=','#','#','#','#','#','#','#','#'},
                            {'#','#','1','+','8','=','9','#','#','#','#','#','#'}};//12
            Casilla[][] c1 = toCasilla(m1);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[0][2]);
            op1.add(c1[0][4]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[0][4]);
            op2.add(c1[2][4]);
            op2.add(c1[4][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[4][4]);
            op3.add(c1[4][6]);
            op3.add(c1[4][8]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][8]);
            op4.add(c1[2][8]);
            op4.add(c1[0][8]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[0][8]);
            op5.add(c1[0][10]);
            op5.add(c1[0][12]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[0][12]);
            op6.add(c1[2][12]);
            op6.add(c1[4][12]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[4][6]);
            op7.add(c1[6][6]);
            op7.add(c1[8][6]);
            /*
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[2][4]);
            op8.add(c1[2][6]);
            op8.add(c1[2][8]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[0][6]);
            op9.add(c1[2][6]);
            op9.add(c1[4][6]);
            */
            ArrayList<Casilla> op10 = new ArrayList<>();
            op10.add(c1[8][2]);
            op10.add(c1[8][4]);
            op10.add(c1[8][6]);
            ArrayList<Casilla> op11 = new ArrayList<>();
            op11.add(c1[8][4]);
            op11.add(c1[10][4]);
            op11.add(c1[12][4]);
            ArrayList<Casilla> op12 = new ArrayList<>();
            op12.add(c1[12][2]);
            op12.add(c1[12][4]);
            op12.add(c1[12][6]);
            ArrayList<Casilla> op13 = new ArrayList<>();
            op13.add(c1[6][6]);
            op13.add(c1[6][8]);
            op13.add(c1[6][10]);
            ArrayList<Casilla> op14 = new ArrayList<>();
            op14.add(c1[6][8]);
            op14.add(c1[8][8]);
            op14.add(c1[10][8]);
            ArrayList<Casilla> op15 = new ArrayList<>();
            op15.add(c1[8][8]);
            op15.add(c1[8][10]);
            op15.add(c1[8][12]);
            ArrayList<Casilla> op16 = new ArrayList<>();
            op16.add(c1[10][6]);
            op16.add(c1[10][8]);
            op16.add(c1[10][10]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            //ops.add(op8);
            //ops.add(op9);
            ops.add(op10);
            ops.add(op11);
            ops.add(op12);
            ops.add(op13);
            ops.add(op14);
            ops.add(op15);
            ops.add(op16);
            
            operaciones = ops;
            
            matrizRes = m1;
        }
        if (n == 2)
        {
            //                0       2       4       6       8      10      12
            char[][] m2 =  {{'#','#','#','#','#','#','#','#','1','#','#','#','#'},//0
                            {'#','#','#','#','#','#','#','#','+','#','#','#','#'},
                            {'#','#','#','#','1','+','1','=','2','#','#','#','#'},//2
                            {'#','#','#','#','+','#','#','#','=','#','#','#','#'},
                            {'1','+','2','=','3','#','#','#','3','+','2','=','5'},//4
                            {'#','#','#','#','=','#','#','#','#','#','+','#','#'},
                            {'#','#','#','#','4','#','#','#','#','#','5','#','#'},//6  i
                            {'#','#','#','#','#','#','#','#','#','#','=','#','#'},
                            {'#','#','#','#','#','#','4','+','3','=','7','#','#'},//8
                            {'#','#','#','#','#','#','+','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','4','#','#','#','#','#','#'},//10
                            {'#','#','#','#','#','#','=','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','8','+','1','=','9','#','#'}};//12
            Casilla[][] c1 = toCasilla(m2);
            ArrayList<Casilla> op1 = new ArrayList<>();
                     //i  j
            op1.add(c1[0][8]);
            op1.add(c1[2][8]);
            op1.add(c1[4][8]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[2][4]);
            op2.add(c1[2][6]);
            op2.add(c1[2][8]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[2][4]);
            op3.add(c1[6][4]);
            op3.add(c1[4][4]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][0]);
            op4.add(c1[4][2]);
            op4.add(c1[4][4]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[4][8]);
            op5.add(c1[4][10]);
            op5.add(c1[4][12]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[4][10]);
            op6.add(c1[6][10]);
            op6.add(c1[8][10]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[8][6]);
            op7.add(c1[8][8]);
            op7.add(c1[8][10]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[8][6]);
            op8.add(c1[10][6]);
            op8.add(c1[12][6]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[12][6]);
            op9.add(c1[12][8]);
            op9.add(c1[12][10]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            
            operaciones = ops;
            
            matrizRes = m2;
        }
        if (n == 3)
        {
            //                0       2       4       6       8      10      12
            char[][] m3 =  {{'#','#','#','#','2','+','3','=','5','#','#','#','#'},//0
                            {'#','#','#','#','+','#','#','#','+','#','#','#','#'},
                            {'#','#','#','#','6','#','#','#','1','#','#','#','#'},//2
                            {'#','#','#','#','=','#','#','#','=','#','#','#','#'},
                            {'4','+','4','=','8','#','#','#','6','+','2','=','8'},//4
                            {'+','#','#','#','#','#','#','#','#','#','+','#','#'},
                            {'5','+','2','=','7','#','#','#','#','#','3','#','#'},//6 i
                            {'=','#','+','#','#','#','#','#','#','#','=','#','#'},
                            {'9','#','4','#','#','#','2','+','3','=','5','#','#'},//8
                            {'#','#','=','#','#','#','+','#','#','#','#','#','#'},
                            {'#','#','6','#','#','#','7','#','#','#','#','#','#'},//10
                            {'#','#','#','#','#','#','=','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','9','#','#','#','#','#','#'}};//12
            Casilla[][] c1 = toCasilla(m3);
            ArrayList<Casilla> op1 = new ArrayList<>();
                     //i  j
            op1.add(c1[0][4]);
            op1.add(c1[0][6]);
            op1.add(c1[0][8]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[0][4]);
            op2.add(c1[2][4]);
            op2.add(c1[4][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[4][0]);
            op3.add(c1[4][2]);
            op3.add(c1[4][4]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[0][8]);
            op4.add(c1[2][8]);
            op4.add(c1[4][8]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[4][8]);
            op5.add(c1[4][10]);
            op5.add(c1[4][12]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[4][10]);
            op6.add(c1[6][10]);
            op6.add(c1[8][10]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[4][0]);
            op7.add(c1[6][0]);
            op7.add(c1[8][0]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[8][6]);
            op8.add(c1[10][6]);
            op8.add(c1[12][6]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[8][6]);
            op9.add(c1[8][8]);
            op9.add(c1[8][10]);
            ArrayList<Casilla> op10 = new ArrayList<>();//
            op10.add(c1[6][2]);
            op10.add(c1[8][2]);
            op10.add(c1[10][2]);
            ArrayList<Casilla> op11 = new ArrayList<>();
            op11.add(c1[6][0]);
            op11.add(c1[6][2]);
            op11.add(c1[6][4]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            ops.add(op10);
            ops.add(op11);
            
            operaciones = ops;
            
            matrizRes = m3;
        }
        
        if (n == 4)
        {
            //                0       2       4       6       8      10      12
            char[][] m4 =  {{'#','#','#','#','#','#','#','#','3','#','#','#','#'},//0
                            {'#','#','#','#','#','#','#','#','+','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','3','+','4','=','7'},//2
                            {'#','#','#','#','#','#','#','#','=','#','#','#','#'},
                            {'4','#','#','#','4','+','2','=','6','#','#','#','#'},//4
                            {'+','#','#','#','+','#','#','#','#','#','#','#','#'},
                            {'2','#','#','#','3','+','2','=','5','#','#','#','#'},//6  i
                            {'=','#','#','#','=','#','#','#','+','#','#','#','#'},
                            {'6','+','1','=','7','#','#','#','2','#','#','#','#'},//8
                            {'#','#','+','#','#','#','#','#','=','#','#','#','#'},
                            {'#','#','5','#','#','#','#','#','7','#','#','#','#'},//10
                            {'#','#','=','#','#','#','#','#','#','#','#','#','#'},
                            {'#','#','6','#','#','#','#','#','#','#','#','#','#'}};//12
            Casilla[][] c1 = toCasilla(m4);
            ArrayList<Casilla> op1 = new ArrayList<>();
                     //i  j
            op1.add(c1[0][8]);
            op1.add(c1[2][8]);
            op1.add(c1[4][8]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[2][8]);
            op2.add(c1[2][10]);
            op2.add(c1[2][12]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[4][4]);
            op3.add(c1[4][6]);
            op3.add(c1[4][8]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[6][4]);
            op4.add(c1[6][6]);
            op4.add(c1[6][8]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[4][4]);
            op5.add(c1[6][4]);
            op5.add(c1[8][4]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[8][0]);
            op6.add(c1[8][2]);
            op6.add(c1[8][4]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[4][0]);
            op7.add(c1[6][0]);
            op7.add(c1[8][0]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[8][2]);
            op8.add(c1[10][2]);
            op8.add(c1[12][2]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[6][8]);
            op9.add(c1[8][8]);
            op9.add(c1[10][8]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            
            operaciones = ops;
            
            matrizRes = m4;
        }
        if (n == 5)
        {
            //                0       2       4       6       8      10      12
            char[][] m5 =  {{'1','+','6','=','7','#','#','#','#','#','#','#','#'},//0
                            {'#','#','+','#','#','#','#','#','#','#','#','#','#'},
                            {'#','#','2','#','4','#','#','#','7','+','2','=','9'},//2
                            {'#','#','=','#','+','#','#','#','=','#','+','#','#'},
                            {'#','#','8','+','1','=','9','#','6','#','6','#','#'},//4
                            {'#','#','#','#','=','#','=','#','+','#','=','#','#'},
                            {'#','#','#','#','5','#','7','+','1','=','8','#','#'},//6 i
                            {'#','#','#','#','#','#','+','#','#','#','#','#','#'},
                            {'#','#','#','#','1','+','2','=','3','#','#','#','2'},//8
                            {'#','#','#','#','#','#','#','#','=','#','#','#','+'},
                            {'#','#','#','#','#','#','#','#','2','+','3','=','5'},//10
                            {'#','#','#','#','#','#','#','#','+','#','#','#','='},
                            {'#','#','#','#','#','#','#','#','1','#','#','#','7'}};//12
        
            Casilla[][] c1 = toCasilla(m5);
            ArrayList<Casilla> op1 = new ArrayList<>();
                     //i  j
            op1.add(c1[0][0]);
            op1.add(c1[0][2]);
            op1.add(c1[0][4]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[0][2]);
            op2.add(c1[2][2]);
            op2.add(c1[4][2]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[4][2]);
            op3.add(c1[4][4]);
            op3.add(c1[4][6]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[2][4]);
            op4.add(c1[4][4]);
            op4.add(c1[6][4]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[4][6]);
            op5.add(c1[6][6]);
            op5.add(c1[8][6]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[6][6]);
            op6.add(c1[6][8]);
            op6.add(c1[6][10]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[8][4]);
            op7.add(c1[8][6]);
            op7.add(c1[8][8]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[2][8]);
            op8.add(c1[4][8]);
            op8.add(c1[6][8]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[2][8]);
            op9.add(c1[2][10]);
            op9.add(c1[2][12]);
            ArrayList<Casilla> op10 = new ArrayList<>();
            op10.add(c1[2][10]);
            op10.add(c1[4][10]);
            op10.add(c1[6][10]);
            ArrayList<Casilla> op11 = new ArrayList<>();
            op11.add(c1[8][8]);
            op11.add(c1[10][8]);
            op11.add(c1[12][8]);
            ArrayList<Casilla> op12 = new ArrayList<>();
            op12.add(c1[10][8]);
            op12.add(c1[10][8]);
            op12.add(c1[10][8]);
            ArrayList<Casilla> op13 = new ArrayList<>();
            op13.add(c1[8][12]);
            op13.add(c1[10][12]);
            op13.add(c1[12][12]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            ops.add(op10);
            ops.add(op11);
            ops.add(op12);
            ops.add(op13);
            
            operaciones = ops;
            
            matrizRes = m5;
        }
    }
    
    private void addRestas(int n)
    {
        if (n == 1)
        {
            char[][] m1 =  {{'8','-','5','=','3','#','#','#','#','#','#','#','#'},
                            {'-','#','-','#','#','#','#','#','#','#','#','#','#'},
                            {'1','#','3','#','#','#','#','#','#','#','#','#','#'},
                            {'=','#','=','#','#','#','#','#','#','#','#','#','#'},
                            {'7','-','2','=','5','#','#','#','9','#','#','#','#'},
                            {'#','#','#','#','-','#','#','#','-','#','#','#','#'},
                            {'#','#','#','#','4','-','1','=','3','#','#','#','#'},
                            {'#','#','#','#','=','#','#','#','=','#','#','#','#'},
                            {'#','#','#','#','1','#','#','#','6','-','4','=','2'},
                            {'#','#','#','#','#','#','#','#','-','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','3','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','=','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','3','#','#','#','#'}};
            
            Casilla[][] c1 = toCasilla(m1);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[2][0]);
            op1.add(c1[4][0]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[0][0]);
            op2.add(c1[0][2]);
            op2.add(c1[0][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[0][2]);
            op3.add(c1[2][2]);
            op3.add(c1[4][2]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][0]);
            op4.add(c1[4][2]);
            op4.add(c1[4][4]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[4][4]);
            op5.add(c1[6][4]);
            op5.add(c1[8][4]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[6][4]);
            op6.add(c1[6][6]);
            op6.add(c1[6][8]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[4][8]);
            op7.add(c1[6][8]);
            op7.add(c1[8][8]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[8][8]);
            op8.add(c1[8][10]);
            op8.add(c1[8][12]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[8][8]);
            op9.add(c1[10][8]);
            op9.add(c1[12][8]);
        
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            
            operaciones = ops;
            
            matrizRes = m1;
        }
        
        if (n == 2)
        {
            char[][] m2 =  {{'#','#','9','-','4','=','5','#','#','#','#','#','#'},
                            {'#','#','-','#','#','#','-','#','#','#','#','#','#'},
                            {'#','#','3','#','#','#','1','#','#','#','#','#','#'},
                            {'#','#','=','#','#','#','=','#','#','#','#','#','#'},
                            {'8','-','6','=','2','#','4','#','#','#','#','#','#'},
                            {'#','#','-','#','#','#','#','#','#','#','#','#','#'},
                            {'#','#','2','#','#','#','#','#','#','#','#','#','9'},
                            {'#','#','=','#','#','#','#','#','#','#','#','#','-'},
                            {'#','#','4','-','1','=','3','#','#','#','#','#','7'},
                            {'#','#','#','#','#','#','-','#','#','#','#','#','='},
                            {'#','#','#','#','9','-','2','=','7','-','5','=','2'},
                            {'#','#','#','#','#','#','=','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','1','#','#','#','#','#','#'}};
            
            Casilla[][] c1 = toCasilla(m2);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][2]);
            op1.add(c1[2][2]);
            op1.add(c1[4][2]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[0][0]);
            op2.add(c1[0][2]);
            op2.add(c1[0][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[0][6]);
            op3.add(c1[2][6]);
            op3.add(c1[4][6]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][0]);
            op4.add(c1[4][2]);
            op4.add(c1[4][4]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[4][2]);
            op5.add(c1[6][2]);
            op5.add(c1[8][2]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[8][2]);
            op6.add(c1[8][4]);
            op6.add(c1[8][6]);
            /*
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[4][6]);
            op7.add(c1[6][6]);
            op7.add(c1[8][6]);
            */
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[10][4]);
            op8.add(c1[10][6]);
            op8.add(c1[10][8]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[10][8]);
            op9.add(c1[10][10]);
            op9.add(c1[10][12]);
            ArrayList<Casilla> op10 = new ArrayList<>();
            op10.add(c1[6][12]);
            op10.add(c1[8][12]);
            op10.add(c1[10][12]);
        
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            //ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            ops.add(op10);
            
            operaciones = ops;
            
            matrizRes = m2;
        }
        if (n == 3)
        {
            char[][] m3 =  {{'#','#','8','#','#','#','#','#','#','#','#','#','#'},
                            {'#','#','-','#','#','#','#','#','#','#','#','#','#'},
                            {'9','-','2','=','7','#','#','#','#','#','#','#','#'},
                            {'#','#','=','#','#','#','#','#','#','#','#','#','#'},
                            {'#','#','6','-','1','=','5','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','-','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','3','#','8','-','6','=','2'},
                            {'#','#','#','#','#','#','=','#','-','#','#','#','#'},
                            {'#','#','#','#','9','-','2','=','7','#','6','#','#'},
                            {'#','#','#','#','#','#','#','#','=','#','-','#','#'},
                            {'#','#','#','#','#','#','5','-','1','=','4','#','#'},
                            {'#','#','#','#','#','#','#','#','#','#','=','#','#'},
                            {'#','#','#','#','#','#','#','#','#','#','2','#','#'}};
        
            Casilla[][] c1 = toCasilla(m3);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][2]);
            op1.add(c1[2][2]);
            op1.add(c1[4][2]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[2][0]);
            op2.add(c1[2][2]);
            op2.add(c1[2][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[2][4]);
            op3.add(c1[4][4]);
            op3.add(c1[6][4]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][6]);
            op4.add(c1[6][6]);
            op4.add(c1[8][6]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[8][4]);
            op5.add(c1[8][6]);
            op5.add(c1[8][8]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[6][8]);
            op6.add(c1[8][8]);
            op6.add(c1[10][8]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[6][8]);
            op7.add(c1[6][10]);
            op7.add(c1[6][12]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[10][6]);
            op8.add(c1[10][8]);
            op8.add(c1[10][10]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[8][10]);
            op9.add(c1[10][10]);
            op9.add(c1[12][10]);
        
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            
            operaciones = ops;
            
            matrizRes = m3;
        }
        
        if (n == 4)
        {
            char[][] m4 =  {{'6','-','1','=','5','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','-','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','3','#','8','-','6','=','2','#','#'},
                            {'#','#','#','#','=','#','-','#','-','#','#','#','#'},
                            {'#','#','9','-','2','=','7','-','4','=','3','#','#'},
                            {'#','#','#','#','#','#','=','#','=','#','-','#','#'},
                            {'#','#','#','#','#','#','1','#','2','#','1','#','#'},
                            {'#','#','#','#','#','#','#','#','#','#','=','#','#'},
                            {'#','#','#','#','#','#','#','#','8','-','2','=','6'},
                            {'#','#','#','#','#','#','#','#','-','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','3','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','=','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','5','#','#','#','#'}};
            
            Casilla[][] c1 = toCasilla(m4);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[0][2]);
            op1.add(c1[0][4]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[0][4]);
            op2.add(c1[2][4]);
            op2.add(c1[4][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[4][2]);
            op3.add(c1[4][4]);
            op3.add(c1[4][6]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[2][6]);
            op4.add(c1[4][6]);
            op4.add(c1[6][6]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[2][6]);
            op5.add(c1[2][8]);
            op5.add(c1[2][10]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[4][6]);
            op6.add(c1[4][8]);
            op6.add(c1[4][10]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[2][8]);
            op7.add(c1[4][8]);
            op7.add(c1[6][8]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[4][10]);
            op8.add(c1[6][10]);
            op8.add(c1[8][10]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[8][8]);
            op9.add(c1[8][10]);
            op9.add(c1[8][12]);
            ArrayList<Casilla> op10 = new ArrayList<>();
            op10.add(c1[8][8]);
            op10.add(c1[10][8]);
            op10.add(c1[12][8]);
        
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            ops.add(op10);
            
            operaciones = ops;
            
            matrizRes = m4;
        }
        
        if (n == 5)
        {
            char[][] m5 =  {{'#','#','9','#','#','#','#','#','#','#','#','#','#'},
                            {'#','#','-','#','#','#','#','#','#','#','#','#','#'},
                            {'8','-','3','=','5','#','#','#','#','#','#','#','#'},
                            {'#','#','=','#','-','#','#','#','#','#','#','#','#'},
                            {'#','#','6','-','4','=','2','#','#','#','#','#','#'},
                            {'#','#','#','#','=','#','#','#','#','#','#','#','#'},
                            {'#','#','4','-','1','=','3','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','-','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','2','#','9','-','4','=','5'},
                            {'#','#','#','#','#','#','=','#','-','#','#','#','#'},
                            {'#','#','#','#','7','-','1','=','6','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','=','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','3','#','#','#','#'}};
            
            Casilla[][] c1 = toCasilla(m5);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][2]);
            op1.add(c1[2][2]);
            op1.add(c1[4][2]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[2][0]);
            op2.add(c1[2][2]);
            op2.add(c1[2][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[4][2]);
            op3.add(c1[4][4]);
            op3.add(c1[4][6]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][2]);
            op4.add(c1[4][4]);
            op4.add(c1[4][6]);
            /*
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[0][6]);
            op5.add(c1[2][6]);
            op5.add(c1[4][6]);
            */
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[6][2]);
            op6.add(c1[6][4]);
            op6.add(c1[6][6]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[6][6]);
            op7.add(c1[8][6]);
            op7.add(c1[10][6]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[10][4]);
            op8.add(c1[10][6]);
            op8.add(c1[10][8]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[8][8]);
            op9.add(c1[8][10]);
            op9.add(c1[8][12]);
            ArrayList<Casilla> op10 = new ArrayList<>();
            op10.add(c1[8][8]);
            op10.add(c1[10][8]);
            op10.add(c1[12][8]);
        
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            //ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            ops.add(op10);
            
            operaciones = ops;
            
            matrizRes = m5;
        }
    }
    
    private void addMultiplicaciones(int n)
    {
        if (n == 1)
        {
            char[][] m1 =  {{'1','*','1','=','1','#','#','#','#','#','#','#','#'},
                            {'*','#','*','#','#','#','#','#','#','#','#','#','#'},
                            {'4','#','3','#','#','#','#','#','#','#','#','#','#'},
                            {'=','#','=','#','#','#','#','#','#','#','#','#','#'},
                            {'4','#','3','*','2','=','6','#','2','*','3','=','6'},
                            {'#','#','#','#','*','#','#','#','*','#','*','#','#'},
                            {'2','*','4','=','4','#','#','#','4','#','3','#','#'},
                            {'#','#','#','#','=','#','#','#','=','#','=','#','#'},
                            {'#','#','#','#','8','*','1','=','8','#','9','#','#'},
                            {'#','#','#','#','#','#','*','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','2','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','=','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','2','*','3','=','6','#','#'}};
            
            Casilla[][] c1 = toCasilla(m1);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[0][2]);
            op1.add(c1[0][4]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[0][0]);
            op2.add(c1[2][0]);
            op2.add(c1[4][0]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[0][2]);
            op3.add(c1[2][2]);
            op3.add(c1[4][2]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][2]);
            op4.add(c1[4][4]);
            op4.add(c1[4][6]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[4][4]);
            op5.add(c1[6][4]);
            op5.add(c1[8][4]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[6][0]);
            op6.add(c1[6][2]);
            op6.add(c1[6][4]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[8][4]);
            op7.add(c1[8][6]);
            op7.add(c1[8][8]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[8][6]);
            op8.add(c1[10][6]);
            op8.add(c1[12][6]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[12][6]);
            op9.add(c1[12][8]);
            op9.add(c1[12][10]);
            ArrayList<Casilla> op10 = new ArrayList<>();
            op10.add(c1[4][8]);
            op10.add(c1[4][10]);
            op10.add(c1[4][12]);
            /*
            ArrayList<Casilla> op11 = new ArrayList<>();
            op11.add(c1[0][12]);
            op11.add(c1[2][12]);
            op11.add(c1[4][12]);
            */
            ArrayList<Casilla> op12 = new ArrayList<>();
            op12.add(c1[4][8]);
            op12.add(c1[6][8]);
            op12.add(c1[8][8]);
            ArrayList<Casilla> op13 = new ArrayList<>();
            op13.add(c1[4][10]);
            op13.add(c1[6][10]);
            op13.add(c1[8][10]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            ops.add(op10);
            //ops.add(op11);
            ops.add(op12);
            ops.add(op13);
            
            operaciones = ops;
            
            matrizRes = m1;
        }
        
        if (n == 2)
        {
            char[][] m2 =  {{'1','*','3','=','3','#','1','#','#','#','#','#','#'},
                            {'*','#','#','#','*','#','*','#','#','#','#','#','#'},
                            {'2','#','#','#','2','#','1','#','#','#','#','#','#'},
                            {'=','#','#','#','=','#','=','#','#','#','#','#','#'},
                            {'2','*','3','=','6','*','1','=','6','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','*','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','1','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','=','#','#','#','#'},
                            {'#','#','#','#','3','*','2','=','6','*','1','=','6'},
                            {'#','#','#','#','#','#','*','#','#','#','*','#','#'},
                            {'#','#','#','#','#','#','1','#','#','#','4','#','#'},
                            {'#','#','#','#','#','#','=','#','#','#','=','#','#'},
                            {'#','#','#','#','#','#','2','*','2','=','4','#','#'}};
            
            Casilla[][] c1 = toCasilla(m2);
            
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[0][2]);
            op1.add(c1[0][4]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[0][0]);
            op2.add(c1[2][0]);
            op2.add(c1[4][0]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[0][4]);
            op3.add(c1[2][4]);
            op3.add(c1[4][4]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][0]);
            op4.add(c1[4][2]);
            op4.add(c1[4][4]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[0][6]);
            op5.add(c1[2][6]);
            op5.add(c1[4][6]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[4][4]);
            op6.add(c1[4][6]);
            op6.add(c1[4][8]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[4][8]);
            op7.add(c1[6][8]);
            op7.add(c1[8][8]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[8][4]);
            op8.add(c1[8][6]);
            op8.add(c1[8][8]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[8][8]);
            op9.add(c1[8][10]);
            op9.add(c1[8][12]);
            ArrayList<Casilla> op10 = new ArrayList<>();
            op10.add(c1[8][6]);
            op10.add(c1[10][6]);
            op10.add(c1[12][6]);
            ArrayList<Casilla> op11 = new ArrayList<>();
            op11.add(c1[12][6]);
            op11.add(c1[12][8]);
            op11.add(c1[12][10]);
            ArrayList<Casilla> op12 = new ArrayList<>();
            op12.add(c1[8][10]);
            op12.add(c1[10][10]);
            op12.add(c1[12][10]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            ops.add(op10);
            ops.add(op11);
            ops.add(op12);
            
            operaciones = ops;
            
            matrizRes = m2;
        }
        
        if (n == 3)
        {
            char[][] m3 =  {{'2','#','#','#','#','#','#','#','#','#','#','#','#'},
                            {'*','#','#','#','#','#','#','#','#','#','#','#','#'},
                            {'2','#','#','#','#','#','#','#','#','#','#','#','#'},
                            {'=','#','#','#','#','#','#','#','#','#','#','#','#'},
                            {'4','*','1','=','4','#','#','#','#','#','#','#','#'},
                            {'#','#','*','#','*','#','#','#','#','#','#','#','#'},
                            {'#','#','5','#','2','*','3','=','6','#','#','#','2'},
                            {'#','#','=','#','=','#','#','#','#','#','#','#','*'},
                            {'#','#','5','#','8','*','1','=','8','#','#','#','2'},
                            {'#','#','#','#','#','#','#','#','*','#','#','#','='},
                            {'#','#','#','#','#','#','#','#','1','*','4','=','4'},
                            {'#','#','#','#','#','#','#','#','=','#','#','#','#'},
                            {'#','#','#','#','4','*','2','=','8','#','#','#','#'}};
            
            Casilla[][] c1 = toCasilla(m3);
            
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[2][0]);
            op1.add(c1[4][0]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[4][0]);
            op2.add(c1[4][2]);
            op2.add(c1[4][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[4][2]);
            op3.add(c1[6][2]);
            op3.add(c1[8][2]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][4]);
            op4.add(c1[6][4]);
            op4.add(c1[8][4]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[6][4]);
            op5.add(c1[6][6]);
            op5.add(c1[6][8]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[8][4]);
            op6.add(c1[8][6]);
            op6.add(c1[8][8]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[8][8]);
            op7.add(c1[10][8]);
            op7.add(c1[12][8]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[12][4]);
            op8.add(c1[12][6]);
            op8.add(c1[12][8]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[10][8]);
            op9.add(c1[10][10]);
            op9.add(c1[10][12]);
            ArrayList<Casilla> op10 = new ArrayList<>();
            op10.add(c1[6][12]);
            op10.add(c1[8][12]);
            op10.add(c1[10][12]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            ops.add(op10);
            
            operaciones = ops;
            
            matrizRes = m3;
        }
        
        if (n == 4)
        {
            char[][] m4 =  {{'1','*','5','=','5','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','*','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','1','*','4','=','4','#','#','#','#'},
                            {'#','#','#','#','=','#','#','#','*','#','#','#','#'},
                            {'#','#','1','*','5','=','5','#','2','#','#','#','#'},
                            {'#','#','*','#','#','#','#','#','=','#','#','#','#'},
                            {'#','#','2','#','#','#','#','#','8','*','1','=','8'},
                            {'#','#','=','#','#','#','#','#','#','#','*','#','#'},
                            {'#','#','2','*','2','=','4','#','#','#','6','#','#'},
                            {'#','#','#','#','#','#','*','#','#','#','=','#','#'},
                            {'#','#','#','#','#','#','2','#','#','#','6','#','#'},
                            {'#','#','#','#','#','#','=','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','8','#','#','#','#','#','#'}};
            
            Casilla[][] c1 = toCasilla(m4);
            
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[0][2]);
            op1.add(c1[0][4]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[0][4]);
            op2.add(c1[2][4]);
            op2.add(c1[4][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[4][2]);
            op3.add(c1[4][4]);
            op3.add(c1[4][6]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][2]);
            op4.add(c1[6][2]);
            op4.add(c1[8][2]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[8][2]);
            op5.add(c1[8][4]);
            op5.add(c1[8][6]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[8][6]);
            op6.add(c1[10][6]);
            op6.add(c1[12][6]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[2][4]);
            op7.add(c1[2][6]);
            op7.add(c1[2][8]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[2][8]);
            op8.add(c1[4][8]);
            op8.add(c1[6][8]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[6][8]);
            op9.add(c1[6][10]);
            op9.add(c1[6][12]);
            ArrayList<Casilla> op10 = new ArrayList<>();
            op10.add(c1[6][10]);
            op10.add(c1[8][10]);
            op10.add(c1[10][10]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            ops.add(op10);
            
            operaciones = ops;
            
            matrizRes = m4;
        }
        
        if (n == 5)
        {
            char[][] m5 =  {{'2','#','#','#','#','#','#','#','#','#','#','#','#'},
                            {'*','#','#','#','#','#','#','#','#','#','#','#','#'},
                            {'3','*','1','=','3','#','#','#','#','#','#','#','#'},
                            {'=','#','#','#','*','#','#','#','#','#','#','#','#'},
                            {'6','#','#','#','2','*','4','=','8','#','#','#','#'},
                            {'#','#','#','#','=','#','#','#','*','#','#','#','#'},
                            {'#','#','#','#','6','#','#','#','1','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','=','#','#','#','#'},
                            {'#','#','#','#','4','*','2','=','8','#','#','#','#'},
                            {'#','#','#','#','#','#','*','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','3','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','=','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','6','#','#','#','#','#','#'}};
        
            Casilla[][] c1 = toCasilla(m5);
            
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[2][0]);
            op1.add(c1[4][0]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[2][0]);
            op2.add(c1[2][2]);
            op2.add(c1[2][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[2][4]);
            op3.add(c1[4][4]);
            op3.add(c1[6][4]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][4]);
            op4.add(c1[4][6]);
            op4.add(c1[4][8]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[4][8]);
            op5.add(c1[6][8]);
            op5.add(c1[8][8]);
            /*
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[6][8]);
            op6.add(c1[6][10]);
            op6.add(c1[6][12]);
            */
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[8][4]);
            op7.add(c1[8][6]);
            op7.add(c1[8][8]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[8][6]);
            op8.add(c1[10][6]);
            op8.add(c1[12][6]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            //ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            
            operaciones = ops;
            
            matrizRes = m5;
        }
    }
    
    private void addDivisiones(int n)
    {
        if (n == 1)
        {
            char[][] m1 =  {{'9','÷','1','=','9','#','#','#','#','#','#','#','#'},
                            {'÷','#','#','#','÷','#','#','#','#','#','#','#','#'},
                            {'9','#','#','#','3','÷','=','3','#','#','#','#','#'},
                            {'=','#','#','#','=','#','#','#','#','#','#','#','#'},
                            {'1','#','6','÷','3','=','2','#','#','#','#','#','#'},
                            {'#','#','÷','#','#','#','#','#','#','#','#','#','#'},
                            {'#','#','1','#','8','#','#','#','#','#','#','#','#'},
                            {'#','#','=','#','÷','#','#','#','#','#','#','#','#'},
                            {'#','#','6','÷','2','=','3','#','8','#','#','#','#'},
                            {'#','#','#','#','=','#','#','#','÷','#','#','#','#'},
                            {'#','#','#','#','4','÷','4','=','1','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','=','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','8','÷','4','=','1'}};
        
            Casilla[][] c1 = toCasilla(m1);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[0][2]);
            op1.add(c1[0][4]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[0][0]);
            op2.add(c1[2][0]);
            op2.add(c1[4][0]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[0][4]);
            op3.add(c1[2][4]);
            op3.add(c1[4][4]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[2][4]);
            op4.add(c1[2][6]);
            op4.add(c1[2][8]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[4][2]);
            op5.add(c1[4][4]);
            op5.add(c1[4][6]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[4][2]);
            op6.add(c1[6][2]);
            op6.add(c1[8][2]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[8][2]);
            op7.add(c1[8][4]);
            op7.add(c1[8][6]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[6][4]);
            op8.add(c1[8][4]);
            op8.add(c1[10][4]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[10][4]);
            op9.add(c1[10][6]);
            op9.add(c1[10][8]);
            ArrayList<Casilla> op10 = new ArrayList<>();
            op10.add(c1[8][8]);
            op10.add(c1[10][8]);
            op10.add(c1[12][8]);
            ArrayList<Casilla> op11 = new ArrayList<>();
            op11.add(c1[12][8]);
            op11.add(c1[12][10]);
            op11.add(c1[12][12]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            ops.add(op10);
            ops.add(op11);
            
            operaciones = ops;
            
            matrizRes = m1;
        }
        
        if (n == 2)
        {
            char[][] m2 =  {{'8','÷','1','=','8','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','÷','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','4','#','#','#','6','÷','3','=','2'},
                            {'#','#','#','#','=','#','#','#','÷','#','#','#','#'},
                            {'#','#','#','#','2','÷','1','=','2','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','=','#','#','#','#'},
                            {'#','#','#','#','#','#','9','÷','3','=','3','#','#'},
                            {'#','#','#','#','#','#','#','#','#','#','÷','#','#'},
                            {'#','#','#','#','#','#','#','#','8','#','3','#','#'},
                            {'#','#','#','#','#','#','#','#','÷','#','=','#','#'},
                            {'#','#','#','#','#','#','#','#','2','÷','1','=','2'},
                            {'#','#','#','#','#','#','#','#','=','#','#','#','#'},
                            {'#','#','#','#','#','#','#','#','4','#','#','#','#'}};
            
            Casilla[][] c1 = toCasilla(m2);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[0][2]);
            op1.add(c1[0][4]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[0][4]);
            op2.add(c1[2][4]);
            op2.add(c1[4][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[4][4]);
            op3.add(c1[4][6]);
            op3.add(c1[4][8]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[2][8]);
            op4.add(c1[2][10]);
            op4.add(c1[2][12]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[2][8]);
            op5.add(c1[4][8]);
            op5.add(c1[6][8]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[6][6]);
            op6.add(c1[6][8]);
            op6.add(c1[6][10]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[6][10]);
            op7.add(c1[8][10]);
            op7.add(c1[10][10]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[10][8]);
            op8.add(c1[10][10]);
            op8.add(c1[10][12]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[8][8]);
            op9.add(c1[10][8]);
            op9.add(c1[12][8]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            
            operaciones = ops;
            
            matrizRes = m2;
        }
        
        if (n == 3)
        {
            char[][] m3 =  {{'6','÷','3','=','2','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','÷','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','1','#','#','#','#','#','6','#','#'},
                            {'#','#','#','#','=','#','#','#','#','#','÷','#','#'},
                            {'#','#','8','÷','2','=','4','÷','2','=','2','#','9'},
                            {'#','#','#','#','#','#','#','#','#','#','=','#','÷'},
                            {'#','#','#','#','#','#','#','#','9','÷','3','=','3'},
                            {'#','#','#','#','#','#','#','#','÷','#','#','#','='},
                            {'#','#','#','#','#','#','#','#','1','#','#','#','3'},
                            {'#','#','#','#','#','#','#','#','=','#','#','#','÷'},
                            {'#','#','#','#','#','#','#','#','9','÷','3','=','3'},
                            {'#','#','#','#','#','#','#','#','#','#','#','#','='},
                            {'#','#','#','#','#','#','#','#','#','#','#','#','1'}};
            
            Casilla[][] c1 = toCasilla(m3);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[0][2]);
            op1.add(c1[0][4]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[0][4]);
            op2.add(c1[2][4]);
            op2.add(c1[4][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[4][2]);
            op3.add(c1[4][4]);
            op3.add(c1[4][6]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][6]);
            op4.add(c1[4][8]);
            op4.add(c1[4][10]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[2][10]);
            op5.add(c1[4][10]);
            op5.add(c1[6][10]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[6][8]);
            op6.add(c1[6][10]);
            op6.add(c1[6][12]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[8][12]);
            op7.add(c1[10][12]);
            op7.add(c1[12][12]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[4][12]);
            op8.add(c1[6][12]);
            op8.add(c1[8][12]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[6][8]);
            op9.add(c1[8][8]);
            op9.add(c1[10][8]);
            ArrayList<Casilla> op10 = new ArrayList<>();
            op10.add(c1[10][8]);
            op10.add(c1[10][10]);
            op10.add(c1[10][12]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            ops.add(op10);
            
            operaciones = ops;
            
            matrizRes = m3;
        }
        
        if (n == 4)
        {
            char[][] m4 =  {{'2','#','#','#','#','#','#','#','#','#','#','#','#'},
                            {'÷','#','#','#','#','#','#','#','#','#','#','#','#'},
                            {'2','#','#','#','8','#','#','#','#','#','#','#','#'},
                            {'=','#','#','#','÷','#','#','#','#','#','#','#','#'},
                            {'1','÷','1','=','1','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','=','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','8','#','#','#','#','#','9','#','#'},
                            {'#','#','#','#','÷','#','#','#','#','#','÷','#','#'},
                            {'#','#','#','#','4','#','9','÷','1','=','9','#','#'},
                            {'#','#','#','#','=','#','÷','#','#','#','=','#','#'},
                            {'#','#','6','÷','2','=','3','#','1','÷','1','=','1'},
                            {'#','#','#','#','#','#','=','#','#','#','#','#','#'},
                            {'#','#','#','#','6','÷','3','=','2','#','#','#','#'}};
        
            Casilla[][] c1 = toCasilla(m4);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[2][0]);
            op1.add(c1[4][0]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[4][0]);
            op2.add(c1[4][2]);
            op2.add(c1[4][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[2][4]);
            op3.add(c1[4][4]);
            op3.add(c1[6][4]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[6][4]);
            op4.add(c1[8][4]);
            op4.add(c1[10][4]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[10][2]);
            op5.add(c1[10][4]);
            op5.add(c1[10][6]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[8][6]);
            op6.add(c1[8][8]);
            op6.add(c1[8][10]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[6][10]);
            op7.add(c1[8][10]);
            op7.add(c1[10][10]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[10][8]);
            op8.add(c1[10][10]);
            op8.add(c1[10][12]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[8][6]);
            op9.add(c1[10][6]);
            op9.add(c1[12][6]);
            ArrayList<Casilla> op10 = new ArrayList<>();
            op10.add(c1[12][4]);
            op10.add(c1[12][6]);
            op10.add(c1[12][8]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            ops.add(op10);
            
            operaciones = ops;
            
            matrizRes = m4;
        }
        
        if (n == 5)
        {
            char[][] m5 =  {{'8','#','#','#','#','#','#','#','#','#','#','#','#'},
                            {'÷','#','#','#','#','#','#','#','#','#','#','#','#'},
                            {'2','#','#','#','8','#','#','#','#','#','#','#','#'},
                            {'=','#','#','#','÷','#','#','#','#','#','#','#','#'},
                            {'4','÷','1','=','4','#','9','#','#','#','#','#','#'},
                            {'#','#','#','#','=','#','÷','#','#','#','#','#','#'},
                            {'#','#','2','÷','2','=','1','#','#','#','9','#','#'},
                            {'#','#','#','#','#','#','=','#','#','#','÷','#','#'},
                            {'#','#','#','#','#','#','9','÷','3','=','3','#','8'},
                            {'#','#','#','#','#','#','#','#','#','#','=','#','÷'},
                            {'#','#','#','#','#','#','#','#','6','÷','3','=','2'},
                            {'#','#','#','#','#','#','#','#','#','#','#','#','='},
                            {'#','#','#','#','#','#','#','#','#','#','#','#','4'}};
        
            Casilla[][] c1 = toCasilla(m5);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[2][0]);
            op1.add(c1[4][0]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[4][0]);
            op2.add(c1[4][2]);
            op2.add(c1[4][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[2][4]);
            op3.add(c1[4][4]);
            op3.add(c1[6][4]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[6][2]);
            op4.add(c1[6][4]);
            op4.add(c1[6][6]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[4][6]);
            op5.add(c1[6][6]);
            op5.add(c1[8][6]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[8][6]);
            op6.add(c1[8][8]);
            op6.add(c1[8][10]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[6][10]);
            op7.add(c1[8][10]);
            op7.add(c1[10][10]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[10][8]);
            op8.add(c1[10][10]);
            op8.add(c1[10][12]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[8][12]);
            op9.add(c1[10][12]);
            op9.add(c1[12][12]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            
            operaciones = ops;
            
            matrizRes = m5;
        }
    }
    
    private void addCombinado(int n)
    {
        if (n == 1)
        {
            char[][] m1 =  {{'8','-','2','=','6','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','+','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','3','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','=','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','9','÷','3','=','3','#','#','#','#'},
                            {'#','#','#','#','#','#','+','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','2','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','=','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','5','-','1','=','4','#','#'},
                            {'#','#','#','#','#','#','#','#','#','#','*','#','#'},
                            {'#','#','#','#','#','#','#','#','#','#','2','#','#'},
                            {'#','#','#','#','#','#','#','#','#','#','=','#','#'},
                            {'#','#','#','#','#','#','#','#','9','-','8','=','1'}};
            
            Casilla[][] c1 = toCasilla(m1);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[0][2]);
            op1.add(c1[0][4]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[0][4]);
            op2.add(c1[2][4]);
            op2.add(c1[4][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[4][4]);
            op3.add(c1[6][6]);
            op3.add(c1[8][8]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][6]);
            op4.add(c1[6][6]);
            op4.add(c1[8][6]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[8][6]);
            op5.add(c1[8][8]);
            op5.add(c1[8][10]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[8][10]);
            op6.add(c1[10][10]);
            op6.add(c1[12][10]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[12][8]);
            op7.add(c1[12][10]);
            op7.add(c1[12][12]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            
            operaciones = ops;
            
            matrizRes = m1;
        }
        
        if (n == 2)
        {
            char[][] m2 =  {{'5','#','#','#','#','#','#','#','#','#','#','#','#'},
                            {'-','#','#','#','#','#','#','#','#','#','#','#','#'},
                            {'4','#','#','#','2','#','#','#','#','#','#','#','#'},
                            {'=','#','#','#','*','#','#','#','#','#','#','#','#'},
                            {'1','+','3','=','4','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','=','#','#','#','#','#','#','#','#'},
                            {'#','#','#','#','8','÷','4','=','2','#','#','#','#'},
                            {'#','#','#','#','#','#','-','#','#','#','#','#','#'},
                            {'#','#','#','#','#','#','3','#','#','#','8','#','#'},
                            {'#','#','#','#','#','#','=','#','#','#','÷','#','#'},
                            {'#','#','#','#','#','#','1','*','4','=','4','#','#'},
                            {'#','#','#','#','#','#','#','#','#','#','=','#','#'},
                            {'#','#','#','#','#','#','#','#','#','#','2','=','4'}};
            
            Casilla[][] c1 = toCasilla(m2);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][0]);
            op1.add(c1[2][0]);
            op1.add(c1[4][0]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[4][0]);
            op2.add(c1[4][2]);
            op2.add(c1[4][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[2][4]);
            op3.add(c1[4][4]);
            op3.add(c1[6][4]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[6][4]);
            op4.add(c1[6][6]);
            op4.add(c1[6][8]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[6][6]);
            op5.add(c1[8][6]);
            op5.add(c1[10][6]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[10][6]);
            op6.add(c1[10][8]);
            op6.add(c1[10][10]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[8][10]);
            op7.add(c1[10][10]);
            op7.add(c1[12][10]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[12][8]);
            op8.add(c1[12][10]);
            op8.add(c1[12][12]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            
            operaciones = ops;
            
            matrizRes = m2;
        }
        
        if (n == 3)
        {
            char[][] m3 =  {{'#','#','8','#','#','#','#','#','#','#','#','#','#'},
                            {'#','#','-','#','#','#','#','#','#','#','#','#','#'},
                            {'4','÷','2','=','2','#','#','#','#','#','#','#','#'},
                            {'#','#','=','#','*','#','#','#','#','#','#','#','#'},
                            {'#','#','6','#','3','+','6','=','9','#','#','#','#'},
                            {'#','#','#','#','=','#','#','#','-','#','#','#','#'},
                            {'#','#','#','#','6','#','#','#','4','#','6','#','#'},
                            {'#','#','#','#','#','#','#','#','=','#','-','#','#'},
                            {'#','#','#','#','#','#','7','-','5','=','2','#','9'},
                            {'#','#','#','#','#','#','#','#','#','#','=','#','-'},
                            {'#','#','#','#','#','#','#','#','3','+','4','=','7'},
                            {'#','#','#','#','#','#','#','#','#','#','#','#','='},
                            {'#','#','#','#','#','#','#','#','#','#','#','#','2'}};
            
            Casilla[][] c1 = toCasilla(m3);
            ArrayList<Casilla> op1 = new ArrayList<>();
            op1.add(c1[0][2]);
            op1.add(c1[2][2]);
            op1.add(c1[4][2]);
            ArrayList<Casilla> op2 = new ArrayList<>();
            op2.add(c1[2][0]);
            op2.add(c1[2][2]);
            op2.add(c1[2][4]);
            ArrayList<Casilla> op3 = new ArrayList<>();
            op3.add(c1[2][4]);
            op3.add(c1[4][4]);
            op3.add(c1[6][4]);
            ArrayList<Casilla> op4 = new ArrayList<>();
            op4.add(c1[4][4]);
            op4.add(c1[4][6]);
            op4.add(c1[4][8]);
            ArrayList<Casilla> op5 = new ArrayList<>();
            op5.add(c1[4][8]);
            op5.add(c1[6][8]);
            op5.add(c1[8][8]);
            ArrayList<Casilla> op6 = new ArrayList<>();
            op6.add(c1[8][6]);
            op6.add(c1[8][8]);
            op6.add(c1[8][10]);
            ArrayList<Casilla> op7 = new ArrayList<>();
            op7.add(c1[6][10]);
            op7.add(c1[8][10]);
            op7.add(c1[10][10]);
            ArrayList<Casilla> op8 = new ArrayList<>();
            op8.add(c1[10][8]);
            op8.add(c1[10][10]);
            op8.add(c1[10][12]);
            ArrayList<Casilla> op9 = new ArrayList<>();
            op9.add(c1[8][12]);
            op9.add(c1[10][12]);
            op9.add(c1[12][12]);
            
            ArrayList<ArrayList<Casilla>> ops = new ArrayList<>();
            ops.add(op1);
            ops.add(op2);
            ops.add(op3);
            ops.add(op4);
            ops.add(op5);
            ops.add(op6);
            ops.add(op7);
            ops.add(op8);
            ops.add(op9);
            
            operaciones = ops;
            
            matrizRes = m3;
        }
    }
    
    public char[][] quitarNum(char[][] mat)
    {
        char[][] aux = clonar(matrizRes);
        
        for (int i = 0; i < operaciones.size(); i++)
        {
            int rand = getRandom(1, 3);
            aux[operaciones.get(i).get(rand).getX()][operaciones.get(i).get(rand).getY()] = '@';
        }
                
        return aux;
    }
    
    public Casilla[][] toCasilla(char[][] mat)
    {
        Casilla[][] aux = new Casilla[13][13];
        for (int i = 0; i < 13; i++)
            for(int j = 0; j < 13; j++)
                aux[i][j] = new Casilla(i, j, mat[i][j]);
        return aux;
    }
    
    public int getRandom(int min, int max) 
    {
        return (int) ((Math.random() * (max - min)) + min);
    }   
}
