package com.co.practicas.real_applications;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFile {

    public static void main(String[] args) {

        Path file = Paths.get("src/main/resources/lambdas.txt");

        // Cierra automáticamente el buffer
        try(Stream<String> lines = Files.lines(file).onClose(() -> System.out.println("Closing reader"))) {

            lines.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
