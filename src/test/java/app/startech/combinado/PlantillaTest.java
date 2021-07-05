/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.combinado;

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
        Plantilla instance = new Plantilla();
        String[][] expResult = null;
        String[][] result = null;
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMatrizRes method, of class Plantilla.
     */
    @Test
    public void testGetMatrizRes() {
        System.out.println("getMatrizRes");
        Plantilla instance = new Plantilla();
        String[][] expResult = null;
        String[][] result = null;
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of getOperacion method, of class Plantilla.
     */
    @Test
    public void testGetOperacion() {
        System.out.println("getOperacion");
        int n = 5;
        int m = 10;
        Plantilla instance = new Plantilla();
        String expResult = "*2";
        String result = instance.getOperacion(n, m);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMultiplo method, of class Plantilla.
     */
    @Test
    public void testGetMultiplo() {
        System.out.println("getMultiplo");
        int menor = 5;
        int mayor = 10;
        Plantilla instance = new Plantilla();
        int expResult = 2;
        int result = instance.getMultiplo(menor, mayor);
        assertEquals(expResult, result);
    }
    
}
