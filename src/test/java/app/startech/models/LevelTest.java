/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.app.startech.models;

import app.startech.laberintos.Laberinto;
import app.startech.models.Level;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author luzch
 */
public class LevelTest {
    
    public LevelTest() {
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
     * Test of setActive method, of class Level.
     */
    @Test
    public void testSetActive_0args() {
        System.out.println("setActive");
        Level instance = new Level(1," ",false,null);
        instance.setActive();
        
        boolean expResult = true;
        boolean result = instance.active();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Level.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Level instance = new Level(1," ",false,null);
        
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTitle method, of class Level.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Level instance = new Level(1,"title",false,null);
        
        String expResult = "title";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of active method, of class Level.
     */
    @Test
    public void testActive() {
        System.out.println("active");
        Level instance = new Level(1," ",true,null);
        
        boolean expResult = true;
        boolean result = instance.active();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLaberinto method, of class Level.
     */
    @Test
    public void testGetLaberinto() {
        System.out.println("getLaberinto");
        Level instance = new Level(1," ",false,null);
        
        Laberinto expResult = null;
        Laberinto result = instance.getLaberinto();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActive method, of class Level.
     */
    @Test
    public void testSetActive_boolean() {
        System.out.println("setActive");
        boolean b = false;
        Level instance = new Level(1," ",false,null);
        instance.setActive(b);

        boolean expResult = true;
        boolean result = instance.active();
        assertEquals(expResult, result);
    }
    
}
