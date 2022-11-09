package ejercicio4_CuentaDigitos;

public class Principal {

	public static void main(String[] args) {

		int numeros[] = {-18, -31, 81, -19, 111, -888};
		int digitos[] = {1, 8, 4};

		Digitos dig = new Digitos();
		dig.ocurrencias(numeros, digitos);
		
	}

}
