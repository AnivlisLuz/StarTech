/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.app.startech.models;

import app.startech.models.Category;
import app.startech.models.Level;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author luzch
 */
public class CategoryTest {
    
    public CategoryTest() {
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
     * Test of setActive method, of class Category.
     */
    @Test
    public void testSetActive_0args() {
        System.out.println("setActive");
        Category instance = new Category(1,"title","","",null,"",false,null);
        instance.setActive();
        
        boolean expResult = true;
        boolean result = instance.getActive();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Category.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Category instance = new Category(1,"title","","",null,"",false,null);
        
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Category.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Category instance = new Category(1,"title","","",null,"",false,null);
        
        String expResult = "title";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getActive method, of class Category.
     */
    @Test
    public void testGetActive() {
        System.out.println("getActive");
        Category instance = new Category(1,"title","","",null,"",false,null);
        
        boolean expResult = false;
        boolean result = instance.getActive();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActive method, of class Category.
     */
    @Test
    public void testSetActive_boolean() {
        System.out.println("setActive");
        boolean active = false;
        Category instance = new Category(1,"title","","",null,"",false,null);
        instance.setActive(active);
    }

    /**
     * Test of getLevels method, of class Category.
     */
    @Test
    public void testGetLevels() {
        System.out.println("getLevels");
        Category instance = new Category(1,"title","","",null,"",false,null);
        
        Level[] expResult = null;
        Level[] result = instance.getLevels();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of nextLevel method, of class Category.
     */
    @Test
    public void testNextLevel() {
        System.out.println("nextLevel");
        Level level = null;
        Category instance = new Category(1,"title","","",null,"",false,new Level[0]);
        
        Level expResult = null;
        Level result = instance.nextLevel(level);
        assertEquals(expResult, result);
    }
    
}
