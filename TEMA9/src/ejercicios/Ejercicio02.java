package ejercicios;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		String nombres = ""; // Creamos una variable para guardar los nombres

		Scanner sc = new Scanner(System.in); // Creamos un escáner para poder leer de consola

		LinkedHashSet<String> listaNombres = new LinkedHashSet<>(); // Creamos una colección LinkedHashSet, que nos
																	// ordena los elementos según el orden de inserción
		while (!nombres.equalsIgnoreCase("fin")) {// Mientras el valor introducido sea diferente de 'fin', el bucle
													// continuará corriendo
			do {
				System.out.println("Introduzca un nombre: ");
				nombres = sc.next(); // Pedimos un nombre y lo guardamos en 'nombres'
			} while (listaNombres.contains(nombres)); // Mientras el número no esté ya previamente en la lista

			if (!nombres.equalsIgnoreCase("fin")) { // Si el valor introducido no ha sido 'fin', guardamos el valor en
													// la lista
				listaNombres.add(nombres);
			}
		}

		System.out.println(listaNombres); // Mostramos la lista final

		sc.close(); // Cerramos el escáner
	}
}
