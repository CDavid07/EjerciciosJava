package ejercicio4_CuentaDigitos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Digitos {

	public void ocurrencias(int numeros[], int digitos[]) {

		//Convertimos el arreglo de numeros en una cadena
		String num = Arrays.toString(numeros).replaceAll(",","").replaceAll(" ", "");
		
		//Creamos un mapeo de las ocurrencias de ciertos dígitos
		Map<Integer, Integer> conteo = new HashMap<>();

		for (int i : digitos) {
			//Inicializamos digitos
			conteo.put(i, 0);

			for (int j = 0; j < num.length(); j++) {
				
				char charAt = num.charAt(j);
				
				if (charAt == Integer.toString(i).charAt(0) ) {
					conteo.put(i, conteo.get(i) + 1);
				}
			}
		}

		//Imprimir resultados
		for (Map.Entry<Integer, Integer> ocurrencia : conteo.entrySet()) {
			System.out.println(ocurrencia.getKey()+ " -> "+ocurrencia.getValue());
		}
	}
}
