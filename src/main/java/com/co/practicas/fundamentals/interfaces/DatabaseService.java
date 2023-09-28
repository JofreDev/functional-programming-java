package com.co.practicas.fundamentals.interfaces;

import java.util.List;

/* Objetivo : Tiene que regresar un Producto o un Employee
* Por lo tanto se quiere que la inerfaz sea generica y use <T>
* ahora el primer método devuelve un T (no sabe que devuelve en concreto
* ahora el segundo método devuelve una List<T>)
* */
public interface DatabaseService<T> {

    T getByYd(Long id);

    List<T> getAllRecords();
}
