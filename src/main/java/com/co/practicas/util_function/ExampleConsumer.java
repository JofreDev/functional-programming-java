package com.co.practicas.util_function;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* Objetivo Interfaz Function :
 * 1) Realizar operaciones con objetos
 *    pero sin devolver ningun resultado   */
public class ExampleConsumer {

    public static void main(String[] args) {
        Set<Integer> nums = Set.of(1,2,3,4,5);

        List<Integer> squares = new LinkedList<>();

        nums.forEach(n -> squares.add(n*n));
        System.out.println(squares);

        Map<Boolean,String> map = Map.of(true,"this is the truth",false,"this is the lie");
        // Recibe una interfaz biconsumer
        map.forEach((k,v) -> System.out.println(k+" - "+v));
    }
}
