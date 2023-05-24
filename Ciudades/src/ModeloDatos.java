import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class ModeloDatos {

	HashMap<String, ArrayList<String>>MapPais;
	
	public ModeloDatos() {
		MapPais = new HashMap<String, ArrayList<String>>();
	}
	
	public void consultarPais(String pais) {
		if (MapPais.containsKey(pais)) {
			System.out.println(MapPais.get(pais));
		}else {
			JOptionPane.showMessageDialog(null, "Pais no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
	public void consultarCiudad(String ciudad) {
		MapPais.forEach((pais,ciudades)->{
			if(!ciudades.contains(ciudad)) {
				JOptionPane.showMessageDialog(null, "ciudad no exite ","Advertencia",JOptionPane.WARNING_MESSAGE);
				return;
			}	
			JOptionPane.showMessageDialog(null, "La cuidad " + ciudad + " Pertenece al pais de " + pais);
		});
	}		
		
		
	
	public HashMap<String, ArrayList<String>> getMapCuidades(){
		return MapPais;
	}
	
	public void GuardarDatos(ArrayList<String>ListaCuidades) {
		MapPais.put(ListaCuidades.get(0),ListaCuidades);
		JOptionPane.showMessageDialog(null, "Registro Exitoso");
	}
	public int getSizeMap() {
		return MapPais.size();
	}

	public void ImprimirResultado() {
		System.out.println(MapPais);
		
		
		
		
	}
}