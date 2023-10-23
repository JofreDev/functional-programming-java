package com.co.practicas.debugger;

import com.co.practicas.util.Database;
import com.co.practicas.util.Review;
import com.co.practicas.util.Videogame;

import java.util.Comparator;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        Stream<Videogame> videogameStream = Database.videogames.stream();

        var myArray = videogameStream
                .distinct()
                .sorted(Comparator.comparing(Videogame::getTotalSold))
                .flatMap(videogame -> videogame.getReviews().stream())
                .map(Review::getComment)
                .filter( comment -> comment.contains("best"))
                .map("Goo comment"::concat)
                .toArray();

        System.out.println(myArray);


    }
}
