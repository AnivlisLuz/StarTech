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
 * @author Carlos
 */
public class PlantillaTest {
    
    public PlantillaTest() {
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
     * Test of getMatriz method, of class Plantilla.
     */
    @Test
    public void testGetMatriz() {
        System.out.println("getMatriz");
        Plantilla suma = new Plantilla("suma");
        char[][] result = suma.getMatriz();
        assertTrue(result.equals(suma.getMatriz()));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatizRes method, of class Plantilla.
     */
    @Test
    public void testGetMatizRes() {
        System.out.println("getMatizRes");
        Plantilla instance = null;
        char[][] expResult = null;
        char[][] result = instance.getMatizRes();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
