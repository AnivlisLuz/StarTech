/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberintoc;

import app.startech.matriz.Punto;
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
public class PuntoTest {

    public PuntoTest() {
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
     * Test of getPosX method, of class Punto.
     */
    @Test
    public void testGetPosX() {
        System.out.println("getPosX");
        Punto instance = new Punto();
        int expResult = 0;
        int result = instance.getPosX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPosX method, of class Punto.
     */
    @Test
    public void testSetPosX() {
        System.out.println("setPosX");
        int posX = 0;
        Punto instance = new Punto();
        instance.setPosX(posX);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getPosX(), posX);
    }

    /**
     * Test of getPosY method, of class Punto.
     */
    @Test
    public void testGetPosY() {
        System.out.println("getPosY");
        Punto instance = new Punto();
        int expResult = 0;
        int result = instance.getPosY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPosY method, of class Punto.
     */
    @Test
    public void testSetPosY() {
        System.out.println("setPosY");
        int posY = 0;
        Punto instance = new Punto();
        instance.setPosY(posY);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getPosY(), posY);
    }

    /**
     * Test of getValor method, of class Punto.
     */
    @Test
    public void testGetValor() {
        System.out.println("getValor");
        Punto instance = new Punto();
        int expResult = 0;
        int result = instance.getValor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setValor method, of class Punto.
     */
    @Test
    public void testSetValor() {
        System.out.println("setValor");
        int valor = 0;
        Punto instance = new Punto();
        instance.setValor(valor);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getValor(), valor);
    }

    /**
     * Test of getVisitada method, of class Punto.
     */
    @Test
    public void testGetVisitada() {
        System.out.println("getVisitada");
        Punto instance = new Punto();
        boolean expResult = false;
        boolean result = instance.getVisitada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setVisitada method, of class Punto.
     */
    @Test
    public void testSetVisitada() {
        System.out.println("setVisitada");
        boolean visitada = false;
        Punto instance = new Punto();
        instance.setVisitada(visitada);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getVisitada(), visitada);
    }

    /**
     * Test of getSiguiente method, of class Punto.
     */
    /* @Test
    public void testGetSiguiente() {
    System.out.println("getSiguiente");
    int a=0;
    boolean b=false;
    int c=0;
    int d=0;
    Punto punto = new Punto(a,b,c,d);
    Punto instance = new Punto();
    Punto expResult = new Punto(a,b,c,d);
    Punto result = instance.getSiguiente(punto);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    }*/
    /**
     * Test of igual method, of class Punto.
     */
    @Test
    public void testIgual() {
        System.out.println("igual");
        int a = 0;
        boolean b = false;
        int c = 0;
        int d = 0;
        Punto p = new Punto(a,b,c,d);
        Punto instance = new Punto();
        boolean expResult = true;
        boolean result = instance.igual(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getOrden method, of class Punto.
     */
    @Test
    public void testGetOrden() {
        System.out.println("getOrden");
        Punto instance = new Punto();
        int expResult = 0;
        int result = instance.getOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setOrden method, of class Punto.
     */
    @Test
    public void testSetOrden() {
        System.out.println("setOrden");
        int orden = 0;
        Punto instance = new Punto();
        instance.setOrden(orden);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getOrden(), orden);
    }

}
