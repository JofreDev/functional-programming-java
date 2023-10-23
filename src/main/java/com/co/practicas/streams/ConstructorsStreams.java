package com.co.practicas.streams;

import com.co.practicas.util.Database;
import com.co.practicas.util.Videogame;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;


/* Creación de streams */
public class ConstructorsStreams {

    public static void main(String[] args) {

        Stream<Videogame> myStream = Database.videogames.stream();

        myStream.forEach(System.out::println);

        System.out.println("-------- ");

        Integer[] myArray = {1,2,3,4,5,6,7,8,9,10};

        Stream<Integer> intStream =  Arrays.stream(myArray);

        intStream.forEach(System.out::println);

        Stream.of("Hola", "Mundo").forEach(System.out::println);

        DoubleStream myDoubleStream = DoubleStream.of(20.3,30.2,0.0);

        myDoubleStream.forEach(System.out::println);

    }
}
