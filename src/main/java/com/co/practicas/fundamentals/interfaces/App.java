package com.co.practicas.fundamentals.interfaces;

import java.util.List;

public class App {

    public static void main(String[] args){

        /*
        ProductDB productDB = new ProductDB();
        EmployeDB employeDB = new EmployeDB();

        System.out.println(productDB.getByYd(2L));
        System.out.println(employeDB.getByYd(1L));
         */

        System.out.println(Product.class.getName());
        System.out.println(Employee.class.getName());
        System.out.println(String.class.getName());

        /* Al ser una clase anonima, el compilador le agrega un
         * nombre automáticamente
         */
        DatabaseService<String> dbAnonimo = new DatabaseService<>() {
            @Override
            public String getByYd(Long id) {
                return null;
            }

            @Override
            public List<String> getAllRecords() {
                return null;
            }
        };

        System.out.println(dbAnonimo.getClass().getName());

    }
}
