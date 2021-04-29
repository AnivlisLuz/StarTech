/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberintoc;

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
public class CasillaTest {
    
    public CasillaTest() {
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
     * Test of addVecino method, of class Casilla.
     */
    @Test
    public void testAddVecino() {
        System.out.println("addVecino");
        Casilla casilla = null;
        Casilla instance = null;
        instance.addVecino(casilla);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estaDebajo method, of class Casilla.
     */
    @Test
    public void testEstaDebajo() {
        System.out.println("estaDebajo");
        Casilla instance = null;
        boolean expResult = false;
        boolean result = instance.estaDebajo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estaDerecha method, of class Casilla.
     */
    @Test
    public void testEstaDerecha() {
        System.out.println("estaDerecha");
        Casilla instance = null;
        boolean expResult = false;
        boolean result = instance.estaDerecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esCasilla method, of class Casilla.
     */
    @Test
    public void testEsCasilla() {
        System.out.println("esCasilla");
        Casilla instance = null;
        boolean expResult = false;
        boolean result = instance.esCasilla();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Casilla.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Casilla instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Casilla.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object casilla = null;
        Casilla instance = null;
        boolean expResult = false;
        boolean result = instance.equals(casilla);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Casilla.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Casilla instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
