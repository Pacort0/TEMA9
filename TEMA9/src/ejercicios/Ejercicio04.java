package ejercicios;

import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio04 {

	public static void main(String[] args) {
		char opcion; // Para guardar la elección de si queremos repetir la inserción o no
		int numero; // Guarda el numero que se introduzca por teclado
		int numeros = 5; // Valor máximo de números normales por boleto
		int estrellas = 2; // Valor máximo de estrellas por boleto

		TreeMap<Integer, Integer> boleto = new TreeMap<>(); // Creamos dos mapas TreeMap, que nos ordenan los valores
															// introducidos
		TreeMap<Integer, Integer> estrelas = new TreeMap<>();

		Scanner sc = new Scanner(System.in); // Creamos el escáner del programa

		do {
			for (int i = 0; i < numeros; i++) { // Hacemos un bucle for que rellene los números normales del boleto
				do {
					System.out.println("Introduzca el " + (i + 1) + "º número premiado: ");
					numero = sc.nextInt(); // Pedimos el numero premiado al usuario y lo guardamos
				} while (numero < 0 || numero > 50); // Se pedirá el mismo número mientras éste se pase de rango

				if (!boleto.containsKey(numero) && !estrelas.containsKey(numero)) { // Si el número no ha sido
																					// introducido antes, se introduce
																					// en la lista de boleto
					boleto.put(numero, 1);
				} else if (!boleto.containsKey(numero) && estrelas.containsKey(numero)) { // Si el número ha sido
																							// introducido antes en las
																							// estrellas
					boleto.put(numero, estrelas.get(numero) + 1); // Lo introducimos en 'boleto' con el valor actual de
																	// esa clave(numero) en 'estrella'
					estrelas.replace(numero, estrelas.get(numero) + 1); // Lo reemplazamos en 'estrella' con más valor
				} else if (estrelas.containsKey(numero) && boleto.containsKey(numero)) { // Si el número ya ha sido
																							// introducido en ambas
																							// listas
					boleto.replace(numero, boleto.get(numero) + 1); // Reemplazamos el valor en ambas listas
					estrelas.replace(numero, estrelas.get(numero) + 1);
				} else { // Si no, si el número ya se ha introducido sólo en 'boleto'
					boleto.replace(numero, boleto.get(numero) + 1); // Reemplazamos el valor en boleto
				}
			}

			for (int i = 0; i < estrellas; i++) { //Repetimos el proceso anterior pero para las 'estrellas'
				do {
					System.out.println("Introduzca el valor de la " + (i + 1) + "ª estrella: ");
					numero = sc.nextInt();
				} while (numero <= 0 || numero > 12);

				if (!estrelas.containsKey(numero) && !boleto.containsKey(numero)) {
					estrelas.put(numero, 1);
				} else if (!estrelas.containsKey(numero) && boleto.containsKey(numero)) {
					estrelas.put(numero, boleto.get(numero) + 1);
					boleto.replace(numero, boleto.get(numero) + 1);
				} else if (estrelas.containsKey(numero) && boleto.containsKey(numero)) {
					boleto.replace(numero, boleto.get(numero) + 1);
					estrelas.replace(numero, estrelas.get(numero) + 1);
				} else {
					estrelas.replace(numero, estrelas.get(numero) + 1);
				}
			}

			System.out.println("Boleto: " + boleto); //Mostramos el boleto de números
			System.out.println("Estrellas: " + estrelas); //Mostramos el boleto de estrellas 

			System.out.println("¿Desea introducir otro boleto? (s/n)"); //Preguntamos al usuario si desea repetir el proceso e introducir otro boleto
			opcion = sc.next().charAt(0); //Guardamos el primer caracter que introduzca
		} while (opcion != 'n'); //Se repetirá mientras la opción no sea 'n'
		
		sc.close(); //Cerramos el escáner
	}

}
