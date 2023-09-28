package com.co.practicas.lambdas;

@FunctionalInterface
public interface Printer<T> {

    // La idea es imprimir cualquier objeto
    // Por lo tant tiene que ser genérico
    void print(T tuPrint);
}
