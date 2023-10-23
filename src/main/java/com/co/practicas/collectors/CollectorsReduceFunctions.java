package com.co.practicas.collectors;

import com.co.practicas.util.Database;
import com.co.practicas.util.Videogame;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsReduceFunctions {

    public static void main(String[] args) {

        Stream<Videogame> videogameStream = Database.videogames.stream();

        //avg(videogameStream);

        //sum(videogameStream);

        join(videogameStream);

    }

    static void avg(Stream<Videogame> stream){
        Double avg = stream.collect(Collectors.averagingDouble(Videogame::getPrice));
        System.out.println(avg);
    }

    static void sum(Stream<Videogame> stream){
        IntSummaryStatistics summaryStatistics = stream.collect(Collectors.summarizingInt(v -> v.getReviews().size()));
        System.out.println(summaryStatistics);
    }

    static void join(Stream<Videogame> stream){
        String string = stream
                .map(Videogame::toString)
                .collect(Collectors.joining(""));

        System.out.println(string);

    }
}
