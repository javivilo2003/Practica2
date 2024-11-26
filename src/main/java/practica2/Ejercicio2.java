package practica2;
/**
 * Programa que devuelve números aleatorios, se compone de dos funciones en la
 * que una pide la cantidad de números que quiere imprimir dentro de un rango y la otra función pide
 * solo la cantidad de número que quiere imprimir en un rango de 0 a 1
 * @author Piera Merlo
 * @author Javier Viloria
 */

import java.util.Scanner;

public class Ejercicio2 {

    /**
     * Esta función imprime números aleatorios que solicita el usuario en un rango personalizado por este.
     * @param cantidad número introducido por el usuario para determinar cuantos números imprimir
     * @param minimo número con el que empieza el rango
     * @param maximo número con el que termina el rango
     */
    public static void numerosAleatorios(int cantidad, int minimo, int maximo){
        int resultado=0;

        for(int i = cantidad; i >= 1; i--){
            resultado = (int)(Math.random() * (maximo - minimo + 1) + minimo);
            System.out.print(resultado + " ");
        }
    }
    /**
     * Esta función imprime la cantidad de números aleatorios introducído por el usuario entre 0 y 1.
     * @param cantidad cantidad de números aleatorios a imprimir
     */
    public static void numerosAleatorios(int cantidad){
        double resultado = 0;

        for (int i = cantidad; i >= 1; i--){
            resultado = Math.random();
            System.out.print(resultado + "  ");
        }
    }

    /**
     * Función que verifica que los datos introducidos son correctos para poder llamar a la función en el main.
     * @param cantidad número de veces que el usuario quiere imprimir números aleatorios
     * @param minimo número con el que empieza el rango
     * @param maximo número con el que termina el rango
     * @return devuelve un booleano en el que si los datos son correctos es false, para salir del bucle en el main
     * y si son incorrectos devuelve true para pedir los datos de nuevo en el main
     */

    public static boolean datosCorrectos (int cantidad, int minimo, int maximo){
        boolean datosIncorrectos;

        if(cantidad < 1 || minimo > maximo) {//Sigue en el do while del main mientras no introduzca los datos correctos
            System.out.println("¡Error!\n" +
                    "La cantidad de números a imprimir no puede ser menor a 1 y/o\n" +
                    "el rango mínimo no puede ser mayor que el rango máximo.\n" +
                    "Por favor introduce de nuevo los datos.");
            datosIncorrectos = true;
        }else{ //Si los datos son correctos sale del do while en el main
            datosIncorrectos = false;
        }

        return datosIncorrectos;
    }

    /**
     * Función que verifica que la cantidad introducida por el usuario sea mayor a 1
     * @param cantidad número de veces que el usuario quiere imprimir números aleatorios
     * @return devuelve un booleano en el que si los datos son correctos es false, para salir del bucle en el main
     * y si son incorrectos devuelve true para pedir los datos de nuevo en el main
     */

    public static boolean datosCorrectos (int cantidad){
        boolean datosIncorrectos;

        if(cantidad < 1) {//Sigue en el do while del main mientras no introduzca los datos correctos
            System.out.println("La cantidad no puede ser menor a 1. Por favor, introduce de nuevo los datos.");
            datosIncorrectos = true;
        }else{ //Si los datos son correctos sale del do while en el main
            datosIncorrectos = false;
        }

        return datosIncorrectos ;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cantidad1, cantidad2, minimo, maximo;


        do {
            System.out.println("Dime cuantos número quieres imprimir: ");
            cantidad1 = sc.nextInt();
            System.out.println("Dime el rango mínimo: ");
            minimo = sc.nextInt();
            System.out.println("Dime el rango máximo: ");
            maximo = sc.nextInt();

        }while (datosCorrectos(cantidad1, minimo, maximo)); //Comprueba que los datos introducidos sean correctos
                                                            // si no lo son salta mensaje de error

        System.out.println(cantidad1 + " números aleatorios entre " + minimo + " y " + maximo + ":");
        numerosAleatorios(cantidad1,minimo, maximo);


        do {
            System.out.println("\nDime cuantos números quieres imprimir del 0 al 1: ");
            cantidad2 = sc.nextInt();

        }while (datosCorrectos(cantidad2)); //Comprueba que los datos introducidos sean correctos
                                            // si no lo son salta mensaje de error

        System.out.println(cantidad2 + " números aleatorios entre 0 y 1:");
        numerosAleatorios(cantidad2);


    }
}
