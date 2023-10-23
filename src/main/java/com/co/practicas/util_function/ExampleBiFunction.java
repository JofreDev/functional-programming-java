package com.co.practicas.util_function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class ExampleBiFunction {

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("a","b","c");
        List<Integer> list2 = Arrays.asList(1,2,3);

        List<String> result = listCombiner(list1,list2, (l1,l2) -> l1+l2);
        System.out.println(result);

        System.out.println(concatenar.apply(list1,list2));


    }

    // Acá pasamos la lambda por parametro !!!

    private static<T,U,R> List<R> listCombiner(
            List<T> list1,
            List<U> list2,
            BiFunction<T,U,R> combiner
    ){

        List<R> result = new ArrayList<>();
        for(int i =0; i<list1.size();i++){
            result.add(combiner.apply(list1.get(i),list2.get(i)));
        }
        return result;
    };

    // Una forma directa pero menos flexible de hacerlo

    static BiFunction<List<String>,List<Integer>,List<String>> concatenar = (l1,l2) -> {

        List<String> results = new ArrayList<>();
        l1.forEach( l -> results.add(String.valueOf(l+l2.get(l1.indexOf(l)) )));
        return results;

    };

}
