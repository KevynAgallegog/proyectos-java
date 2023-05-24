import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Procesos {
	ModeloDatos miData;
	ArrayList<String>ListCuidades;
	
	public Procesos() {
		miData =new ModeloDatos();
		iniciar();
	}
	private void iniciar() {
		
		int res;
	
		do {
			ingresoDatos();
			 res =  JOptionPane.showConfirmDialog(
		            null,
		            "Quieres seguir ingesando?",
		            "An Inane Question",
		            JOptionPane.YES_NO_OPTION);
			

			//resp=JOptionPane.showInputDialog("Quieres seguir ingesando?");
		} while (res != 1);
		
		miData.ImprimirResultado();
		
		
		int op=0;
		 do {
			
			 op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion \n"
					 + "1. Registar Pais \n"
					 + "2. Registar Cuidad \n"
					 +"3. Consultar Pais \n"
					 +"4. Consultar Cuidad \n"
					 +"5. Salir"));
			 
			 switch (op) {
			case 1:
				ingresoDatos();
				break;
			case 2:
				
				break;
			case 3:
				String pai=JOptionPane.showInputDialog("Ingrese el pais a Buscar");
				miData.consultarPais(pai);
				break;
			case 4:
				String Ciu=JOptionPane.showInputDialog("Ingrese la ciudad a Buscar");
				miData.consultarCiudad(Ciu);
				break;
			case 5:
	
				break;

			default:
				break;
			}
			 
			 
		} while (op!=5);
			
		
			 
		 }
	private void ingresoDatos() {
		ListCuidades = new ArrayList<String>();
		String pais = JOptionPane.showInputDialog("Ingrese el pais ");
		String ciudad=JOptionPane.showInputDialog("Ingrese la cuidad");
		ListCuidades.add(pais);
		ListCuidades.add(ciudad);
		miData.GuardarDatos(ListCuidades);
		
	}
	
	public void ImprimirResultado() {
		System.out.println(" registros : "+ ListCuidades);
	}
}
		 
	
	
	