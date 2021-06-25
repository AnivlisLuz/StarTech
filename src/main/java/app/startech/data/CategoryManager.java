/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.startech.data;

import Convinados.Combinado;
import Crucigrama.Crucigrama;
import app.startech.imagenes.Images;
import app.startech.laberintos.Laberinto;
import app.startech.models.Category;
import app.startech.models.Level;

/**
 * @author luzch
 */
public class CategoryManager {
    public Category secuencia = new Category(1, "Secuencia de números","https://github.com/AnivlisLuz/StarTech/releases/download/gifs/secuencia.wav","La secuencia o sucesión de números es un grupo de números que forman un conjunto ordenado.\n\nEjemplo:",null,"https://github.com/AnivlisLuz/StarTech/releases/download/gifs/secuencia.gif", true, new Level[]{
            new Level(1, "Nivel 1", true, new Laberinto("Secuencia", 1, "Todo lo que necesitas para lograr tus objetivos ya está en ti.", "Avanza de uno en uno")),
            new Level(2, "Nivel 2", false, new Laberinto("Secuencia", 2, "No vas a dominar el resto de tu vida en un día. Relájate. Domina el día. Entonces sigue haciendo eso todos los días.", "Avanza de uno en uno")),
            new Level(3, "Nivel 3", false, new Laberinto("Secuencia", 3, "No importa lo lento que vayas, siempre y cuando no te detengas.", "Avanza de uno en uno")),
            new Level(4, "Nivel 4", false, new Laberinto("Secuencia", 4, "A veces, cuando estás en un lugar oscuro, crees que has sido enterrado, pero en realidad te han plantado.", "Avanza de uno en uno")),
            new Level(5, "Nivel 5", false, new Laberinto("Secuencia", 5, "Hay algo en ti que el mundo necesita.", "Avanza de uno en uno"))
    });
    public Category suma = new Category(2, "Suma","https://github.com/AnivlisLuz/StarTech/releases/download/gifs/suma.wav","La suma o adición es una de las operaciones básicas de la matemática. Sumar quiere decir juntar, añadir, aumentar o unir dos o más cantidades.\nEjemplo:",Images.getSuma(),"https://github.com/AnivlisLuz/StarTech/releases/download/gifs/suma.gif", true, new Level[]{
            new Level(1, "Nivel 1", false, new Laberinto("Suma", 1, "He aquí un consejo que una vez oí dar a un joven: “Haz siempre lo que temas hacer”. Ralph Waldo Emerson", "Para avanzar suma de dos en dos")),
            new Level(2, "Nivel 2", false, new Laberinto("Suma", 2, "A veces se necesita una ruptura abrumadora para tener un avance innegable.", "Para avanzar suma de tres en tres")),
            new Level(3, "Nivel 3", false, new Laberinto("Suma", 3, "Sé que ha sido duro, pero todavía te estoy animando.", "Para avanzar suma de cuatro en cuatro")),
            new Level(4, "Nivel 4", false, new Laberinto("Suma", 4, "Un poco de progreso todos los días se suma a los grandes resultados.", "Para avanzar suma de cinco en cinco")),
            new Level(5, "Nivel 5", false, new Laberinto("Suma", 5, "Eres más fuerte de lo que crees. Más capaz de lo que alguna vez soñaste. Y a ti te aman más de lo que podrías imaginar.", "Para avanzar suma de seis en seis")),
            new Level(6, "Nivel 6", false, new Laberinto("Suma", 6, "Cuando la vida te derriba, trata de aterrizar sobre tu espalda. Porque si puedes mirar hacia arriba, puedes levantarte. Les Brown", "Para avanzar suma de siete en siete")),
            new Level(7, "Nivel 7", false, new Laberinto("Suma", 7, "Puedes gritar, puedes llorar, pero no te rindas.", "Para avanzar suma de ocho en ocho")),
            new Level(8, "Nivel 8", false, new Laberinto("Suma", 8, "Algún día todo tendrá perfecto sentido. Así que por ahora ríete de la confusión, sonríe a través de las lágrimas y sigue recordándote a ti mismo que todo sucede por una razón.", "Para avanzar suma de nueve en nueve")),
            new Level(9, "Nivel 9", false, new Laberinto("Suma", 9, "Siempre que dudes lo lejos que puedes llegar. Solo recuerda lo lejos que has llegado. Recuerda todo lo que has enfrentado, todas las batallas que has ganado y todos los temores que has superado.", "Para avanzar suma de diez en diez"))

    });
    public Category resta = new Category(3, "Resta","https://github.com/AnivlisLuz/StarTech/releases/download/gifs/Resta.wav","La resta o sustracción es una de las operaciones básicas de la matemática. Restar quiere decir quitar, perder, gastar, separar dos o más cantidades.\nEjemplo:",Images.getResta(),"https://github.com/AnivlisLuz/StarTech/releases/download/gifs/resta.gif", true, new Level[]{
            new Level(1, "Nivel 1", false, new Laberinto("Resta", 1, "La vida me susurraba constantemente que me haría feliz, pero antes de todo me quería hacer fuerte.", "Para avanzar resta de uno en uno")),
            new Level(1, "Nivel 2", false, new Laberinto("Resta", 2, "Eres capaz de cosas increíbles.", "Para avanzar resta de dos en dos")),
            new Level(2, "Nivel 3", false, new Laberinto("Resta", 3, "Pronto, cuando todo este bien, vas a mirar hacia atrás y estarás contento de ver que nunca te rendiste. Brittany Burgunder", "Para avanzar resta de tres en tres")),
            new Level(3, "Nivel 4", false, new Laberinto("Resta", 4, "Se te ha asignado esta montaña para mostrarles a otros que se puede mover.", "Para avanzar resta de cuatro en cuatro")),
            new Level(4, "Nivel 5", false, new Laberinto("Resta", 5, "Nunca debes tener miedo de lo que estás haciendo cuando es correcto. Rosa Parks", "Para avanzar resta de cinco en cinco")),
            new Level(5, "Nivel 6", false, new Laberinto("Resta", 6, "Cree en ti mismo y serás imparable.", "Para avanzar resta de seis en seis")),
            new Level(6, "Nivel 7", false, new Laberinto("Resta", 7, "Estoy tan orgulloso de ti. Solo quería decírtelo en caso de que nadie lo haya hecho.", "Para avanzar resta de siete en siete")),
            new Level(7, "Nivel 8", false, new Laberinto("Resta", 8, "Busca algo positivo en cada día, incluso cuando algunos días tengas que mirar un poco más.", "Para avanzar resta de ocho en ocho")),
            new Level(8, "Nivel 9", false, new Laberinto("Resta", 9, "La clave está en ver a cada uno de los muros que te encuentras en el camino como escalones que se dirigen hacia tu objetivo.", "Para avanzar resta de nueve en nueve")),
            new Level(9, "Nivel 10", false, new Laberinto("Resta", 10, "Solo fallas cuando dejas de intentarlo.", "Para avanzar resta de diez en diez uno"))

    });
    public Category multiplicacion = new Category(4, "Multiplicación","https://github.com/AnivlisLuz/StarTech/releases/download/gifs/Multiplicacion.wav","La multiplicación es una de las operaciones básicas de la matemática. Multiplicar quiere decir juntar o repetir varias veces la misma cantidad.\nEjemplo:",Images.getMultiplicacion(),"https://github.com/AnivlisLuz/StarTech/releases/download/gifs/multiplicacion.gif", true, new Level[]{
            new Level(1, "Nivel 1", false, new Laberinto("Multiplicación", 1, "Solo sé tú mismo. Deja que la gente vea a la persona real, imperfecta, extraña, bella y mágica que eres.", "Para avanzar encuentra los números multiplos de 2")),
            new Level(2, "Nivel 2", false, new Laberinto("Multiplicación", 2, "Nunca he conocido a una persona fuerte con un pasado fácil.", "Para avanzar encuentra los números multiplos de 3")),
            new Level(3, "Nivel 3", false, new Laberinto("Multiplicación", 3, "A mí también me tocó pasar por lo peor para darme cuenta de cómo lo tenía que hacer para llegar a lo mejor.", "Para avanzar encuentra los números multiplos de 4")),
            new Level(4, "Nivel 4", false, new Laberinto("Multiplicación", 4, "Despierta. Levántate. Repite.", "Para avanzar encuentra los números multiplos de 5")),
            new Level(5, "Nivel 5", false, new Laberinto("Multiplicación", 5, "No le temo a las tormentas, porque estoy aprendiendo cómo navegar en mi barco.", "Para avanzar encuentra los números multiplos de 6")),
            new Level(6, "Nivel 6", false, new Laberinto("Multiplicación", 6, "Hazlo siempre lo mejor que puedas. Lo que siembres ahora, cosecharás más tarde. Og Mandino", "Para avanzar encuentra los números multiplos de 7")),
            new Level(7, "Nivel 7", false, new Laberinto("Multiplicación", 7, "Un hombre puede ser tan bueno como quiera ser. Si crees en ti mismo y tienes el coraje, la determinación, la dedicación, el impulso competitivo y estás dispuesto a sacrificar las pequeñas cosas de la vida, pagando el precio por las cosas que valen la pena, se puede hacer. Vince Lombardi", "Para avanzar encuentra los números multiplos de 8")),
            new Level(8, "Nivel 8", false, new Laberinto("Multiplicación", 8, "Sé gentil contigo mismo. ¡Estás haciendo lo mejor que puedes!", "Para avanzar encuentra los números multiplos de 9")),
            new Level(9, "Nivel 9", false, new Laberinto("Multiplicación", 9, "Las dificultades a menudo preparan a la gente común para un destino extraordinario.", "Para avanzar encuentra los números multiplos de 10"))

    });
    public Category division = new Category(5, "División","https://github.com/AnivlisLuz/StarTech/releases/download/gifs/Division.wav","La división es una de las operaciones básicas de la matemática. Dividir quiere decir repartir, distribuir o compartir en partes iguales una cantidad.\nEjemplo:",Images.getDivision(),"https://github.com/AnivlisLuz/StarTech/releases/download/gifs/division.gif", true, new Level[]{
            new Level(1, "Nivel 1", false, new Laberinto("División", 1, "Comienza donde estás. Usa lo que tienes. Haz lo que puedas. Arthur Ashe", "Para avanzar encuentra los números divisibles entre 2")),
            new Level(2, "Nivel 2", false, new Laberinto("División", 2, "La mejor revancha es el éxito masivo. Frank Sinatra", "Para avanzar encuentra los números divisibles entre 3")),
            new Level(3, "Nivel 3", false, new Laberinto("División", 3, "No lo pienses, solo hazlo. Horace", "Para avanzar encuentra los números divisibles entre 4")),
            new Level(4, "Nivel 4", false, new Laberinto("División", 4, "Nunca dejes que una mala situación saque lo peor de ti. ¡Elije mantenerte positivo y ser la persona fuerte que Dios creó!", "Para avanzar encuentra los números divisibles entre 5")),
            new Level(5, "Nivel 5", false, new Laberinto("División", 5, "Siempre parece imposible hasta que se hace. Nelson Mandela", "Para avanzar encuentra los números divisibles entre 6")),
            new Level(6, "Nivel 6", false, new Laberinto("División", 6, "No se puede vencer a la persona que nunca se rinde. Babe Ruth", "Para avanzar encuentra los números divisibles entre 7")),
            new Level(7, "Nivel 7", false, new Laberinto("División", 7, "Cuanto más difícil es el conflicto, más glorioso es el triunfo. Thomas Paine", "Para avanzar encuentra los números divisibles entre 8")),
            new Level(8, "Nivel 8", false, new Laberinto("División", 8, "Establece metas altas, y no te detengas hasta que llegues allí. Bo Jackson", "Para avanzar encuentra los números divisibles entre 9")),
            new Level(9, "Nivel 9", false, new Laberinto("División", 9, "Para tener éxito, primero debemos creer que podemos. Nikos Kazantzakis", "Para avanzar encuentra los números divisibles entre 10"))
    });

