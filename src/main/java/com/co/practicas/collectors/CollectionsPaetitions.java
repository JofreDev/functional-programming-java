package com.co.practicas.collectors;

import com.co.practicas.util.Database;
import com.co.practicas.util.Videogame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// La partición regresa una estructura de tipo map
public class CollectionsPaetitions {

    public static void main(String[] args) {
        Stream<Videogame> videogameStream = Database.videogames.stream();

        Map<Boolean, List<Videogame>> result = videogameStream.collect(Collectors.partitioningBy(
                v -> v.getPrice() > 15
        ));

        result.forEach((k,v) -> System.out.println(k +" - "+v));
    }


}
