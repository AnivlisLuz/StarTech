/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import forms.Usuario;
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
public class DataControllerTest {
    
    public DataControllerTest() {
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
     * Test of getUsuarioActual method, of class DataController.
     */
    @Test
    public void testGetUsuarioActual() {
        System.out.println("getUsuarioActual");
        DataController instance = new DataController();
        Usuario expResult = null;
        Usuario result = instance.getUsuarioActual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuarioActual method, of class DataController.
     */
    @Test
    public void testSetUsuarioActual_Usuario() {
        System.out.println("setUsuarioActual");
        Usuario usuarioActual = null;
        DataController instance = new DataController();
        instance.setUsuarioActual(usuarioActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuarioActual method, of class DataController.
     */
    @Test
    public void testSetUsuarioActual_int() {
        System.out.println("setUsuarioActual");
        int index = 0;
        DataController instance = new DataController();
        instance.setUsuarioActual(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
