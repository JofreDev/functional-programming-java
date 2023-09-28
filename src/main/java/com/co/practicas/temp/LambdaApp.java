package com.co.practicas.temp;


import com.co.practicas.lambdas.Math;

public class LambdaApp {

    public static void main(String[] args){

        // clase anonima
        Math substract = new Math() {
            @Override
            public Double execute(Double a, Double b) {
                return a - b;
            }
        };
        //System.out.println(substract.execute( 5.0, 5.0));

        Math multiply = (a,b) -> a * b;

        //System.out.println(multiply.execute(100.0,15.0));

        Math divide = (a,b) -> {

            return a/b; // Es obligatorio el return con las llaves !
        };

        System.out.println(divide.execute(100.0,15.0));

    }
}
