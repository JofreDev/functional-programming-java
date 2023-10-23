package com.co.practicas.collectors;

import com.co.practicas.util.Console;
import com.co.practicas.util.Database;
import com.co.practicas.util.Videogame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsGroupBy {

    public static void main(String[] args) {
        Stream<Videogame> videogameStream = Database.videogames.stream();


        Map<Console, List<Videogame>> result = videogameStream.collect(Collectors.groupingBy(Videogame::getConsole));
        result.forEach((k,v) -> System.out.println(k +" - "+v));
    }
}
