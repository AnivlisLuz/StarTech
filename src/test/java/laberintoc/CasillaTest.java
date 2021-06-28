/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.laberintoc;

import app.startech.matriz.Casilla;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Casilla casilla = new Casilla(1,2,true);
        Casilla casilla1 = new Casilla(1,2,true);
        Casilla instance = new Casilla(1,2);
        Casilla instance1 = new Casilla(1,2);
        instance.addVecino(casilla);
        instance1.addVecino(casilla);
        assertEquals(instance1.vecinos, instance.vecinos);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of estaDebajo method, of class Casilla.
     */
    @Test
    public void testEstaDebajo() {
        System.out.println("estaDebajo");
        Casilla instance = new Casilla(1,3);
        Casilla casilla = new Casilla(1,4);
        instance.addVecino(casilla);
        boolean expResult = true;
        boolean result = instance.estaDebajo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of estaDerecha method, of class Casilla.
     */
    @Test
    public void testEstaDerecha() {
        System.out.println("estaDerecha");
        Casilla instance = new Casilla(1,3);
        Casilla casilla = new Casilla(2,3);
        instance.addVecino(casilla);
        boolean expResult = true;
        boolean result = instance.estaDerecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of esCasilla method, of class Casilla.
     */
    @Test
    public void testEsCasilla() {
        System.out.println("esCasilla");
        Casilla instance = new Casilla(1,2);
        boolean expResult = false;
        boolean result = instance.esCasilla();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class Casilla.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Casilla instance = new Casilla(1,2);
        String expResult = "Casilla(1, 2)";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class Casilla.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object casilla = new Object();
        Casilla instance = new Casilla(1,2);
        boolean expResult = false;
        boolean result = instance.equals(casilla);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hashCode method, of class Casilla.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Casilla instance = new Casilla(1,2);
        int expResult = 1+2*256;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