    public Category crucigrama = new Category(6, "Crucigramas","","",null,"", false, new Level[]{
            new Level(1, "Nivel 1", false, new Crucigrama("suma", "",1)),
            new Level(2, "Nivel 2", false, new Crucigrama("resta", "",2)),
            new Level(3, "Nivel 3", false, new Crucigrama("multiplicación", "",3)),
            new Level(4, "Nivel 4", false, new Crucigrama("división", "",4)),
            new Level(4, "Nivel 4", false, new Crucigrama("combinados", "",5)),
    });
    public Category combinado = new Category(7, "Combinados","","",null,"", true, new Level[]{
            new Level(1, "Nivel 1", true, new Combinado("suma", "",1)),
            new Level(2, "Nivel 2", false, new Combinado("suma", "",2)),
            new Level(3, "Nivel 3", false, new Combinado("suma", "",3)),
            new Level(4, "Nivel 4", false, new Combinado("suma", "",4)),
            new Level(5, "Nivel 5", false, new Combinado("suma", "",5)),
    });
    public Category sopaResultado = new Category(8, "Sopa de Resultados","","",null,"", false, new Level[]{
    });
    public Category[] getAllCategories() {
        return new Category[]{secuencia, suma, resta, multiplicacion, division, sopaResultado, crucigrama, combinado};
    }
}
