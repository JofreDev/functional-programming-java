package com.co.practicas.reference_methods;

import java.util.Comparator;
import java.util.function.BiPredicate;

public class ArbitraryMethodReference {

    public static void main(String[] args) {

        /// Interface funcional de java
        ///BiPredicate<String,String> equals = (s1,s2) -> s1.equals(s2);

        // Por referencia arbitraria

        // equals no es arbitrario, y se hace referencia a String para poder usar el equals
        BiPredicate<String,String> equals = String::equals;
        System.out.println(equals.test("hola","ejemplo"));

        Comparator<String> c2 = String::compareTo;
        System.out.println(c2.compare("h","j"));;
    }
    }

