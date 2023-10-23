package com.co.practicas.real_applications;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ConcurrenceLambdas {

    // Tanto Runnable como Callable funcionan como callbacks
    // Runnable sin retornar y Callable retornando
    static Runnable printerSum = () -> {
        long aux = 0;

        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i<1000000; i++){

            aux+=i;
        }
        System.out.println("Total : "+aux);
    };

    // Retorna
    static Callable<Long> getSum = () -> {

        long aux = 0;

        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i<1000000; i++){

            aux+=i;
        }

        return aux;
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println(Thread.currentThread().getName());
        var exec = Executors.newSingleThreadExecutor();

        exec.submit(printerSum);

        var result = exec.submit(getSum);

        System.out.println("Result "+result.get());
    }
}
