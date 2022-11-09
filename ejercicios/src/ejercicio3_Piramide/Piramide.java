package ejercicio3_Piramide;

public class Piramide {

	public int pisosPiramide(Double colecta, Double precio) {

		// Revisamos primero para cuantas latas le alcanzan
		double nLatas = Math.floor(colecta / precio);
		//Inicializamos variables
		int nPisos = 0;
		double fila = 0;
		double latasUsadas = 0;

		//Verificamos que tenga al menos una
		if (nLatas >= 1) {
			//Ciclo para verificar cuando se llega al limite de las latas que se tienen
			while (latasUsadas <= nLatas) {
				nPisos += 1;
				fila = Math.pow(nPisos, 2);
				latasUsadas = (latasUsadas + fila);
			}
			//Cuando la ciclo ya no se cumple es porque ya no hay latas o no fueron suficientes asi que se quita una fila que no se cumple la condición
			return nPisos-1;
		}

		return nPisos;
	}
}
