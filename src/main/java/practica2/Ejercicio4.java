package practica2;

import java.util.Scanner;

/**
 * Programa que simula una app de un parque de atracciones
 * @author Piera Merlo
 * @author Javier Viloria
 */

public class Ejercicio4 {
    /**
     * Función que comprueba que usuario y contraseña sean correctas
     * @param usuarioReal primer usuario introducido por teclado
     * @param userIntroducido repetición de usuario introducido por teclado
     * @param passwReal primera contraseña introducida por teclado
     * @param psswwIntroducido repetición de la contraseña introducida por teclado
     * @return devuelve true si el acceso es denegado y false si es correcto
     */

    public static boolean login (String usuarioReal, String userIntroducido, String passwReal, String psswwIntroducido){
        boolean accesoDenegado;
        if (usuarioReal.equals(userIntroducido) && passwReal.equals(psswwIntroducido)){
            accesoDenegado = false;
        }else{
            accesoDenegado = true;
        }
        return accesoDenegado;
    }

    /**
     * Función que muestra el menú de opciones al loguearte de forma correcta
     */

    public static void mostrarMenuOpciones(){

        System.out.println("******** Menú Opciones ************");
        System.out.println("1. Atracciones del parque\n" +
                "2. Restauración \n" +
                "3. Días con entradas disponibles\n" +
                "4. Entradas y precios\n" +
                "5. ¡Participa en el sorteo!\n" +
                "6. Salir de la aplicación");
    }

    /**
     * Función de la opción 1 que muestra las atracciones
     */

    public static void mostrarAtracciones(){

        System.out.println("****** Atracciones *******");
        System.out.println("1- Los rápidos. Intensidad: suave\n" +
                "2- Sillas voladoras. Intensidad: moderada\n" +
                "3- La lanzadera. Intensidad: alta\n" +
                "4- Star Flyer. Intensidad: alta\n" +
                "5- Vértigo. Intensidad: moderada\n" +
                "6- Los Fiordos. Intensidad: moderada");
    }

    /**
     * Función de la opción dos que muestra los restaurantes
     */

    public static void mostrarRestaurantes(){

        System.out.println("- La Super plaza\n" +
                "   ¡En La Plaza disfrutarás los mejores Hot Dogs!\n" +
                "- FoodTruck Adrenalina\n" +
                "   El yougurt helado con los toppings más deliciosos y frescos.\n" +
                "- Burger Alegría\n" +
                "   Si pruebas nuestras increíbles hamburguesas, repetirás en cada visita.\n" +
                "-Freeze Brain\n" +
                "   ¡Disfruta de un rico granizado!");
    }

    /**
     * Función llamada al introducir la opción 3, que según el més, muestra la cantidad de días que tiene dicho mes
     * @param mes mes introducido en formato de número por el usuario
     * @return devuelve el número de días que tiene el mes escogido
     */

    public static int cantidadDeDias(int mes){
        int dias = 0;
        switch(mes){
            case 1, 3, 5, 7, 8, 10, 12 -> dias = 31;
            case 2 -> dias = 28;
            case 4, 6, 9, 11 -> dias = 30;
        }
        return dias;
    }

    /**
     * Función que saca un número aleatorio dependiendo del máximo que corresponde a la
     * cantidad de días que tenga el mes
     * cantidadDeDias para establecer el máximo
     * @param maximo número máximo para generar el número aleatorio, en este caso a través de la función cantidadDeDias
     * @return retorna número aleatorio
     */

    public static int numeroAleatorio(int maximo){
        int fechaDisponible =(int) (Math.random() * cantidadDeDias(maximo) + 1);
        return fechaDisponible;
    }

    /**
     *Función que imprime números aleatorios (serán los días disponibles) las veces que se imprimen los números
     * dependen del número aleatorio que nos da la función numeroAleatorio.
     * @param mes mes que escogió el usuario por teclado, este se imprimirá.
     */

    public static void diasDisponibles(int mes){
       int disponible =  (int) (Math.random() * 10) + 1;
        System.out.println("Días disponibles del mes " + mes);
       for (int i = 1; i <= disponible; i++){
           System.out.print(numeroAleatorio(disponible) + " ");
       }
    }

    /**
     *Función que muestra los precios de las entradas al seleccionar la opción 4
     */

    public static void mostrarPrecios(){
        System.out.println("- Entrada reducida (<140cm) = 29,90€\n" +
                "- Entrada general: 39,90€");
    }

