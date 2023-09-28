package com.co.practicas.lambdas;

@FunctionalInterface // Debe tener un método abstracto
public interface Math {

    Double execute(Double a, Double b);

    // Podemos tener metodos por default

    default Double sum(Double a, Double b) {return a + b;}
}
