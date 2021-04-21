/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import app.startech.models.Category;
import app.startech.models.Level;
import folder.Laberinto;

/**
 *
 * @author luzch
 */
public class DataController {

    public static Category secuencia = new Category(1, "Secuencia de números", true, new Level[]{
        new Level(1, "1 al 9", true, new Laberinto("Secuencia", 1, "Todo lo que necesitas para lograr tus objetivos ya está en ti.")),
        new Level(2, "1 al 20", false, new Laberinto("Secuencia", 2, "No vas a dominar el resto de tu vida en un día. Relájate. Domina el día. Entonces sigue haciendo eso todos los días.")),
        new Level(3, "1 al 30", false, new Laberinto("Secuencia", 3, "No importa lo lento que vayas, siempre y cuando no te detengas.")),
        new Level(4, "1 al 40", false, new Laberinto("Secuencia", 4, "A veces, cuando estás en un lugar oscuro, crees que has sido enterrado, pero en realidad te han plantado.")),
        new Level(5, "1 al 50", false, new Laberinto("Secuencia", 5, "Hay algo en ti que el mundo necesita."))
    });
    public static Category suma = new Category(2, "Suma", false, new Level[]{
        new Level(1, "2", false, new Laberinto("Suma", 1, "He aquí un consejo que una vez oí dar a un joven: “Haz siempre lo que temas hacer”. Ralph Waldo Emerson")),
        new Level(2, "3", false, new Laberinto("Suma", 2, "A veces se necesita una ruptura abrumadora para tener un avance innegable.")),
        new Level(3, "4", false, new Laberinto("Suma", 3, "Sé que ha sido duro, pero todavía te estoy animando." )),
        new Level(4, "5", false, new Laberinto("Suma", 4, "Un poco de progreso todos los días se suma a los grandes resultados." )),
        new Level(5, "6", false, new Laberinto("Suma", 5, "Eres más fuerte de lo que crees. Más capaz de lo que alguna vez soñaste. Y a ti te aman más de lo que podrías imaginar.")),
        new Level(1, "7", false, new Laberinto("Suma", 6, "Cuando la vida te derriba, trata de aterrizar sobre tu espalda. Porque si puedes mirar hacia arriba, puedes levantarte. Les Brown")),
        new Level(2, "8", false, new Laberinto("Suma", 7, "Puedes gritar, puedes llorar, pero no te rindas.")),
        new Level(3, "9", false, new Laberinto("Suma", 8, "Algún día todo tendrá perfecto sentido. Así que por ahora ríete de la confusión, sonríe a través de las lágrimas y sigue recordándote a ti mismo que todo sucede por una razón.")),
        new Level(4, "10", false, new Laberinto("Suma", 9, "Siempre que dudes lo lejos que puedes llegar. Solo recuerda lo lejos que has llegado. Recuerda todo lo que has enfrentado, todas las batallas que has ganado y todos los temores que has superado."))
    
    });
    public static Category resta = new Category(3, "Resta", false, new Level[]{
        new Level(1, "1", false, new Laberinto("Resta", 1, "La vida me susurraba constantemente que me haría feliz, pero antes de todo me quería hacer fuerte.")),
        new Level(1, "2", false, new Laberinto("Resta", 2, "Eres capaz de cosas increíbles.")),
        new Level(2, "3", false, new Laberinto("Resta", 3, "Pronto, cuando todo este bien, vas a mirar hacia atrás y estarás contento de ver que nunca te rendiste. Brittany Burgunder")),
        new Level(3, "4", false, new Laberinto("Resta", 4, "Se te ha asignado esta montaña para mostrarles a otros que se puede mover." )),
        new Level(4, "5", false, new Laberinto("Resta", 5, "Nunca debes tener miedo de lo que estás haciendo cuando es correcto. Rosa Parks")),
        new Level(5, "6", false, new Laberinto("Resta", 6, "Cree en ti mismo y serás imparable.")),
        new Level(1, "7", false, new Laberinto("Resta", 7, "Estoy tan orgulloso de ti. Solo quería decírtelo en caso de que nadie lo haya hecho.")),
        new Level(2, "8", false, new Laberinto("Resta", 8, "Busca algo positivo en cada día, incluso cuando algunos días tengas que mirar un poco más.")),
        new Level(3, "9", false, new Laberinto("Resta", 9, "La clave está en ver a cada uno de los muros que te encuentras en el camino como escalones que se dirigen hacia tu objetivo.")),
        new Level(4, "10", false, new Laberinto("Resta", 10, "Solo fallas cuando dejas de intentarlo."))
    
    });
    public static Category multiplicacion = new Category(4, "Multiplicación", false, new Level[]{
        new Level(1, "2", false, new Laberinto("Multiplicación", 1, "Solo sé tú mismo. Deja que la gente vea a la persona real, imperfecta, extraña, bella y mágica que eres.")),
        new Level(2, "3", false, new Laberinto("Multiplicación", 2, "Nunca he conocido a una persona fuerte con un pasado fácil.")),
        new Level(3, "4", false, new Laberinto("Multiplicación", 3, "A mí también me tocó pasar por lo peor para darme cuenta de cómo lo tenía que hacer para llegar a lo mejor.")),
        new Level(4, "5", false, new Laberinto("Multiplicación", 4, "Despierta. Levántate. Repite.")),
        new Level(5, "6", false, new Laberinto("Multiplicación", 5, "No le temo a las tormentas, porque estoy aprendiendo cómo navegar en mi barco.")),
        new Level(1, "7", false, new Laberinto("Multiplicación", 6, "Hazlo siempre lo mejor que puedas. Lo que siembres ahora, cosecharás más tarde. Og Mandino")),
        new Level(2, "8", false, new Laberinto("Multiplicación", 7, "Un hombre puede ser tan bueno como quiera ser. Si crees en ti mismo y tienes el coraje, la determinación, la dedicación, el impulso competitivo y estás dispuesto a sacrificar las pequeñas cosas de la vida, pagando el precio por las cosas que valen la pena, se puede hacer. Vince Lombardi")),
        new Level(3, "9", false, new Laberinto("Multiplicación", 8, "Sé gentil contigo mismo. ¡Estás haciendo lo mejor que puedes!")),
        new Level(4, "10", false, new Laberinto("Multiplicación", 9, "Las dificultades a menudo preparan a la gente común para un destino extraordinario."))
   
    });
    public static Category division = new Category(5, "División", false, new Level[]{
        new Level(1, "2", false, new Laberinto("Divición", 1, "Comienza donde estás. Usa lo que tienes. Haz lo que puedas. Arthur Ashe")),
        new Level(2, "3", false, new Laberinto("Divición", 2, "La mejor revancha es el éxito masivo. Frank Sinatra")),
        new Level(3, "4", false, new Laberinto("Divición", 3, "No lo pienses, solo hazlo. Horace")),
        new Level(4, "5", false, new Laberinto("Divición", 4, "Nunca dejes que una mala situación saque lo peor de ti. ¡Elije mantenerte positivo y ser la persona fuerte que Dios creó!")),
        new Level(5, "6", false, new Laberinto("Divición", 5, "Siempre parece imposible hasta que se hace. Nelson Mandela")),
        new Level(1, "7", false, new Laberinto("Divición", 6, "No se puede vencer a la persona que nunca se rinde. Babe Ruth")),
        new Level(2, "8", false, new Laberinto("Divición", 7, "Cuanto más difícil es el conflicto, más glorioso es el triunfo. Thomas Paine")),
        new Level(3, "9", false, new Laberinto("Divición", 8, "Establece metas altas, y no te detengas hasta que llegues allí. Bo Jackson")),
        new Level(4, "10", false, new Laberinto("Divición", 9, "Para tener éxito, primero debemos creer que podemos. Nikos Kazantzakis"))
    });


    public static Category[] getAllCategories() {
        return new Category[]{secuencia, suma, resta, multiplicacion, division};
    }

}
