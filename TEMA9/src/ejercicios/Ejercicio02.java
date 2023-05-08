package ejercicios;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ejercicio02 {
	
	public static void main(String[] args) {
		String nombres = "";

		Scanner sc = new Scanner(System.in);

		LinkedHashSet<String> listaNombres = new LinkedHashSet<>();
		while (!nombres.equalsIgnoreCase("fin")) {
			do {
				System.out.println("Introduzca un nombre: ");
				nombres = sc.next();
			} while (listaNombres.contains(nombres));
			
			if (!nombres.equalsIgnoreCase("fin")) {
				listaNombres.add(nombres);
			}
		}

		System.out.println(listaNombres);

		sc.close();
	}
}
