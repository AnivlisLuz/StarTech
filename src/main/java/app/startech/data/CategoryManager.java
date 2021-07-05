/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.data;

import app.startech.Convinados.Combinado;
import app.startech.crucigrama.Crucigrama;
import app.startech.imagenes.Images;
import app.startech.laberintos.Laberinto;
import app.startech.models.Category;
import app.startech.models.Level;

/**
 * @author luzch
 */
public class CategoryManager {
    public Category secuencia = new Category(1, "Secuencia de números","/app/startech/resources/secuencia.wav","La secuencia o sucesión de números es un grupo de números que forman un conjunto ordenado.\n\nEjemplo:",null,"/app/startech/resources/secuencia.gif", true, new Level[]{
            new Level(1, "Nivel 1", true, new Laberinto("Secuencia", 1, "Todo lo que necesitas para lograr tus objetivos ya está en ti.", "AYUDA AL CONEJITO A ENCONTRAR SUS ZANAHORIAS", "Sigue el camino contanto de 1 en 1 (Empieza con el 1)")),
            new Level(2, "Nivel 2", false, new Laberinto("Secuencia", 2, "No vas a dominar el resto de tu vida en un día. Relájate. Domina el día. Entonces sigue haciendo eso todos los días.", "AYUDA AL CONEJITO A ENCONTRAR SUS ZANAHORIAS", "Sigue el camino contanto de 1 en 1 (Empieza con el 1)")),
            new Level(3, "Nivel 3", false, new Laberinto("Secuencia", 3, "No importa lo lento que vayas, siempre y cuando no te detengas.", "AYUDA AL CONEJITO A ENCONTRAR SUS ZANAHORIAS", "Sigue el camino contanto de 1 en 1 (Empieza con el 1)")),
            new Level(4, "Nivel 4", false, new Laberinto("Secuencia", 4, "A veces, cuando estás en un lugar oscuro, crees que has sido enterrado, pero en realidad te han plantado.", "AYUDA AL CONEJITO A ENCONTRAR SUS ZANAHORIAS", "Sigue el camino contanto de 1 en 1 (Empieza con el 1)")),
            new Level(5, "Nivel 5", false, new Laberinto("Secuencia", 5, "Hay algo en ti que el mundo necesita.", "AYUDA AL CONEJITO A ENCONTRAR SUS ZANAHORIAS", "Sigue el camino contanto de 1 en 1 (Empieza con el 1)"))
    });
    public Category suma = new Category(2, "Suma","/app/startech/resources/suma.wav","La suma o adición es una de las operaciones básicas de la matemática. Sumar quiere decir juntar, añadir, aumentar o unir dos o más cantidades.\nEjemplo:",Images.getSuma(),"/app/startech/resources/suma.gif", false, new Level[]{
            new Level(1, "Nivel 1", false, new Laberinto("Suma", 1, "He aquí un consejo que una vez oí dar a un joven: “Haz siempre lo que temas hacer”. Ralph Waldo Emerson", "AYUDA AL PIRATA A ENCONTRAR SU TESORO", "Sigue el camino sumandole 2 a tu casilla actual (Empieza con el 1)")),
            new Level(2, "Nivel 2", false, new Laberinto("Suma", 2, "A veces se necesita una ruptura abrumadora para tener un avance innegable.", "AYUDA AL PIRATA A ENCONTRAR SU TESORO", "Sigue el camino sumandole 3 a tu casilla actual (Empieza con el 1)")),
            new Level(3, "Nivel 3", false, new Laberinto("Suma", 3, "Sé que ha sido duro, pero todavía te estoy animando.", "AYUDA AL PIRATA A ENCONTRAR SU TESORO", "Sigue el camino sumandole 4 a tu casilla actual (Empieza con el 1)")),
            new Level(4, "Nivel 4", false, new Laberinto("Suma", 4, "Un poco de progreso todos los días se suma a los grandes resultados.", "AYUDA AL PIRATA A ENCONTRAR SU TESORO", "Sigue el camino sumandole 5 a tu casilla actual (Empieza con el 1)")),
            new Level(5, "Nivel 5", false, new Laberinto("Suma", 5, "Eres más fuerte de lo que crees. Más capaz de lo que alguna vez soñaste. Y a ti te aman más de lo que podrías imaginar.", "AYUDA AL PIRATA A ENCONTRAR SU TESORO", "Sigue el camino sumandole 6 a tu casilla actual (Empieza con el 1)")),
            new Level(6, "Nivel 6", false, new Laberinto("Suma", 6, "Cuando la vida te derriba, trata de aterrizar sobre tu espalda. Porque si puedes mirar hacia arriba, puedes levantarte. Les Brown", "AYUDA AL PIRATA A ENCONTRAR SU TESORO", "Sigue el camino sumandole 7 a tu casilla actual (Empieza con el 1)")),
            new Level(7, "Nivel 7", false, new Laberinto("Suma", 7, "Puedes gritar, puedes llorar, pero no te rindas.", "AYUDA AL PIRATA A ENCONTRAR SU TESORO", "Sigue el camino sumandole 8 a tu casilla actual (Empieza con el 1)")),
            new Level(8, "Nivel 8", false, new Laberinto("Suma", 8, "Algún día todo tendrá perfecto sentido. Así que por ahora ríete de la confusión, sonríe a través de las lágrimas y sigue recordándote a ti mismo que todo sucede por una razón.", "AYUDA AL PIRATA A ENCONTRAR SU TESORO", "Sigue el camino sumandole 9 a tu casilla actual (Empieza con el 1)")),
            new Level(9, "Nivel 9", false, new Laberinto("Suma", 9, "Siempre que dudes lo lejos que puedes llegar. Solo recuerda lo lejos que has llegado. Recuerda todo lo que has enfrentado, todas las batallas que has ganado y todos los temores que has superado.", "AYUDA AL PIRATA A ENCONTRAR SU TESORO", "Sigue el camino sumandole 10 a tu casilla actual (Empieza con el 1)"))

    });
    public Category resta = new Category(3, "Resta","/app/startech/resources/Resta.wav","La resta o sustracción es una de las operaciones básicas de la matemática. Restar quiere decir quitar, perder, gastar, separar dos o más cantidades.\nEjemplo:",Images.getResta(),"/app/startech/resources/resta.gif", false, new Level[]{
            new Level(1, "Nivel 1", false, new Laberinto("Resta", 1, "La vida me susurraba constantemente que me haría feliz, pero antes de todo me quería hacer fuerte.", "AYUDA AL OSO A ENCONTRAR SU MIEL", "Sigue el camino restandole 1 a tu casilla actual (Empieza en la casiila de la izquierda-superior)")),
            new Level(2, "Nivel 2", false, new Laberinto("Resta", 2, "Eres capaz de cosas increíbles.", "AYUDA AL OSO A ENCONTRAR SU MIEL", "Sigue el camino restandole 2 a tu casilla actual (Empieza en la casiila de la izquierda-superior)")),
            new Level(3, "Nivel 3", false, new Laberinto("Resta", 3, "Pronto, cuando todo este bien, vas a mirar hacia atrás y estarás contento de ver que nunca te rendiste. Brittany Burgunder", "AYUDA AL OSO A ENCONTRAR SU MIEL", "Sigue el camino restandole 3 a tu casilla actual (Empieza en la casiila de la izquierda-superior)")),
            new Level(4, "Nivel 4", false, new Laberinto("Resta", 4, "Se te ha asignado esta montaña para mostrarles a otros que se puede mover.", "AYUDA AL OSO A ENCONTRAR SU MIEL", "Sigue el camino restandole 4 a tu casilla actual (Empieza en la casiila de la izquierda-superior))")),
            new Level(5, "Nivel 5", false, new Laberinto("Resta", 5, "Nunca debes tener miedo de lo que estás haciendo cuando es correcto. Rosa Parks", "AYUDA AL OSO A ENCONTRAR SU MIEL", "Sigue el camino restandole 5 a tu casilla actual (Empieza en la casiila de la izquierda-superior)")),
            new Level(6, "Nivel 6", false, new Laberinto("Resta", 6, "Cree en ti mismo y serás imparable.", "AYUDA AL OSO A ENCONTRAR SU MIEL", "Sigue el camino restandole 6 a tu casilla actual (Empieza en la casiila de la izquierda-superior)")),
            new Level(7, "Nivel 7", false, new Laberinto("Resta", 7, "Estoy tan orgulloso de ti. Solo quería decírtelo en caso de que nadie lo haya hecho.", "AYUDA AL OSO A ENCONTRAR SU MIEL", "Sigue el camino restandole 7 a tu casilla actual (Empieza en la casiila de la izquierda-superior)")),
            new Level(8, "Nivel 8", false, new Laberinto("Resta", 8, "Busca algo positivo en cada día, incluso cuando algunos días tengas que mirar un poco más.", "AYUDA AL OSO A ENCONTRAR SU MIEL", "Sigue el camino restandole 8 a tu casilla actual (Empieza en la casiila de la izquierda-superior)")),
            new Level(9, "Nivel 9", false, new Laberinto("Resta", 9, "La clave está en ver a cada uno de los muros que te encuentras en el camino como escalones que se dirigen hacia tu objetivo.", "AYUDA AL OSO A ENCONTRAR SU MIEL", "Sigue el camino restandole 9 a tu casilla actual (Empieza en la casiila de la izquierda-superior)")),
            new Level(10, "Nivel 10", false, new Laberinto("Resta", 10, "Solo fallas cuando dejas de intentarlo.", "AYUDA AL OSO A ENCONTRAR SU MIEL", "Sigue el camino restandole 10 a tu casilla actual (Empieza en la casiila de la izquierda-superior)"))

    });
    public Category multiplicacion = new Category(4, "Multiplicación","/app/startech/resources/Multiplicacion.wav","La multiplicación es una de las operaciones básicas de la matemática. Multiplicar quiere decir juntar o repetir varias veces la misma cantidad.\nEjemplo:",Images.getMultiplicacion(),"/app/startech/resources/multiplicacion.gif", false, new Level[]{
            new Level(1, "Nivel 1", false, new Laberinto("Multiplicación", 1, "Solo sé tú mismo. Deja que la gente vea a la persona real, imperfecta, extraña, bella y mágica que eres.", "AYUDA A JENGI A LLEGAR A LA CASA DE JENGIBRE", "Encuentra el camino buscando números multiplos de 2 (Empieza con el 2)")),
            new Level(2, "Nivel 2", false, new Laberinto("Multiplicación", 2, "Nunca he conocido a una persona fuerte con un pasado fácil.", "AYUDA A JENGI A LLEGAR A LA CASA DE JENGIBRE", "Encuentra el camino buscando números multiplos de 3 (Empieza con el 3)")),
            new Level(3, "Nivel 3", false, new Laberinto("Multiplicación", 3, "A mí también me tocó pasar por lo peor para darme cuenta de cómo lo tenía que hacer para llegar a lo mejor.", "AYUDA A JENGI A LLEGAR A LA CASA DE JENGIBRE", "Encuentra el camino buscando números multiplos de 4 (Empieza con el 4)")),
            new Level(4, "Nivel 4", false, new Laberinto("Multiplicación", 4, "Despierta. Levántate. Repite.", "AYUDA A JENGI A LLEGAR A LA CASA DE JENGIBRE", "Encuentra el camino buscando números multiplos de 5 (Empieza con el 5)")),
            new Level(5, "Nivel 5", false, new Laberinto("Multiplicación", 5, "No le temo a las tormentas, porque estoy aprendiendo cómo navegar en mi barco.", "AYUDA A JENGI A LLEGAR A LA CASA DE JENGIBRE", "Encuentra el camino buscando números multiplos de 6 (Empieza con el 6)")),
            new Level(6, "Nivel 6", false, new Laberinto("Multiplicación", 6, "Hazlo siempre lo mejor que puedas. Lo que siembres ahora, cosecharás más tarde. Og Mandino", "AYUDA A JENGI A LLEGAR A LA CASA DE JENGIBRE", "Encuentra el camino buscando números multiplos de 7 (Empieza con el 7)")),
            new Level(7, "Nivel 7", false, new Laberinto("Multiplicación", 7, "Un hombre puede ser tan bueno como quiera ser. Vince Lombardi", "AYUDA A JENGI A LLEGAR A LA CASA DE JENGIBRE", "Encuentra el camino buscando números multiplos de 8 (Empieza con el 8)")),
            new Level(8, "Nivel 8", false, new Laberinto("Multiplicación", 8, "Sé gentil contigo mismo. ¡Estás haciendo lo mejor que puedes!", "AYUDA A JENGI A LLEGAR A LA CASA DE JENGIBRE", "Encuentra el camino buscando números multiplos de 9 (Empieza con el 9)")),
            new Level(9, "Nivel 9", false, new Laberinto("Multiplicación", 9, "Las dificultades a menudo preparan a la gente común para un destino extraordinario.", "AYUDA A JENGI A LLEGAR A LA CASA DE JENGIBRE", "Encuentra el camino buscando números multiplos de 10 (Empieza con el 10)"))

    });
    public Category division = new Category(5, "División","/app/startech/resources/Division.wav","La división es una de las operaciones básicas de la matemática. Dividir quiere decir repartir, distribuir o compartir en partes iguales una cantidad.\nEjemplo:",Images.getDivision(),"/app/startech/resources/division.gif", false, new Level[]{
            new Level(1, "Nivel 1", false, new Laberinto("División", 1, "Comienza donde estás. Usa lo que tienes. Haz lo que puedas. Arthur Ashe", "AYUDA A LA ARIDILLITA A LLEGAR A SU CASITA", "Encuentra el camino buscando números divisibles entre 2 (Empieza con el 2)")),
            new Level(2, "Nivel 2", false, new Laberinto("División", 2, "La mejor revancha es el éxito masivo. Frank Sinatra", "AYUDA A LA ARIDILLITA A LLEGAR A SU CASITA", "Encuentra el camino buscando números divisibles entre 3 (Empieza con el 3)")),
            new Level(3, "Nivel 3", false, new Laberinto("División", 3, "No lo pienses, solo hazlo. Horace", "AYUDA A LA ARIDILLITA A LLEGAR A SU CASITA", "Encuentra el camino buscando números divisibles entre 4 (Empieza con el 4)")),
            new Level(4, "Nivel 4", false, new Laberinto("División", 4, "Nunca dejes que una mala situación saque lo peor de ti. ¡Elije mantenerte positivo y ser la persona fuerte que Dios creó!", "AYUDA A LA ARIDILLITA A LLEGAR A SU CASITA", "Encuentra el camino buscando números divisibles entre 5 (Empieza con el 5)")),
            new Level(5, "Nivel 5", false, new Laberinto("División", 5, "Siempre parece imposible hasta que se hace. Nelson Mandela", "AYUDA A LA ARIDILLITA A LLEGAR A SU CASITA", "Encuentra el camino buscando números divisibles entre 6 (Empieza con el 6)")),
            new Level(6, "Nivel 6", false, new Laberinto("División", 6, "No se puede vencer a la persona que nunca se rinde. Babe Ruth", "AYUDA A LA ARIDILLITA A LLEGAR A SU CASITA", "Encuentra el camino buscando números divisibles entre 7 (Empieza con el 7)")),
            new Level(7, "Nivel 7", false, new Laberinto("División", 7, "Cuanto más difícil es el conflicto, más glorioso es el triunfo. Thomas Paine", "AYUDA A LA ARIDILLITA A LLEGAR A SU CASITA", "Encuentra el camino buscando números divisibles entre 8 (Empieza con el 8)")),
            new Level(8, "Nivel 8", false, new Laberinto("División", 8, "Establece metas altas, y no te detengas hasta que llegues allí. Bo Jackson", "AYUDA A LA ARIDILLITA A LLEGAR A SU CASITA", "Encuentra el camino buscando números divisibles entre 9 (Empieza con el 9)")),
            new Level(9, "Nivel 9", false, new Laberinto("División", 9, "Para tener éxito, primero debemos creer que podemos. Nikos Kazantzakis", "AYUDA A LA ARIDILLITA A LLEGAR A SU CASITA", "Encuentra el camino buscando números divisibles entre 10 (Empieza con el 10)"))
    });

