//esto solo modifica el hashmap



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class ModeloDatos {
	// La clase modeloDatos crea un hashmap
	HashMap<String, ArrayList<String>> mapEstudiantes;

	// este metodo inicializa el hashmap
	public ModeloDatos() {
		mapEstudiantes = new HashMap<String, ArrayList<String>>();
	}

//este metodo recibe un parametro llamado documento y trae la informacion la informacion de los arraylist que hay en el hashmap
	public void consultarEstudiante(String documento) {
		// este if valida que el hashmap contenga el parametro documento
		if (mapEstudiantes.containsKey(documento)) {
			System.out.println(mapEstudiantes.get(documento));
			// y si no existe el documento mostrara una ventana emergente dando un msj de
			// advertencia
		} else {
			JOptionPane.showMessageDialog(null, "Documento no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}

	// esto retorna el hashmap mapEstudiantes que fue creado previamente
	public HashMap<String, ArrayList<String>> getMapEstudiantes() {
		return mapEstudiantes;
	}

	// este metodo guarda los datos, el metodo es vacio por ende no retorna nada y
	// tiene un parametro que es un arraylist llamado listaestudiantes0
	public void guardarDatos(ArrayList<String> listaEstudiantes) {
		// aqui el hashmap mapestudiantes va a agregar el index 0 de lista estudiantes
		// como clave y tambien la lista entera listaestudiantes como valor
		mapEstudiantes.put(listaEstudiantes.get(0), listaEstudiantes);
		JOptionPane.showMessageDialog(null, "Registro existoso!");
	}

//el metodo es entero y retorna el tamaño del hashmap mapestudiantes
	public int getSizeMap() {
		return mapEstudiantes.size();
	}

	//este metodo imprime un mapa
	//el metodo es vacio por ende no retorna
	public void imprimirMapa() {
		//iterator es un elemento tipo string que recorre las keys del hashmap (documentos)
		Iterator<String> itera = mapEstudiantes.keySet().iterator();
		//llave es lo que tendra el valor del iterador
		String llave;
		while (itera.hasNext()) {
			//ejemplo: si el documento es 2 llave sera 2
			llave = itera.next();
			//imprime la informacion de llave
			System.out.println(llave + " - " + mapEstudiantes.get(llave));
		}
	}
	
	//este metodo imprime el hasmap mapestudiantes usando el ciclo for each
	public void imprimirMapaForma2() {
		//el ciclo for each recorre las llaves del hashmap por el keyset
		for (String documento : mapEstudiantes.keySet()) {
			// imprime el documento - y la informacion que tenga el documento
			System.out.println(documento + " - " + mapEstudiantes.get(documento));
		}
	}

}