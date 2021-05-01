/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preguntas;

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
public class PreguntaTest {

    public PreguntaTest() {
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
     * Test of esperar method, of class Pregunta.
     */
    @Test
    public void testRestQuest() {
        System.out.println("restQuest");
        Pregunta.restQuest();
        assertEquals(Pregunta.getCuestio(), 0);
        assertEquals(Pregunta.getResul(), 0);
        assertEquals(Pregunta.getResulS(), 0);
        assertEquals(Pregunta.getResulR(), 0);
        assertEquals(Pregunta.getResulM(), 0);
        assertEquals(Pregunta.getResulD(), 0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of restQuestChekPoint method, of class Pregunta.
     */
    @Test
    public void testRestQuestChekPoint() {
        System.out.println("restQuestChekPoint");
        Pregunta.restQuestChekPoint();
        if (Pregunta.getResulS() == 3) {
            assertEquals(Pregunta.getS(), true);
        } else {
            assertEquals(Pregunta.getS(), false);
        }
        if (Pregunta.getResulR() == 3) {
            assertEquals(Pregunta.getR(), true);
        } else {
            assertEquals(Pregunta.getR(), false);
        }
        if (Pregunta.getResulM() == 3) {
            assertEquals(Pregunta.getM(), true);
        } else {
            assertEquals(Pregunta.getM(), false);
        }
        if (Pregunta.getResulD() == 3) {
            assertEquals(Pregunta.getD(), true);
        } else {
            assertEquals(Pregunta.getD(), false);
        }
// TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getCuestio method, of class Pregunta.
     */
    @Test
    public void testSetCuestio() {
        System.out.println("setCuestio");
        Pregunta.setCuestio();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(Pregunta.getCuestio(), 13);
    }

    /**
     * Test of setCuestionario method, of class Pregunta.
     */
    @Test
    public void testSetCuestionario() {
        System.out.println("setCuestionario");
        int o = Pregunta.getCuestio() + 1;
        Pregunta.setCuestionario();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(Pregunta.getCuestio(), o);
    }

    /**
     * Test of getResul method, of class Pregunta.
     */
    @Test
    public void testSetResulS() {
        System.out.println("setResulS");
        Pregunta.setResulS();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(Pregunta.getResulS(), 3);
    }

    /**
     * Test of setResulR method, of class Pregunta.
     */
    @Test
    public void testSetResulR() {
        System.out.println("setResulR");
        Pregunta.setResulR();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(Pregunta.getResulR(), 3);
    }

    /**
     * Test of setResulM method, of class Pregunta.
     */
    @Test
    public void testSetResulM() {
        System.out.println("setResulM");
        Pregunta.setResulM();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(Pregunta.getResulM(), 3);
    }

    /**
     * Test of setResulD method, of class Pregunta.
     */
    @Test
    public void testSetResulD() {
        System.out.println("setResulD");
        Pregunta.setResulD();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(Pregunta.getResulD(), 3);
    }

    /**
     * Test of getS method, of class Pregunta.
     */
    @Test
    public void testSetQuestCategory() {
        System.out.println("setQuestCategory");
        int x = Pregunta.getCuestio() + 3;
        Pregunta.setQuestCategory();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(Pregunta.getCuestio(), x);
    }

    /**
     * Test of setRestCategory method, of class Pregunta.
     */
    @Test
    public void testSetRestCategory() {
        System.out.println("setRestCategory");
        int x = Pregunta.getResul() + 3;
        Pregunta.setRestCategory();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(Pregunta.getResul(), x);

    }

    /**
     * Test of setRestBCateg method, of class Pregunta.
     */
    @Test
    public void testSetRestBCateg() {
        System.out.println("setRestBCateg");
        Pregunta.setRestBCateg();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(Pregunta.getS(), false);
        assertEquals(Pregunta.getR(), false);
        assertEquals(Pregunta.getM(), false);
        assertEquals(Pregunta.getD(), false);
    }

}