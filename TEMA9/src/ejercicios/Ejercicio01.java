package ejercicios;

import java.util.TreeSet;

public class Ejercicio01 {

	public static void main(String[] args) {
		int numero;
		
		TreeSet<Integer> listaNums = new TreeSet<>();
		for (int i = 0; i < 20; i++) {
			do {
				numero = ((int) (Math.random() * 100));
			} while (listaNums.contains(numero));
			
			listaNums.add(numero);
		}
		System.out.println(listaNums);
	}

}
