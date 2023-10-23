package com.co.practicas.util_function;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/* Objetivo Interfaz Function :
 * 1) Realizar operaciones con el tipo de objetos especificado en el parametro. Espera un a y un b (Dos parametros)
 *    Debe devolver un objeto del mismo tipo que el especificado en el parametro
 *  Nota: extiende de BiFunction */
public class ExampleBinaryOperator {

    public static void main(String[] args) {

        BiFunction<String,String,String> normalizerFunc = (a,b) -> a.toUpperCase().concat(" - ").concat(b.toLowerCase());
        System.out.println(normalizerFunc.apply("hola","mundo"));

        // BinaryOperator es menos redundante
        // Así especificamos que tanto a como b serán string
        BinaryOperator<String> normalizer = (a, b) -> a.toUpperCase().concat(" - ").concat(b.toLowerCase());
        System.out.println(normalizer.apply("hola","mundo"));
    }
}
