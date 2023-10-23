package com.co.practicas.util_function;


import lombok.ToString;

import java.util.Random;
import java.util.function.Supplier;

/* Objetivo Interfaz Function :
 * 1)Proveer de algun tipo de objeto
 *     */
public class ExampleSupplier {

    static Supplier<Integer> randomInt = () -> new Random().nextInt(100);

    static Supplier<MyProduct> productSupplier = ()-> new MyProduct(100, "SmartPhone");

    public static void main(String[] args) {
        System.out.println(randomInt.get());
        System.out.println(randomInt.get());
        System.out.println(randomInt.get());
        System.out.println(productSupplier.get());
    }
}
@ToString
class MyProduct {

    private Integer price;
    private String name;

    public MyProduct(Integer price, String name) {
        this.price = price;
        this.name = name;
    }
}
