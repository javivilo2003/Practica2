package practica2;
/**
 * Este programa pide al usuario que introduzca un número entero positivo y devuelve la cantidad de
 * dígitos que contiene el número entero
 * @author Piera Merlo
 * @author Javier Viloria
 */

import java.util.Scanner;

public class Ejercicio1 {
    /**
     * Esta función recursiva cuenta los dígitos de un número introducido
     * @param num número introducido
     * @return Devuelve la cantidad de dígitos del número introducido
     */
    public static int contarDigitos(int num) {
    int resultado;
        if(num < 10){
            resultado = 1;
        } else{
            resultado = 1 + contarDigitos(num / 10);
        }
        return resultado;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        // Este do while se asegura que el usuario introduzca un número positivo,
        // de lo contrario, pedirá los datos otra vez.
        do {
            System.out.println("Introduce un numero positivo:");
            num = sc.nextInt();

        }while(num < 0);

        System.out.println("Dígitos: " + contarDigitos(num));
    }
}


