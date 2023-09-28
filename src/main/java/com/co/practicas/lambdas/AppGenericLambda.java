package com.co.practicas.lambdas;


import com.co.practicas.fundamentals.interfaces.Employee;
import com.co.practicas.fundamentals.interfaces.Product;

public class AppGenericLambda {

    public static void main(String[] args) {

        // Si solo voy a recibir un argumento no es necesario el parentesis
        Printer<String>  printString = string -> System.out.println(string);
        printString.print("Hola Mundo");

        /// Producto
        Printer<Product>  printProduct = p -> System.out.println(p.toString());

        Product myProduct = new Product();
        myProduct.setId(21343L);
        myProduct.setPrice(1000000.2);
        myProduct.setName("headphones");
        printProduct.print(myProduct);

        /// Empleado

        Employee myEmployee = new Employee();

        myEmployee.setDni("787902564");
        myEmployee.setName("Juan David Hernandez Garcia");
        myEmployee.setSalary(6000000.0);

        Printer<Employee>  printEmploye = e -> System.out.println(e.toString());

        printEmploye.print(myEmployee);

    }
}
