package com.co.practicas.reference_methods;

import lombok.ToString;

import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ConstructorMethodReference {

    public static void main(String[] args) {

        // Necesitamos crear una interfaz funcional y para eso usamos supplier

        //Supplier<MyObject> myObjectSupplier = () -> new MyObject();

        Supplier<MyObject> myObjectSupplier = MyObject::new;

        // Básicamente la lógica del get es la que definimos como referencia a método o como lambda
        System.out.println(myObjectSupplier.get());
    }
}

@ToString
class MyObject{

    private String string;
    private Integer num;

    public MyObject() {
        this.string = UUID.randomUUID().toString();
        this.num = new Random().nextInt(1000);
    }
}
