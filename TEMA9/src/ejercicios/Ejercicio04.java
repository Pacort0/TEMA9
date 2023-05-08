package ejercicios;

import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio04 {

	public static void main(String[] args) {
		int numero;
		int numeros = 5;
		int estrellas = 2;

		TreeMap<Integer, Integer> arbolDinero = new TreeMap<>();

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < numeros; i++) {
			do {
				System.out.println("Introduzca el " + (i + 1) + " número premiado: ");
				numero = sc.nextInt();
			} while (numero < 0 || numero > 50);
			
			compruebaRepetido(arbolDinero, numero);
		}
		
		for(int i = 0; i < estrellas; i++) {
			do {
				System.out.println("Introduzca el valor de la " + (i+1) + " estrella: ");
				numero = sc.nextInt();
			}while(numero<=0 || numero>12);
			
			compruebaRepetido(arbolDinero, numero);
		}
		
		System.out.println(arbolDinero);
		
		sc.close();
	}
	
	public static void compruebaRepetido(TreeMap<Integer, Integer> boleto, int numero) {
		if(!boleto.containsKey(numero)) {
			boleto.put(numero, 1);
		}
		else {
			boleto.replace(numero, boleto.get(numero), boleto.get(numero) + 1);
		}
	}

}
