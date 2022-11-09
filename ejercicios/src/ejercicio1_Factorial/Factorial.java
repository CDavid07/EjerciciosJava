package ejercicio1_Factorial;
import java.util.Scanner;

public class Factorial {

	private static Integer factorial(Integer i) {
		if (i == 0)
			return 1;
		else
			return i * factorial(i-1);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un número:\n");
		int num = sc.nextInt();
		sc.close();

		System.out.println("El factorial de " + num + " es: " + factorial(num));

	}

}
