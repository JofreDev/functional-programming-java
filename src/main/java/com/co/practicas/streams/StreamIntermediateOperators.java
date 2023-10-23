package com.co.practicas.streams;

import com.co.practicas.util.BasicVideogame;
import com.co.practicas.util.Database;
import com.co.practicas.util.Review;
import com.co.practicas.util.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperators {

    public static void main(String[] args) {

        Stream<Videogame> videogame = Database.videogames.stream();

        //distincOperator(videogame);

        //limitOperator(videogame);

        //skipOperator(videogame);

        //filterOperator(videogame);

        //mapOperator(videogame);

        //map2Operator(videogame);

        //flatMapOperator(videogame);

        //mapVSFlatMapOperator(videogame);

        //peekOperator(videogame);

        //sortOperator(videogame);
        //takeWhileOperator(videogame);

        dropWhileOperator(videogame);





    }

    static void distincOperator(Stream<Videogame> stream){
        System.out.println(stream.distinct().count());
    }

    // Primeros 5
    static void limitOperator(Stream<Videogame> stream){
        List<Videogame> r = stream.limit(5).toList();
        r.forEach(System.out::println);
    }

    // Ultimos 5 (Se salta los primeros 15)
    static void skipOperator(Stream<Videogame> stream){
        List<Videogame> r = stream.skip(15).toList();
        r.forEach(System.out::println);
    }

    static void filterOperator(Stream<Videogame> stream){
        List<Videogame> r = stream
                .filter(v -> v.getPrice()> 12.0)
                        .filter(v -> !v.getIsDiscount())
                        .filter(v -> v.getOfficialWebsite().contains("forza"))
                                .toList();

        r.forEach(System.out::println);
    }

    // vamos ha mapear con .map

    static void mapOperator(Stream<Videogame> stream){
        List<BasicVideogame> r = stream
                .map(v -> {
                    return BasicVideogame.builder()
                            .name(v.getName())
                            .price(v.getPrice())
                            .console(v.getConsole())
                            .build();
                }).toList();

        r.forEach(System.out::println);
    }


    static void map2Operator(Stream<Videogame> stream){
        List<BasicVideogame> basicVideogames = stream
                .map(v -> {
                    return BasicVideogame.builder()
                            .name(v.getName())
                            .price(v.getPrice())
                            .console(v.getConsole())
                            .build();
                }).toList();

        // Se tiene que crear un nuevo stream porque el original ya se cerro
        // en el mapeo anterior

        /*
        Stream<BasicVideogame> stream2 = basicVideogames.stream();
        List<String> titles = stream2.map(BasicVideogame::getName).toList();
        */

        // Una mejor forma :

        //basicVideogames.stream() devuelve un nuevo stream
        List<String> titles = basicVideogames.stream().map(BasicVideogame::getName).toList();



        basicVideogames.forEach(System.out::println);

        System.out.println("------------");
        titles.forEach(System.out::println);
    }

    static void flatMapOperator(Stream<Videogame> stream){

        List<Review> r = stream.flatMap(v -> v.getReviews().stream()).toList();

        System.out.println(r);

    }

    static void mapVSFlatMapOperator(Stream<Videogame> stream){

        // Supongamos que quiero saber todas las reviews de mi Base de Datos
        // Cuanta gente a comentado el videojuego

        /* La solución no cuenta el total de reviews que hay,
        * cuenta el total de listas de reviews que hay nada más*/
        //var totalReviews = stream.map(v -> v.getReviews().size()).collect(Collectors.toList());

        //System.out.println(totalReviews.size());

        /*
           Solución con flatmap que si aplana todas las listas de Review
         * y ademas hace el conteo total
         * */

        Long totalReviewsFlatMap = stream.flatMap(v -> v.getReviews().stream()).count();

        System.out.println(totalReviewsFlatMap);


    }

    static void peekOperator(Stream<Videogame> stream){

        /// Peek al ser operador intermedio devuelve otro stream (Para seguir trabajando en un pipeline)
        // Más no el resultado de la impresión

        // Peek necesita un .toList si no va a seguir el pipeline
        //stream.peek(System.out::println).toList();

        // Método peek sirve para hacer una operación sobre un stream que regresa otro stream
        stream.peek(v -> v.setName("")).forEach(System.out::println);

    }

    static void sortOperator(Stream<Videogame> stream){

        List<Videogame> listSorted = stream.sorted(Comparator.comparingInt(v -> v.getReviews().size())).toList();

        System.out.println(listSorted);

    }


    // Va a tomar todos los registros anteriores a los que empiezan con M. Por eso hay que
    // ordenarlo desde antes. Ignora lo que empieza con M y lo que está despues de la M

    static void takeWhileOperator(Stream<Videogame> stream){

        // Se ordena alfabeticamente
        List<Videogame> listSorted = stream.sorted(Comparator.comparing(Videogame::getName))
                .takeWhile(v -> !v.getName().startsWith("M"))
                .toList();

        System.out.println(listSorted);

    }

    // Va a tomar todos los registros posteriores a los que empiezan con M.

    static void dropWhileOperator(Stream<Videogame> stream){

        // Se ordena alfabeticamente
        List<Videogame> listSorted = stream.sorted(Comparator.comparing(Videogame::getName))
                .dropWhile(v -> !v.getName().startsWith("M"))
                .toList();

        System.out.println(listSorted);

    }




}
