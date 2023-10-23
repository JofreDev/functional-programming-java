package com.co.practicas.util_function;

import lombok.ToString;

import java.io.*;
import java.util.Arrays;
import java.util.function.Function;

/* Objetivo Interfaz Function :
 * 1) Realizar operaciones con objetos */
public class ExampleFunction2 {

    static Function<Person, ByteArrayOutputStream> serializer = p -> {
        ByteArrayOutputStream inMemoryBytes = new ByteArrayOutputStream();

        try (ObjectOutputStream outputStream = new ObjectOutputStream(inMemoryBytes)){ // Se cierra automáticamente

            outputStream.writeObject(p);
            outputStream.flush();

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return inMemoryBytes;
    };

    static Function<ByteArrayInputStream, Person> deserializer = bais -> {

        try(ObjectInputStream objectInputStream = new ObjectInputStream(bais)){

            return (Person) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    };



    public static void main(String[] args) {

        ByteArrayOutputStream objectSerialized = serializer.apply(new Person("Max", 26));

        System.out.println(Arrays.toString(((objectSerialized.toByteArray()))));

        Person objectDeserialized = deserializer.apply(new ByteArrayInputStream(objectSerialized.toByteArray()));
        System.out.println(objectDeserialized);



    }
}

@ToString
class Person implements Serializable{ // Convertir a 1's y 0's

    private String name;
    private  Integer age;

    public Person (String name, Integer age){

        this.name = name;
        this.age = age;
    }


}
