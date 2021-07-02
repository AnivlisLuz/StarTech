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
public class MatrizCombinadoTest {
    
    public MatrizCombinadoTest() {
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
     * Test of getMatriz method, of class MatrizCombinado.
     */
    @Test
    public void testGetMatriz() {
        System.out.println("getMatriz");
        MatrizCombinado instance = new MatrizCombinado();
        String[][] expResult = null;
        String[][] result = instance.getMatriz();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatrizRes method, of class MatrizCombinado.
     */
    @Test
    public void testGetMatrizRes() {
        System.out.println("getMatrizRes");
        MatrizCombinado instance = new MatrizCombinado();
        String[][] expResult = null;
        String[][] result = instance.getMatrizRes();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MatrizCombinado.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MatrizCombinado.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
