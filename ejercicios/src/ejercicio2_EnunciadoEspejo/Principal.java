package ejercicio2_EnunciadoEspejo;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Espejo espejo = new Espejo();
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce palabra:\n");
		String palabra = sc.nextLine();
		sc.close();
		
		espejo.byteArray(palabra);
	}

}
