package ejercicios;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {
		int opcion;
		String nombreProd;
		double precioProd;

		Scanner sc = new Scanner(System.in);

		HashMap<String, Double> productos = new HashMap<>();

		do {
			menu();
			opcion = sc.nextInt();
			
			sc.nextLine();

			switch (opcion) {
			case 1:
				System.out.println("Introduzca el nombre del producto que desea añadir: ");
				nombreProd = sc.nextLine();
				System.out.println("Introduzca el precio del producto que desea añadir");
				precioProd = sc.nextDouble();
				
				sc.nextLine();
				
				agregarProd(nombreProd, precioProd, productos);
				break;
			case 2:
				System.out.println("Introduzca el nombre del producto que desea eliminar: ");
				nombreProd = sc.nextLine();
				if (eliminarProd(nombreProd, productos) == 0) {
					System.err.println("Ese producto no existe");
				}
				break;
			case 3:
					System.out.println(productos);
				break;
			case 4:
				System.out.println("Hasta luego.");
				break;
			default:
				System.err.println("Esa opción no está contemplada");
			}
		} while (opcion != 4);
		
		sc.close();

	}

	public static void menu() {
		System.out.println("Introduzca una opción: " + "\n1. Añadir producto." + "\n2. Eliminar producto."
				+ "\n3. Listar existencias." + "\n4. Salir");
	}

	public static int agregarProd(String nombre, double precio, HashMap<String, Double> productos) {
		int existe = 0;

		if (productos.containsKey(nombre)) {
			existe = 1;
		} else {
			productos.put(nombre, precio);
		}

		return existe;
	}

	public static int eliminarProd(String nombre, HashMap<String, Double> productos) {
		int existe = 1;

		if (productos.containsKey(nombre)) {
			productos.remove(nombre);
		} else {
			existe = 0;
		}

		return existe;
	}

}
