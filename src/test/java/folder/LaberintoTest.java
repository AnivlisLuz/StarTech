/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.folder;

import app.startech.laberintos.Laberinto;
import app.startech.laberintos.Matriz;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author luzch
 */
public class LaberintoTest {
    
    public LaberintoTest() {
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
     * Test of getCondicion method, of class Laberinto.
     */
    @Test
    public void testGetCondicion() {
        System.out.println("getCondicion");
        Laberinto instance = null;
        String expResult = "";
        String result = instance.getCondicion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVidas method, of class Laberinto.
     */
    @Test
    public void testSetVidas() {
        System.out.println("setVidas");
        Laberinto instance = null;
        instance.setVidas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restaurarVidas method, of class Laberinto.
     */
    @Test
    public void testRestaurarVidas() {
        System.out.println("restaurarVidas");
        Laberinto instance = null;
        instance.restaurarVidas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVidas method, of class Laberinto.
     */
    @Test
    public void testGetVidas() {
        System.out.println("getVidas");
        Laberinto instance = null;
        int expResult = 0;
        int result = instance.getVidas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitulo method, of class Laberinto.
     */
    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        Laberinto instance = null;
        String expResult = "";
        String result = instance.getTitulo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMensaje method, of class Laberinto.
     */
    @Test
    public void testGetMensaje() {
        System.out.println("getMensaje");
        Laberinto instance = null;
        String expResult = "";
        String result = instance.getMensaje();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarMatriz method, of class Laberinto.
     */
    @Test
    public void testMostrarMatriz() {
        System.out.println("mostrarMatriz");
        Laberinto instance = null;
        instance.mostrarMatriz();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatriz method, of class Laberinto.
     */
    @Test
    public void testGetMatriz() {
        System.out.println("getMatriz");
        Laberinto instance = null;
        Matriz expResult = null;
        Matriz result = instance.getMatriz();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
