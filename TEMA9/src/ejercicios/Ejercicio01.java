package ejercicios;

import java.util.ArrayList;
import java.util.Comparator;

public class Ejercicio01 {

	public static void main(String[] args) {
		int numero;
		
		ArrayList<Integer> listaNums = new ArrayList<>(20);
		for (int i = 0; i < 20; i++) {
			do {
				numero = ((int) (Math.random() * 100));
			} while (listaNums.contains(numero));
			
			listaNums.add(numero);
			listaNums.sort(Comparator.naturalOrder());
			;
		}
		System.out.println(listaNums);
	}

}
