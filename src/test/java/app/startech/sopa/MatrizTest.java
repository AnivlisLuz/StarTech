/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.sopa;

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
public class MatrizTest {
    
    public MatrizTest() {
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
     * Test of anadir method, of class Matriz.
     */
    @Test
    public void testAnadir() {
        System.out.println("anadir");
        Cuadro nuevo = null;
        Matriz instance = null;
        instance.anadir(nuevo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatriz method, of class Matriz.
     */
    @Test
    public void testGetMatriz() {
        System.out.println("getMatriz");
        Matriz instance = null;
        Cuadro[][] expResult = null;
        Cuadro[][] result = instance.getMatriz();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
