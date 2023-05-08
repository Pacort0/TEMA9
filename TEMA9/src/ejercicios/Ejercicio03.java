package ejercicios;

import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio03 {

	public static void main(String[] args) {
		String nombres = "";

		Scanner sc = new Scanner(System.in);
		TreeSet<String> listaNombres = new TreeSet<>();
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
