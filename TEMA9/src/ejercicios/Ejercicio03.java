package ejercicios;

import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio03 {

	public static void main(String[] args) {
		String nombres = ""; // Creamos una variable donde guardar los nombres que se introduzcan

		Scanner sc = new Scanner(System.in); // Creamos el escáner
		TreeSet<String> listaNombres = new TreeSet<>();// Creamos una colección tipo TreeSet, que nos va a ordenar los
														// elementos que introduzcamos por orden alfabético
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
