/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import app.startech.login.Usuario;
import java.util.ArrayList;
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
public class UsuarioTest {
    
    public UsuarioTest() {
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
     * Test of getNombre method, of class Usuario.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Usuario instance = new Usuario("nombre","20");
        
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEdad method, of class Usuario.
     */
    @Test
    public void testGetEdad() {
        System.out.println("getEdad");
        Usuario instance = new Usuario("nombre","20");
        
        String expResult = "20";
        String result = instance.getEdad();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "nombre";
        Usuario instance = new Usuario();
        
        instance.setNombre(nombre);
        String result = instance.getNombre();
        assertEquals(nombre, result);
    }

    /**
     * Test of setEdad method, of class Usuario.
     */
    @Test
    public void testSetEdad() {
        System.out.println("setEdad");
        String edad = "9";
        Usuario instance = new Usuario();

        instance.setEdad(edad);
        String result = instance.getEdad();
        assertEquals(edad, result);
    }

    /**
     * Test of mostrar method, of class Usuario.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        ArrayList<Usuario> expResult = new ArrayList<>();
        ArrayList<Usuario> result = Usuario.mostrar();
        assertEquals(expResult, result);
    }

    /**
     * Test of verificarUsuario method, of class Usuario.
     */
    @Test
    public void testVerificarUsuario() {
        System.out.println("verificarUsuario");
        String nombre = "";
        boolean expResult = false;
        boolean result = Usuario.verificarUsuario(nombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of toFile method, of class Usuario.
     */
    @Test
    public void testToFile() {
        System.out.println("toFile");
        Usuario instance = new Usuario("nombre","20");
        String expResult = "nombre,20";
        String result = instance.toFile();
        assertEquals(expResult, result);
    }
    
}
