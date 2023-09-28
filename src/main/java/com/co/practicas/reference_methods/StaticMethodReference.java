package com.co.practicas.reference_methods;

import java.util.UUID;
import java.util.function.Supplier;

/* referenci a métodos estáticos */

public class StaticMethodReference {

    public static void main(String[] args) {

        // Supplier es una interfaz funcional
        // Ejemplo con lambda
        //Supplier<UUID> getToken = () -> UUID.randomUUID();

        // Ejemplo con referencia a metodo

        Supplier<UUID> getToken = UUID::randomUUID;

        System.out.println(getToken.get());

    }
}
