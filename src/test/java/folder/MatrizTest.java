/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import java.util.ArrayList;
import laberintoc.Punto;
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
     * Test of getMeta method, of class Matriz.
     */
    @Test
    public void testGetMeta() {
        System.out.println("getMeta");
        Matriz instance = null;
        Punto expResult = null;
        Punto result = instance.getMeta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarMovimiento method, of class Matriz.
     */
    @Test
    public void testVerificarMovimiento() {
        System.out.println("verificarMovimiento");
        Punto p = null;
        Matriz instance = null;
        boolean expResult = false;
        boolean result = instance.verificarMovimiento(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarLaberinto method, of class Matriz.
     */
    @Test
    public void testRellenarLaberinto() {
        System.out.println("rellenarLaberinto");
        Matriz instance = null;
        instance.rellenarLaberinto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarLaberinto method, of class Matriz.
     */
    @Test
    public void testGenerarLaberinto() {
        System.out.println("generarLaberinto");
        Matriz instance = null;
        instance.generarLaberinto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLaberinto method, of class Matriz.
     */
    @Test
    public void testGetLaberinto() {
        System.out.println("getLaberinto");
        Matriz instance = null;
        int[][] expResult = null;
        int[][] result = instance.getLaberinto();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class Matriz.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        Matriz instance = null;
        instance.reset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class MatrizImpl extends Matriz {

        public MatrizImpl() {
            super(0);
        }

        public void rellenarLaberinto() {
        }
    }
    
}
