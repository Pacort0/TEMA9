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

				if(!boleto.containsKey(numero) && !estrelas.containsKey(numero)) {
					boleto.put(numero, 1);
				} else if (!boleto.containsKey(numero) && estrelas.containsKey(numero)){
					boleto.put(numero, estrelas.get(numero)+1);
					estrelas.replace(numero, estrelas.get(numero) + 1);
				}
				else {
					boleto.replace(numero, boleto.get(numero) + 1);
				}
			}

			for (int i = 0; i < estrellas; i++) {
				do {
					System.out.println("Introduzca el valor de la " + (i + 1) + "ª estrella: ");
					numero = sc.nextInt();
				} while (numero <= 0 || numero > 12);

				if(!estrelas.containsKey(numero) && !boleto.containsKey(numero)) {
					estrelas.put(numero, 1);
				} else if (!estrelas.containsKey(numero) && boleto.containsKey(numero)){
					estrelas.put(numero, boleto.get(numero)+1);
					boleto.replace(numero, boleto.get(numero) + 1);
				}
				else {
					estrelas.replace(numero, estrelas.get(numero) + 1);
				}
			}

			System.out.println("Boleto: " + boleto);
			System.out.println("Estrellas: " + estrelas);

			System.out.println("¿Desea introducir otro boleto? (s/n)");
			opcion = sc.next().charAt(0);
		} while (opcion != 'n');
		sc.close();
	}

}
