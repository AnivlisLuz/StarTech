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
public class MatrizCrucigramaTest {
    
    public MatrizCrucigramaTest() {
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
     * Test of getMat method, of class MatrizCrucigrama.
     */
    @Test
    public void testGetMat() {
        System.out.println("getMat");
        MatrizCrucigrama instance = null;
        char[][] expResult = null;
        char[][] result = instance.getMat();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatRes method, of class MatrizCrucigrama.
     */
    @Test
    public void testGetMatRes() {
        System.out.println("getMatRes");
        MatrizCrucigrama instance = null;
        char[][] expResult = null;
        char[][] result = instance.getMatRes();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
