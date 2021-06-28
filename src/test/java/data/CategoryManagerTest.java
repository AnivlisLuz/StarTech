/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.data;

import app.startech.data.CategoryManager;
import app.startech.models.Category;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 * @author luzch
 */
public class CategoryManagerTest {

    public CategoryManagerTest() {
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
     * Test of getAllCategories method, of class CategoryManager.
     */
    @Test
    public void testGetAllCategories() {
        System.out.println("getAllCategories");
        CategoryManager instance = new CategoryManager();
        Category[] expResult = new Category[]{
            instance.secuencia,
            instance.suma,
            instance.resta,
            instance.multiplicacion,
            instance.division
        };
        Category[] result = instance.getAllCategories();
        assertArrayEquals(expResult, result);
    }

}
