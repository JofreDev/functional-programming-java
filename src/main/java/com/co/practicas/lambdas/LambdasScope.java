package com.co.practicas.lambdas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class LambdasScope {

    public static void main(String[] args) {

        // Definiendo la varaible como volatil
        AtomicInteger num = new AtomicInteger(10);

        // Definiendo cualquier variable como volatil :
        // Se puede poner Cualquier tipo de objeto

        AtomicReference<String> ejemplo= new AtomicReference<>("hi every body");

        /// Una expresión lambda no puede acceder a una variable fuera de su alcance
        /// A menos de que esta sea volatil

        IntStream.range(1,10).forEach(i -> num.set(num.get() + i));

        System.out.println(num.get());
    }
}
