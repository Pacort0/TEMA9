package ejercicios;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {
		int opcion; // Variable para guardar la opción que el usuario escoja
		String nombreProd; // Variable para guardar el nombre del producto
		double precioProd; // Variable para guardar el precio del producto
		String cadena;

		Scanner sc = new Scanner(System.in); // Creamos un escáner para leer de consola

		HashMap<String, Double> productos = new HashMap<>(); // Creamos una colección HashMap, ya que da igual el orden
																// en el que se introduzcan y muestren los datos, todo
																// lo que importa es que sea un 'mapa'

		do {
			menu(); // Mostramos el menu de opciones
			opcion = sc.nextInt(); // Guardamos la elección del usuario

			sc.nextLine();

			switch (opcion) {
			case 1: // Si la elección es 1
				System.out.println("Introduzca el nombre del producto que desea añadir: ");
				nombreProd = sc.nextLine(); // Pedimos el nombre del producto y lo guardamos en nombreProd
				System.out.println("Introduzca el precio del producto que desea añadir");
				precioProd = sc.nextDouble(); // Pedimos el precio del producto y lo guardamos en precioProd

				sc.nextLine();

				if (!agregarProd(nombreProd, precioProd, productos)) { // Si el producto no existe, se añade a la lista,
																		// si no, se muestra un mensaje de error
					System.out.println("Producto añadido con éxito");
				} else {
					System.err.println("El producto ya existe");
				}
				break;
			case 2: // Si la opción elegida es la 2
				System.out.println("Introduzca el nombre del producto que desea eliminar: ");
				nombreProd = sc.nextLine(); // Pedimos el nomnre del producto y lo guardamos en 'nombreProd'
				if (!eliminarProd(nombreProd, productos)) { // Si el producto no existe, se muestra un mensaje de error,
															// si no, se elimina
					System.err.println("Ese producto no existe");
				} else {
					System.out.println("Producto eliminado con éxito");
				}
				break;
			case 3: // Si se elije la opción 3
				for(String prod : productos.keySet()) { //Hacemos un bucle for each recorriendo la lista de productos
					cadena = prod + ": " + productos.get(prod); //Guardamos en una cadena los valores de clave-valor
					System.out.println(cadena); //Mostramos la cadena
					System.out.println(); //Espacio vacío
				}
				break;
			case 4: // Si se elije la opción 4
				System.out.println("Hasta luego."); // Nos despedimos del usuario
				break;
			default: // Si la opción no equivale a ninguna de las anteriores, se muestra un mensaje
						// de error
				System.err.println("Esa opción no está contemplada");
			}
		} while (opcion != 4); // Este bucle se repetirá mientras la opción elegida no sea 4

		sc.close(); // Cerramos el escáner del programa

	}

	/**
	 * Función para mostrar el menú de opciones
	 */
	public static void menu() {
		System.out.println("Introduzca una opción: " + "\n1. Añadir producto." + "\n2. Eliminar producto."
				+ "\n3. Listar existencias." + "\n4. Salir");
	}

	/**
	 * Función que agrega productos a la lista, comprobando previamente que no estén
	 * repetidos
	 * 
	 * @param nombre    Nombre del producto
	 * @param precio    Precio del producto
	 * @param productos Lista de productos
	 * @return Devuelve un booleano en función de si el producto ya existe o no
	 */
	public static boolean agregarProd(String nombre, double precio, HashMap<String, Double> productos) {
		boolean existe = false;

		if (productos.containsKey(nombre)) {
			existe = true;
		} else {
			productos.put(nombre, precio);
		}

		return existe;
	}

	/**
	 * Función que elimina un producto de la lista, comprobando previamente si el
	 * producto ya existe o no
	 * 
	 * @param nombre    Nombre (clave) del producto
	 * @param productos Lista de productos
	 * @return Devuelve un booleano en función de si el producto ya existe o no
	 */
	public static boolean eliminarProd(String nombre, HashMap<String, Double> productos) {
		boolean existe = true;

		if (productos.containsKey(nombre)) {
			productos.remove(nombre);
		} else {
			existe = false;
		}

		return existe;
	}

}