    /**
     * Función que calcula el importe total de todas las entradas escogidas
     * @param entradaReducida cantidad de entradas reducidas escogidas
     * @param entradaGeneral cantidad de entradas generales escogidas
     * @return devuelve el total de la operación de calcular todas las entradas
     */

    public static double calcularImporte(int entradaReducida, int entradaGeneral){
        final double GENERAL = 39.90, REDUCIDA = 29.90;
        double importeTotal = (entradaReducida * REDUCIDA) + (entradaGeneral * GENERAL);

        return importeTotal;
    }

    /**
     * Función que da un descuento al usuario dependiendo del importe total que han de pagar
     * @param importe total del importe de las entradas
     * @return devuelve el número que corresponde al descuento
     */

    public static int descuentoAsociado(double importe){
        int total;

        if(importe > 50 && importe < 100){
            total = 5;
        } else if (importe > 100 && importe < 200) {
            total = 10;
        } else if (importe > 200) {
            total = 30;
        }else {
            total = 0;
        }

        return total;
    }

    /**
     * Función que aplica el descuento al importe final
     * @param importe total del importe
     * @param descuento numero del descuento
     * @return devuelve la operación del importe final menos el descuento aplicado
     */

    public static double aplicarDescuento(double importe, int descuento){

        double importeTotal = 0;
         importeTotal = importe - (importe * descuento / 100);
        return importeTotal;

    }

    /**
     * Función que dice si el numero introducido es primo o no
     * @param numero numero introducido por consola
     * @return devuelve true si es primo y false si no lo es
     */

    public static boolean esPrimo(int numero){
        boolean primo = true; // Iniciamos diciendo que si es primo

        if (numero <= 1){
            primo = false; // Los números menor o igual a 1 no son primos
        }else{
            //Sacamos la raíz cuadrada del número para que el código sea más eficiente
            // y no recorra números de más, solo el número de su raíz cuadrada, acortando el rango del bucle.
            for( int i = 2; i <= Math.sqrt(numero); i++){
                if (numero % i == 0){ // Si el numero tiene divisor no es primo
                    primo = false;
                }
            }
        }
        return primo;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Registrate en nuestra app para acceder al parque de atracciones");

        System.out.println("Establece un usuario: ");
        String usuario = sc.nextLine();
        System.out.println("Establece una contraseña: ");
        String password = sc.nextLine();

        String user;
        String pssww;
        do {
            System.out.println("Ingresa tus credenciales: ");
            System.out.println("Usuario: ");
            user = sc.nextLine();
            System.out.println("Contraseña: ");
            pssww = sc.nextLine();

        } while (login(usuario, user, password, pssww));


        int opcion;

        do {
            mostrarMenuOpciones();
            System.out.println("Escribe la opción que deseas: ");
            opcion = sc.nextInt();
            int mes;

            switch (opcion) {
                case 1 -> mostrarAtracciones();
                case 2 -> mostrarRestaurantes();
                case 3 -> {
                    System.out.println("Introduce el mes: ");
                    mes = sc.nextInt();
                    numeroAleatorio(cantidadDeDias(mes));
                    diasDisponibles(mes);

                }
                case 4 -> {
                    char verDescuento;
                    mostrarPrecios();
                    System.out.println("Deseas consultar cuál será el importe en función del número de entradas (S/N): ");
                    verDescuento = sc.next().charAt(0);
                    System.out.println("Dime la cantidad de entradas reducidas: ");
                    int reducida = sc.nextInt();
                    System.out.println("Dime la cantidad de entradas generales: ");
                    int generales = sc.nextInt();
                    double total = calcularImporte(reducida, generales);
                    System.out.println("Importe total: " + total);
                    int descuento = descuentoAsociado(total);
                    double aplicarDescuento = aplicarDescuento(total, descuento);

                    if (verDescuento == 's' || verDescuento == 'S') {
                        System.out.println("Aplicable descuento del " + descuento + "%");
                    }

                    System.out.println("Importe Final: " + aplicarDescuento);

                }
                case 5 -> {
                    int numPremio;
                    System.out.println("Introduce el número que quieras y podrás ganar un premio: ");
                    numPremio = sc.nextInt();
                    System.out.println(esPrimo(numPremio));
                }
                case 6 -> System.out.println("Hasta pronto :D ");
                default -> System.out.println("Opción no disponible... Vuelva a intentarlo.");

            }

        } while (opcion != 6);


    }
}
