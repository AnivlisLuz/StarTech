/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberintoc;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author luzch
 */
public class LaberintoCTest {
    
    public LaberintoCTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getCasilla method, of class LaberintoC.
     */
    @Test
    public void testGetCasilla() {
        System.out.println("getCasilla");
        int x = 0;
        int y = 0;
        LaberintoC instance = null;
        Casilla expResult = null;
        Casilla result = instance.getCasilla(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class LaberintoC.
     */
    @Test
    public void testSolve_0args() {
        System.out.println("solve");
        LaberintoC instance = null;
        instance.solve();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class LaberintoC.
     */
    @Test
    public void testSolve_4args() {
        System.out.println("solve");
        int iniX = 0;
        int iniY = 0;
        int finX = 0;
        int finY = 0;
        LaberintoC instance = null;
        instance.solve(iniX, iniY, finX, finY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDistancia method, of class LaberintoC.
     */
    @Test
    public void testGetDistancia() {
        System.out.println("getDistancia");
        Casilla act = null;
        double pisada = 0.0;
        Casilla fin = null;
        LaberintoC instance = null;
        double expResult = 0.0;
        double result = instance.getDistancia(act, pisada, fin);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateMat method, of class LaberintoC.
     */
    @Test
    public void testUpdateMat() {
        System.out.println("updateMat");
        LaberintoC instance = null;
        instance.updateMat();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandom method, of class LaberintoC.
     */
    @Test
    public void testGetRandom() {
        System.out.println("getRandom");
        int min = 0;
        int max = 0;
        int expResult = 0;
        int result = LaberintoC.getRandom(min, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarMatriz method, of class LaberintoC.
     */
    @Test
    public void testGenerarMatriz() {
        System.out.println("generarMatriz");
        int tamano = 0;
        LaberintoC instance = null;
        int[][] expResult = null;
        int[][] result = instance.generarMatriz(tamano);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarCamino method, of class LaberintoC.
     */
    @Test
    public void testGenerarCamino_intArrArr_int() {
        System.out.println("generarCamino");
        int[][] mat = null;
        int condicion = 0;
        LaberintoC instance = null;
        int[][] expResult = null;
        int[][] result = instance.generarCamino(mat, condicion);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarCamino method, of class LaberintoC.
     */
    @Test
    public void testGenerarCamino_4args() {
        System.out.println("generarCamino");
        int x = 0;
        int y = 0;
        int condicion = 0;
        Punto[][] mat = null;
        LaberintoC instance = null;
        int[][] expResult = null;
        int[][] result = instance.generarCamino(x, y, condicion, mat);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarJ method, of class LaberintoC.
     */
    @Test
    public void testRellenarJ() {
        System.out.println("rellenarJ");
        int[][] matAux = null;
        int condicion = 0;
        LaberintoC instance = null;
        int[][] expResult = null;
        int[][] result = instance.rellenarJ(matAux, condicion);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarJ2 method, of class LaberintoC.
     */
    @Test
    public void testRellenarJ2() {
        System.out.println("rellenarJ2");
        int[][] matAux = null;
        int condicion = 0;
        LaberintoC instance = null;
        int[][] expResult = null;
        int[][] result = instance.rellenarJ2(matAux, condicion);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarJ3 method, of class LaberintoC.
     */
    @Test
    public void testRellenarJ3() {
        System.out.println("rellenarJ3");
        int[][] matAux = null;
        int condicion = 0;
        LaberintoC instance = null;
        int[][] expResult = null;
        int[][] result = instance.rellenarJ3(matAux, condicion);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMenor method, of class LaberintoC.
     */
    @Test
    public void testGetMenor() {
        System.out.println("getMenor");
        ArrayList<Integer> arr = null;
        LaberintoC instance = null;
        int expResult = 0;
        int result = instance.getMenor(arr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMayor method, of class LaberintoC.
     */
    @Test
    public void testGetMayor() {
        System.out.println("getMayor");
        ArrayList<Integer> arr = null;
        LaberintoC instance = null;
        int expResult = 0;
        int result = instance.getMayor(arr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of noEsPared method, of class LaberintoC.
     */
    @Test
    public void testNoEsPared() {
        System.out.println("noEsPared");
        int[][] mat = null;
        int x = 0;
        int y = 0;
        LaberintoC instance = null;
        boolean expResult = false;
        boolean result = instance.noEsPared(mat, x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of genPar method, of class LaberintoC.
     */
    @Test
    public void testGenPar() {
        System.out.println("genPar");
        int[][] mat = null;
        ArrayList<Punto> camino = null;
        LaberintoC instance = null;
        int[][] expResult = null;
        int[][] result = instance.genPar(mat, camino);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPuntoMayor method, of class LaberintoC.
     */
    @Test
    public void testGetPuntoMayor() {
        System.out.println("getPuntoMayor");
        int x = 0;
        int y = 0;
        ArrayList<Punto> camino = null;
        LaberintoC instance = null;
        int expResult = 0;
        int result = instance.getPuntoMayor(x, y, camino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esValido method, of class LaberintoC.
     */
    @Test
    public void testEsValido() {
        System.out.println("esValido");
        Punto[][] mat = null;
        int x = 0;
        int y = 0;
        LaberintoC instance = null;
        boolean expResult = false;
        boolean result = instance.esValido(mat, x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCamino method, of class LaberintoC.
     */
    @Test
    public void testGetCamino() {
        System.out.println("getCamino");
        int[][] mat = null;
        LaberintoC instance = null;
        ArrayList<Punto> expResult = null;
        ArrayList<Punto> result = instance.getCamino(mat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCam method, of class LaberintoC.
     */
    @Test
    public void testGetCam() {
        System.out.println("getCam");
        int[][] mat = null;
        LaberintoC instance = null;
        ArrayList<Punto> expResult = null;
        ArrayList<Punto> result = instance.getCam(mat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenar method, of class LaberintoC.
     */
    @Test
    public void testOrdenar() {
        System.out.println("ordenar");
        ArrayList<Punto> arr = null;
        LaberintoC instance = null;
        ArrayList<Punto> expResult = null;
        ArrayList<Punto> result = instance.ordenar(arr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarCaminoMult method, of class LaberintoC.
     */
    @Test
    public void testGenerarCaminoMult() {
        System.out.println("generarCaminoMult");
        ArrayList<Punto> arr = null;
        int mult = 0;
        ArrayList<Punto> expResult = null;
        ArrayList<Punto> result = LaberintoC.generarCaminoMult(arr, mult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarMatrizMult method, of class LaberintoC.
     */
    @Test
    public void testGenerarMatrizMult() {
        System.out.println("generarMatrizMult");
        ArrayList<Punto> camino = null;
        int mult = 0;
        int[][] mat = null;
        LaberintoC instance = null;
        int[][] expResult = null;
        int[][] result = instance.generarMatrizMult(camino, mult, mat);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarCaminoSec method, of class LaberintoC.
     */
    @Test
    public void testGenerarCaminoSec() {
        System.out.println("generarCaminoSec");
        ArrayList<Punto> arr = null;
        int ini = 0;
        int condicion = 0;
        LaberintoC instance = null;
        ArrayList<Punto> expResult = null;
        ArrayList<Punto> result = instance.generarCaminoSec(arr, ini, condicion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invertirMatriz method, of class LaberintoC.
     */
    @Test
    public void testInvertirMatriz() {
        System.out.println("invertirMatriz");
        int[][] mat = null;
        LaberintoC instance = null;
        int[][] expResult = null;
        int[][] result = instance.invertirMatriz(mat);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invertirCamino method, of class LaberintoC.
     */
    @Test
    public void testInvertirCamino() {
        System.out.println("invertirCamino");
        ArrayList<Punto> camino = null;
        LaberintoC instance = null;
        ArrayList<Punto> expResult = null;
        ArrayList<Punto> result = instance.invertirCamino(camino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarMatrizSec method, of class LaberintoC.
     */
    @Test
    public void testGenerarMatrizSec() {
        System.out.println("generarMatrizSec");
        ArrayList<Punto> camino = null;
        int[][] mat = null;
        LaberintoC instance = null;
        int[][] expResult = null;
        int[][] result = instance.generarMatrizSec(camino, mat);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dibujarCamino method, of class LaberintoC.
     */
    @Test
    public void testDibujarCamino() {
        System.out.println("dibujarCamino");
        ArrayList<Punto> arr = null;
        LaberintoC instance = null;
        instance.dibujarCamino(arr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dibujarOrden method, of class LaberintoC.
     */
    @Test
    public void testDibujarOrden() {
        System.out.println("dibujarOrden");
        ArrayList<Punto> arr = null;
        LaberintoC instance = null;
        instance.dibujarOrden(arr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dibujarMatriz method, of class LaberintoC.
     */
    @Test
    public void testDibujarMatriz_intArrArr() {
        System.out.println("dibujarMatriz");
        int[][] matrix = null;
        LaberintoC instance = null;
        instance.dibujarMatriz(matrix);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dibujarMatriz method, of class LaberintoC.
     */
    @Test
    public void testDibujarMatriz_charArrArr() {
        System.out.println("dibujarMatriz");
        char[][] matrix = null;
        LaberintoC instance = null;
        instance.dibujarMatriz(matrix);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
