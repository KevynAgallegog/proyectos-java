
import java.util.HashMap;

import javax.swing.JOptionPane;

public class modeloDatos {
	
	HashMap<String,Mascota>  listMascotas = new HashMap<String,Mascota>();
		
	public modeloDatos() {
		
		listMascotas = new HashMap<String,Mascota>();
		
		
	}
	
	public  void ingresoDatos() {
		
		Mascota mascota1=new Mascota();
		mascota1.identidad=JOptionPane.showInputDialog("Ingrese una identidad para su mascota");
		mascota1.nombre=JOptionPane.showInputDialog("Ingrese el nombre de la Mascota");
		mascota1.edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota"));
		mascota1.especie=JOptionPane.showInputDialog("Ingrese la especie de mascota");
		listMascotas.put(mascota1.identidad, mascota1);
	}
	
	public void MostrarDatos() {
		listMascotas.forEach((identidad,mascota)->{
			System.out.println("nombre: "+mascota.nombre+ "\n" + "Edad: "+mascota.edad +"\n"
					+ "Especie: "+ mascota.especie);
		});
	}


	public void consulta(String identidad) {
		if (listMascotas.containsKey(identidad)) {
			Mascota tempMascota = listMascotas.get(identidad);
			
			System.out.println("Nombre: "+tempMascota.nombre 
					+"Edad: "+tempMascota.edad +  
					"Especie: "+tempMascota.especie);
			
			
		}else {
			JOptionPane.showMessageDialog(null, "No existe","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
		}
	}
	public void modificar(String identidad) {
		if (listMascotas.containsKey(identidad)) {
			Mascota tempMascota=listMascotas.get(identidad);
			String temName = JOptionPane.showInputDialog("Desea Modificar el nombre ?", tempMascota.nombre);
			int temEdad = Integer.parseInt(JOptionPane.showInputDialog("Desea Modificar el edad ?", tempMascota.edad));
			String tempEspecie=JOptionPane.showInputDialog("Desea modificar la especie?",tempMascota.especie);
			
			tempMascota.nombre = temName;
			tempMascota.edad = temEdad;
			tempMascota.especie= tempEspecie;
			
			listMascotas.replace(identidad, tempMascota);
			
			Mascota finalMascota = listMascotas.get(identidad);
			
			System.out.println("Nombre nueva: "+finalMascota.nombre+ "\n" +
			"Edad nueva: "+ finalMascota.edad + "\n"
			+"Especie nueva: "+ finalMascota.especie);
		}
		
		


	}
		
	}
	


