package ejercicio2_EnunciadoEspejo;

import java.util.ArrayList;
import java.util.List;

public class Espejo {

	public void byteArray(String s) {
		
		String[] abc = "abcdefghijklmnopqrstuvwxyz".split("");

		String[] str = s.split("");
 
		/*Existen mas maneras de inicializar la lista
		 * igual podria usarse la librería de arrays o usar un 
		 * un iterador para agregar los valores */
		List<String> aabc = new ArrayList<String>(List.of(abc));

		String nstr = "";

		for (String ss: str) {
			int idx = aabc.indexOf(ss);
			if(idx >= 0)
				nstr += abc[(abc.length - idx)-1];
		}

		System.out.println("Palabra espejo: "+nstr);
	}

}
