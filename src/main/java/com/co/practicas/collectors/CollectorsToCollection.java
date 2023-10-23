package com.co.practicas.collectors;

import com.co.practicas.util.Database;
import com.co.practicas.util.Videogame;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsToCollection {

    public static void main(String[] args) {

        Stream<Videogame> videogameStream = Database.videogames.stream();

        //System.out.println(streamToCollection(videogameStream, "List").getClass().getName());

        //System.out.println(streamToCollection(videogameStream, "SET").getClass().getName());

        streamToMap(videogameStream).forEach((k,v) -> System.out.println(k +" - "+v));



    }

    static Collection<Videogame> streamToCollection (Stream<Videogame> stream, String type){
        return (type.equals("List")) ? stream.collect(Collectors.toList()) : stream.collect(Collectors.toSet());
    }

    static Map<String,Double> streamToMap(Stream<Videogame> stream){
        return stream.distinct().collect(Collectors.toMap(Videogame::getName,Videogame::getPrice));
    }
}
