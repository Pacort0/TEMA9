package ejercicios;

import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio04 {

	public static void main(String[] args) {
		char opcion;
		int numero;
		int numeros = 5;
		int estrellas = 2;

		TreeMap<Integer, Integer> boleto = new TreeMap<>();
		TreeMap<Integer, Integer> estrelas = new TreeMap<>();

		Scanner sc = new Scanner(System.in);

		do {
			for (int i = 0; i < numeros; i++) {
				do {
					System.out.println("Introduzca el " + (i + 1) + "º número premiado: ");
					numero = sc.nextInt();
				} while (numero < 0 || numero > 50);
				
				if(!boleto.containsKey(numero)) {
					boleto.put(numero, 1);
				} else {
					boleto.replace(numero, boleto.get(numero)+1);
				}
				
				if(estrelas.containsKey(numero) && boleto.containsKey(numero)) {
					estrelas.replace(numero, estrelas.get(numero)+1);
					boleto.replace(numero, boleto.get(numero)+1);
				} else if (estrelas.containsKey(numero) && !boleto.containsKey(numero)){
					estrelas.replace(numero, estrelas.get(numero)+1);
					boleto.put(numero, 1);
				} 
			}

			for (int i = 0; i < estrellas; i++) {
				do {
					System.out.println("Introduzca el valor de la " + (i + 1) + "ª estrella: ");
					numero = sc.nextInt();
				} while (numero <= 0 || numero > 12);
			}

			System.out.println("Boleto: " + boleto);
			System.out.println("Estrellas: " + estrelas);

			System.out.println("¿Desea introducir otro boleto? (s/n)");
			opcion = sc.next().charAt(0);
		} while (opcion != 'n');
		sc.close();
	}

	public static void compruebaRepetido(TreeMap<Integer, Integer> boleto1, TreeMap<Integer, Integer> boleto2,
			int numero) {

		if (!boleto1.containsKey(numero)) { // Si la llave no se encuentra en la primera colección
			if (boleto2.containsKey(numero)) { // Pero sí se halla en la segunda colección
				boleto1.put(numero, boleto2.get(numero) + 1); // Aumentamos en ambas colecciones el valor en 1
				boleto2.replace(numero, boleto2.get(numero) + 1);
			} else { // Si no está en ninguna colección, iniciamos su valor a 1
				boleto1.put(numero, 1);
			}
		} else { // Si se encuentra en la primera coleccion, se aumenta en 1 su valor
			boleto1.replace(numero, boleto1.get(numero) + 1);
		}
	}

}