    public Category crucigrama = new Category(6, "Crucigramas","","",null,"", true, new Level[]{
            new Level(1, "Nivel 1", true, new Crucigrama("Suma", "",1)),
            new Level(2, "Nivel 2", true, new Crucigrama("Resta", "",2)),
            new Level(3, "Nivel 3", true, new Crucigrama("Multiplicación", "",3)),
            new Level(4, "Nivel 4", true, new Crucigrama("División", "",4)),
            new Level(4, "Nivel 5", true, new Crucigrama("Combinados", "",5)),
    });
    public Category combinado = new Category(7, "Combinados","","",null,"", true, new Level[]{
            new Level(1, "Nivel 1", true, new Combinado("Suma y resta", "",1)),
            new Level(2, "Nivel 2", true, new Combinado("Multiplicación y división", "",2)),
            new Level(3, "Nivel 3", true, new Combinado("División y suma", "",3)),
            new Level(4, "Nivel 4", true, new Combinado("División y multiplicación", "",4)),
    });
    public Category sopaResultado = new Category(8, "Sopa de Resultados","","",null,"", true, new Level[]{
    });
    public Category[] getAllCategories() {
        return new Category[]{secuencia, suma, resta, multiplicacion, division, crucigrama, combinado, sopaResultado};
    }
}
