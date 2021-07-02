/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.crucigrama;

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
public class CrucigramaTest {
    
    public CrucigramaTest() {
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
     * Test of getCondicion method, of class Crucigrama.
     */
    @Test
    public void testGetCondicion() {
        System.out.println("getCondicion");
        Crucigrama instance = null;
        String expResult = "";
        String result = instance.getCondicion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVidas method, of class Crucigrama.
     */
    @Test
    public void testSetVidas() {
        System.out.println("setVidas");
        Crucigrama instance = null;
        instance.setVidas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restaurarVidas method, of class Crucigrama.
     */
    @Test
    public void testRestaurarVidas() {
        System.out.println("restaurarVidas");
        Crucigrama instance = null;
        instance.restaurarVidas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVidas method, of class Crucigrama.
     */
    @Test
    public void testGetVidas() {
        System.out.println("getVidas");
        Crucigrama instance = null;
        int expResult = 0;
        int result = instance.getVidas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitulo method, of class Crucigrama.
     */
    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        Crucigrama instance = null;
        String expResult = "";
        String result = instance.getTitulo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarMatriz method, of class Crucigrama.
     */
    @Test
    public void testMostrarMatriz() {
        System.out.println("mostrarMatriz");
        Crucigrama instance = null;
        instance.mostrarMatriz();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCrucigramaMatriz method, of class Crucigrama.
     */
    @Test
    public void testGetCrucigramaMatriz() {
        System.out.println("getCrucigramaMatriz");
        Crucigrama instance = null;
        char[][] expResult = null;
        char[][] result = instance.getCrucigramaMatriz();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatrizAux method, of class Crucigrama.
     */
    @Test
    public void testGetMatrizAux() {
        System.out.println("getMatrizAux");
        Crucigrama instance = null;
        char[][] expResult = null;
        char[][] result = instance.getMatrizAux();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
