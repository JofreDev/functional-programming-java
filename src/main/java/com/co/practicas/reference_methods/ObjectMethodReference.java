package com.co.practicas.reference_methods;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/* Referencia de metodo por objeto */
public class ObjectMethodReference {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(10);


        IntStream repeat = IntStream.range(1,11);
        //repeat.forEach(System.out::println);

        /* Con expresión lambda
        repeat.forEach( i -> numbers.add(i));
        */

        /* Metodo referenciado
        * No se pasa por parametro a un 'i'
        * */
        repeat.forEach(numbers::add);


        System.out.println(numbers);
    }
}
