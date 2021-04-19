/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import app.startech.models.Category;
import app.startech.models.Level;

/**
 *
 * @author luzch
 */
public class DataController {

    public static Category secuencia = new Category(1, "Secuencia de números", true, new Level[]{
        new Level(1, "1 al 9", true),
        new Level(2, "1 al 20", false),
        new Level(3, "1 al 30", false),
        new Level(4, "1 al 40", false),
        new Level(5, "1 al 50", false)
    });
    public static Category suma = new Category(2, "Suma", true, new Level[]{
        new Level(1, "2", true),
        new Level(2, "3", false),
        new Level(3, "4", false),
        new Level(4, "5", false),
        new Level(5, "6", false),
        new Level(1, "7", false),
        new Level(2, "8", false),
        new Level(3, "9", false),
        new Level(4, "10", false)
    });
    public static Category resta = new Category(3, "Resta", true, new Level[]{
        new Level(1, "1", true),
        new Level(1, "2", true),
        new Level(2, "3", false),
        new Level(3, "4", false),
        new Level(4, "5", false),
        new Level(5, "6", false),
        new Level(1, "7", false),
        new Level(2, "8", false),
        new Level(3, "9", false),
        new Level(4, "10", false)
    });
    public static Category multiplicacion = new Category(4, "Multiplicación", false, new Level[]{
        new Level(1, "2", true),
        new Level(2, "3", false),
        new Level(3, "4", false),
        new Level(4, "5", false),
        new Level(5, "6", false),
        new Level(1, "7", false),
        new Level(2, "8", false),
        new Level(3, "9", false),
        new Level(4, "10", false)
    });
    public static Category division = new Category(5, "División", false, new Level[]{
        new Level(1, "2", true),
        new Level(2, "3", false),
        new Level(3, "4", false),
        new Level(4, "5", false),
        new Level(5, "6", false),
        new Level(1, "7", false),
        new Level(2, "8", false),
        new Level(3, "9", false),
        new Level(4, "10", false)
    });

    public static Category[] getAllCategories() {
        return new Category[]{secuencia, suma, resta, multiplicacion, division};
    }

}
