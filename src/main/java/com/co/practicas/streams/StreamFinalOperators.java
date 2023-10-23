package com.co.practicas.streams;

import com.co.practicas.util.Database;
import com.co.practicas.util.Videogame;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFinalOperators {

    public static void main(String[] args) {

        Stream<Videogame> videogame = Database.videogames.stream();

        /*
        countOperator(videogame);

        forEachOperator(videogame);

        anyMatchOperator(videogame);

        allMatchOperator(videogame);

        noneMatchOperator(videogame);

        findFirstOperator(videogame);

        findAnytOperator(videogame);

        reduceOperator(videogame);

        maxOperator(videogame);
        */

        minOperator(videogame);
    }

    static void countOperator(Stream<Videogame> stream){
        System.out.println(stream.count());
    }

    static void forEachOperator(Stream<Videogame> stream){
        stream.forEach(System.out::println);
    }

    // Operadores de match

    /* Con que alguno cumpla la condición responde TRUE */

    static void anyMatchOperator(Stream<Videogame> stream){
        boolean r = stream.anyMatch(v-> v.getTotalSold() > 1000000);

        System.out.println(r);
    }

    /* Todos tienen que cumplir la condición para responder TRUE */

    static void allMatchOperator(Stream<Videogame> stream){
        boolean r = stream.allMatch(v-> v.getTotalSold() > 1);

        System.out.println(r);
    }

    /* Con que un solo elemento no cumpla devuelve false */

    static void noneMatchOperator(Stream<Videogame> stream){
        boolean r = stream.noneMatch(v-> v.getReviews().isEmpty());

        System.out.println(r);
    }

    static void findFirstOperator(Stream<Videogame> stream){
        Optional<Videogame> r = stream.findFirst();

        System.out.println(r.isPresent());
    }

    static void findAnytOperator(Stream<Videogame> stream){
        Optional<Videogame> r = stream.findAny();

        System.out.println(r);
    }

    static void reduceOperator(Stream<Videogame> stream){

        Optional<Integer> r = stream.filter(Videogame::getIsDiscount) // Hasta acá devuelve un stream solo con vd en descuento
                                        .map(Videogame::getTotalSold) // Ahora que nos traiga el total de ventas
                                        .reduce(Integer::sum); // Sumamos (a,b) -> a+b

        System.out.println(r);
    }

    static void maxOperator(Stream<Videogame> stream){

        Optional<Videogame> r = stream.max(Comparator.comparing(Videogame::getName));
        System.out.println(r.get().getName());

    }

    static void minOperator(Stream<Videogame> stream){


        Optional<Videogame> r = stream.min(Comparator.comparing(Videogame::getName));
        System.out.println(r.get().getName());

    }


}
