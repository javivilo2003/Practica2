package practica2;

import java.util.Scanner;

/**
 * Programa que solicita al usuario los lados de un cuadrado para imprimir un cuadrado hueco.
 * @author Piera Merlo
 * @author Javier Viloria
 */

public class Ejercicio3 {

    /**
     * Función que imprime una línea de carácteres en la que se le introduce letra y su longitud
     * @param letra letra que se escoge para imprimir x veces
     * @param longitud longitud que se escoge para imprimir la letra x veces
     */

    public static void pintarRepetido(char letra, int longitud){
        for (int i = longitud; i >= 1; i--){
            System.out.print(letra + " ");
        }
        System.out.println();
    }

    /**
     * Función que se le introduce los parámetros de letra y longitud para poder determinar la altura del cuadrado
     * y su hueco, se usará la función anterior pintarRepetido(), para imprimir la tapa y la base del cuadrado
     * @param letra letra que introducirá el usuario
     * @param longitud longitud que introducirá el usuarió y será el lado por lado de un cuadrado
     */
    public static void cuadradoHueco(char letra, int longitud){
        pintarRepetido(letra, longitud); //Primera línea

        //Restamos 2 vueltas al for, ya que tenemos la primera y ultima linea fuera de este.
        for(int i = 0; i < longitud-2; i ++){
            System.out.print(letra + " "); //Imprime carácter del lateral izquierdo
            for (int j = 0; j < longitud -2; j++){//Se le quita 2 vueltas ya qué los laterales van en el anterior bucle
                System.out.print("  "); //Imprime los espacios del hueco
            }
            System.out.println(letra); // Imprime carácter del lateral derecho
        }
        pintarRepetido(letra, longitud); //Última línea
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base;
        char letra, seguir;

        do {
            do {
                System.out.println("Introduce un número mayor que 2 para hacer un cuadrado: ");
                base = sc.nextInt();

            }while(base <= 2);

            System.out.println("Introduce un carácter: ");
            letra = sc.next().charAt(0);
            cuadradoHueco(letra, base);

            System.out.println("¿Quieres pintar otro cuadrado? S/N");
            seguir = sc.next().charAt(0);
        }while (seguir == 'S' || seguir == 's');

    }

}
