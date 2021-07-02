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
public class SopaDeResultadosTest {
    
    public SopaDeResultadosTest() {
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
     * Test of generarMatriz method, of class SopaDeResultados.
     */
    @Test
    public void testGenerarMatriz() {
        System.out.println("generarMatriz");
        SopaDeResultados instance = new SopaDeResultados();
        Cuadro[][] expResult = null;
        Cuadro[][] result = instance.generarMatriz();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeros method, of class SopaDeResultados.
     */
    @Test
    public void testGetNumeros() {
        System.out.println("getNumeros");
        SopaDeResultados instance = new SopaDeResultados();
        String[] expResult = null;
        String[] result = instance.getNumeros();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultados method, of class SopaDeResultados.
     */
    @Test
    public void testGetResultados() {
        System.out.println("getResultados");
        SopaDeResultados instance = new SopaDeResultados();
        int[] expResult = null;
        int[] result = instance.getResultados();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultado method, of class SopaDeResultados.
     */
    @Test
    public void testGetResultado() {
        System.out.println("getResultado");
        int posicion = 0;
        SopaDeResultados instance = new SopaDeResultados();
        int expResult = 0;
        int result = instance.getResultado(posicion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTocado method, of class SopaDeResultados.
     */
    @Test
    public void testGetTocado() {
        System.out.println("getTocado");
        SopaDeResultados instance = new SopaDeResultados();
        boolean expResult = false;
        boolean result = instance.getTocado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTocado method, of class SopaDeResultados.
     */
    @Test
    public void testSetTocado() {
        System.out.println("setTocado");
        boolean a = false;
        SopaDeResultados instance = new SopaDeResultados();
        instance.setTocado(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrimerDigito method, of class SopaDeResultados.
     */
    @Test
    public void testSetPrimerDigito() {
        System.out.println("setPrimerDigito");
        int numero = 0;
        SopaDeResultados instance = new SopaDeResultados();
        instance.setPrimerDigito(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSegundoDigito method, of class SopaDeResultados.
     */
    @Test
    public void testSetSegundoDigito() {
        System.out.println("setSegundoDigito");
        int numero = 0;
        SopaDeResultados instance = new SopaDeResultados();
        instance.setSegundoDigito(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrimerD method, of class SopaDeResultados.
     */
    @Test
    public void testGetPrimerD() {
        System.out.println("getPrimerD");
        SopaDeResultados instance = new SopaDeResultados();
        int expResult = 0;
        int result = instance.getPrimerD();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSegundoD method, of class SopaDeResultados.
     */
    @Test
    public void testGetSegundoD() {
        System.out.println("getSegundoD");
        SopaDeResultados instance = new SopaDeResultados();
        int expResult = 0;
        int result = instance.getSegundoD();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRespondidos method, of class SopaDeResultados.
     */
    @Test
    public void testSetRespondidos() {
        System.out.println("setRespondidos");
        int posicion = 0;
        SopaDeResultados instance = new SopaDeResultados();
        instance.setRespondidos(posicion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of todoRespondido method, of class SopaDeResultados.
     */
    @Test
    public void testTodoRespondido() {
        System.out.println("todoRespondido");
        SopaDeResultados instance = new SopaDeResultados();
        boolean expResult = false;
        boolean result = instance.todoRespondido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tocoPrimero method, of class SopaDeResultados.
     */
    @Test
    public void testTocoPrimero() {
        System.out.println("tocoPrimero");
        int y = 0;
        int x = 0;
        SopaDeResultados instance = new SopaDeResultados();
        instance.tocoPrimero(y, x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTocoPrimeroX method, of class SopaDeResultados.
     */
    @Test
    public void testGetTocoPrimeroX() {
        System.out.println("getTocoPrimeroX");
        SopaDeResultados instance = new SopaDeResultados();
        int expResult = 0;
        int result = instance.getTocoPrimeroX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTocoPrimeroY method, of class SopaDeResultados.
     */
    @Test
    public void testGetTocoPrimeroY() {
        System.out.println("getTocoPrimeroY");
        SopaDeResultados instance = new SopaDeResultados();
        int expResult = 0;
        int result = instance.getTocoPrimeroY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrimerDigitoTomado method, of class SopaDeResultados.
     */
    @Test
    public void testSetPrimerDigitoTomado() {
        System.out.println("setPrimerDigitoTomado");
        int numero = 0;
        SopaDeResultados instance = new SopaDeResultados();
        instance.setPrimerDigitoTomado(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrimerDigitoTomado method, of class SopaDeResultados.
     */
    @Test
    public void testGetPrimerDigitoTomado() {
        System.out.println("getPrimerDigitoTomado");
        SopaDeResultados instance = new SopaDeResultados();
        int expResult = 0;
        int result = instance.getPrimerDigitoTomado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVidas method, of class SopaDeResultados.
     */
    @Test
    public void testGetVidas() {
        System.out.println("getVidas");
        SopaDeResultados instance = new SopaDeResultados();
        int expResult = 0;
        int result = instance.getVidas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of perderVida method, of class SopaDeResultados.
     */
    @Test
    public void testPerderVida() {
        System.out.println("perderVida");
        SopaDeResultados instance = new SopaDeResultados();
        instance.perderVida();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of establecerVidas method, of class SopaDeResultados.
     */
    @Test
    public void testEstablecerVidas() {
        System.out.println("establecerVidas");
        SopaDeResultados instance = new SopaDeResultados();
        instance.establecerVidas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
