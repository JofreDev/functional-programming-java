package com.co.practicas.util_function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/* Objetivo Interfaz Function :
 * 1) Trabajar con booleanos
 * */
public class ExamplePredicate {

    static Predicate<Integer> isGreaterThan100 = n -> n>100;

    static Predicate<Integer> isLessThan10 = n -> n<10;

    static Predicate<Integer> isBetweenThan10and100 = isGreaterThan100.or(isLessThan10);


    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,10,50,100,150,200));

        // Se debe usar remove if en java 8 en adelante

        //numbers.removeIf(isBetweenThan10and100); // Negamos la condición

        numbers.removeIf(isBetweenThan10and100.negate());

        System.out.println(numbers);


    }
}
