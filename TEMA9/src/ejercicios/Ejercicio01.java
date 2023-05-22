package ejercicios;

import java.util.TreeSet;

public class Ejercicio01 {

	public static void main(String[] args) {
		int numero; // Variable para almacenar los valores de los numeros aleatorios

		TreeSet<Integer> listaNums = new TreeSet<>(); // Creamos una colección TreeSet, que ordena los valores que le
														// introduzcamos automáticamente
		for (int i = 0; i < 20; i++) { // Hacemos un bucle para que sólo se generen 20 números
			do {
				numero = ((int) (Math.random() * 100)); // Creamos un valor aleatorio y lo guardamos en la variable
														// 'numero'
			} while (listaNums.contains(numero)); // Mientras el valor generado exista previamente en la lista, se
													// seguirá generando

			listaNums.add(numero); // Añadimos el número a la lista
		}
		System.out.println(listaNums); // Mostramos la lista final
	}

}
