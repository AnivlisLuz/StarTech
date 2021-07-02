/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopa;


import app.startech.sopa.Cuadro;
import app.startech.sopa.Matriz;
import app.startech.sopa.SopaDeResultados;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author USER
 */
public class SopaDeResultadosTest {

    private SopaDeResultados sopa;

    public SopaDeResultadosTest() {
        sopa = new SopaDeResultados();
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

    @Test
    public void testGenerarMatriz() {
        Cuadro[][] matriz = sopa.generarMatriz();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                assertEquals(matriz[i][j].getEsCuadro(), true);
            }
        }
    }
    
}
