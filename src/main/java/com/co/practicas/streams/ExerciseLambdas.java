package com.co.practicas.streams;

import com.co.practicas.util.Console;
import com.co.practicas.util.Database;
import com.co.practicas.util.Review;
import com.co.practicas.util.Videogame;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class ExerciseLambdas {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        //System.out.println(exercise1(videogames));

        System.out.println(exercise5(videogames).toList());
    }

    /*
     *Regresar true si el stream contiene al menos un videojuego con número de ventas mayor a 10
     * y no este en descuento o su precio sea mayor a 9.99 de lo contrario regresar false.
     */
    static Boolean exercise1(Stream<Videogame> stream) {
        return stream.anyMatch( videogame -> videogame.getTotalSold()>10);
    }

    /*
     *Regresar un Stream unicamente con los titulos de todas las consolas que sean de XBOX
     * durante el proceso imprimir los resultados ignorando los repetidos.
     */
    static Stream<String> exercise2(Stream<Videogame> stream) {
        return stream.filter(videogame -> videogame.getConsole().equals(Console.XBOX))
                .map(Videogame::getName).distinct();
    }

    /*
     *Regresar el videojuego con el mayor número de ventas
     * unicamente contemplando los primers 10 elementos del stream.
     */
    static Videogame exercise3(Stream<Videogame> stream) {
        Optional<Videogame> max = stream.limit(10).max(Comparator.comparingInt(videogame -> videogame.getTotalSold()));
        return max.get();
    }

    /*
     *Regresar un stream con todos los comentarios del cada review de todos los videojuegos del stream.
     */
    static Stream<String> exercise4(Stream<Videogame> stream) {
        return stream.flatMap(v->  v.getReviews().stream()).map(Review::getComment);
    }

    /*
     *Regresar un stream con los todos los videojuegos con precio menores a 20.0
     * sin utilizar el operador filter().
     */
    static Stream<Double> exercise5(Stream<Videogame> stream) {
        return stream.sorted(Comparator.comparing(Videogame::getPrice)).takeWhile(videogame -> videogame.getPrice() < 20.0)
                .map(Videogame::getPrice);
    }
}
