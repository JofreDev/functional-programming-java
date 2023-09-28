package com.co.practicas.fundamentals.interfaces;

import java.util.List;
import java.util.UUID;

// Se le especifica a la implementación (por medio del diamante)
// de que tipo será la propia implementación
public class EmployeDB implements DatabaseService<Employee> {
    @Override
    public Employee getByYd(Long id) {
        Employee e = new Employee();
        e.setDni(UUID.randomUUID().toString()); // Clase UUID de java
        e.setName("Pedro");
        e.setSalary(10000.0);
        return e;
    }

    @Override
    public List<Employee> getAllRecords() {
        return null;
    } // Se le especifica al diamante de que tipo va a se la implementación
}
