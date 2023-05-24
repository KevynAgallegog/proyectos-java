//la clase procesos hace toda la parte logica de los metodos.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Procesos {
	//modelo de datos es un tipo de dato que se le asigna a la variable miData
	ModeloDatos miData;
	ArrayList<String> listEstudiantes;
	int cantGanan = 0, cantRecuperan = 0, cantPierden = 0;
	//procesos es el constructor
	public Procesos() {
		//aqui se inicializa la variable miData
		miData = new ModeloDatos();
		//ejecutamos el metodo iniciar()
		iniciar();
	}
	
	//el metodo iniciar es el que va a contener toda la logica
	private void iniciar() {
		
		String resp = "";
		do {
			ingresarDatos();
			resp = JOptionPane.showInputDialog("Ingrese si, para continuar registrando estudiantes");
		} while (resp.equalsIgnoreCase("si"));
		int opc;
	do {
		opc=Integer.parseInt(JOptionPane.showInputDialog("MENU","Elija una opcion \n"
				+"1. Registrar otro estudiante \n"
				+"2. Consultar Estudiante \n"
				+"3. Consultar lista \n "
				+"4. Cantidad de estudiantes validados \n"
				+"5. Cantidad de notas ingresadas \n"
				+"6. Sumatoria de notas ingresadas  \n"
				+"7. Promedio de notas finales obtenidas \n"
				+"8. Cantidad de estudiantes que ganan \n"
				+"9. Cantidad de estiandtes que pierden \n "
				+"10. cantidad de estudiantes que pueden recuperar \n"
				+"11. cantidad de estudiantes que pierden sin recuperacion \n"
				+"12. Salir"));
		
		switch (opc) {
		case 1:
			ingresarDatos();
			break;
		case 2:
			String consul=JOptionPane.showInputDialog("Ingrese el documento para consultar");
			miData.consultarEstudiante(consul);
			break;
		case 3:
			miData.imprimirMapaForma2();
			break;
		case 4:
			miData.getSizeMap();
			break;
		case 5:
			listEstudiantes.size();
			break;
		case 6:
			sumaTotalNotas();
			break;
		case 7:
			calcularPromedioFinal();
			break;
		case 8:
			calcularEstados(opc);
			break;	
		case 9:
			calcularEstados(opc);
			break;
		case 10:
			calcularEstados(opc);
			break;
		case 11:
			calcularEstados(opc);
			break;

		default:
			break;
		}
		
	} while (opc!=12);
	}

	private void ingresarDatos() {
		listEstudiantes = new ArrayList<String>();
		String documento = JOptionPane.showInputDialog("Ingrese el documento");
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
		String materia = JOptionPane.showInputDialog("Ingrese la materia del estudiante");
		double nota1 = validarNotas("Ingrese la nota 1");
		double nota2 = validarNotas("Ingrese la nota 2");
		double nota3 = validarNotas("Ingrese la nota 3");
		listEstudiantes.add(documento);
		listEstudiantes.add(nombre);
		listEstudiantes.add(materia);
		listEstudiantes.add(nota1 + "");
		listEstudiantes.add(nota2 + "");
		listEstudiantes.add(nota3 + "");
		miData.guardarDatos(listEstudiantes);
		System.out.println("Nombre: " + nombre + ", Documento: " + documento + ", Materia: " + materia);
		calcularPromedio(nota1, nota2, nota3);
	}

	public double validarNotas(String msj) {
		double nota = 0;
		do {
			nota = Double.parseDouble(JOptionPane.showInputDialog(msj));
			if (nota < 0 || nota > 5) {
				JOptionPane.showMessageDialog(null, "Nota incorrecta, " + "no esta en el rango, repitala", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		} while (nota < 0 || nota > 5);
		return nota;
	}

	public void imprimirResultados() {
		double sumaTotal = sumaTotalNotas();
		int cantNotas = miData.getSizeMap() * 3;
		System.out.println("Cantidad total estudiantes: " + miData.getSizeMap());
		System.out.println("Cantidad total notas ingresadas: " + cantNotas);
		System.out.println("Suma total de notas: " + sumaTotal);
		System.out.println("promedio total de notas: " + (sumaTotal / cantNotas));
		System.out.println("Promedio total de notas finales: " + calcularPromedioFinal());
		System.out.println("Cantidad que ganan: " + cantGanan);
		System.out.println("Cantidad que recuperan: " + cantRecuperan);
		System.out.println("Cantidad que pierden: " + cantPierden);
		System.out.println();
	}

	private double sumaTotalNotas() {
		Iterator<String> itera = miData.getMapEstudiantes().keySet().iterator();
		double suma = 0;
		while (itera.hasNext()) {
			String doc = itera.next();
			ArrayList<String> listTemp = miData.getMapEstudiantes().get(doc);
			for (int i = 3; i < listTemp.size(); i++) {
				suma += Double.parseDouble(listTemp.get(i));
			}
		}
		return suma;
	}

	private double calcularPromedioFinal() {
		Iterator<String> itera = miData.getMapEstudiantes().keySet().iterator();
		double n1, n2, n3;
		double suma = 0, prom;
		while (itera.hasNext()) {
			String doc = itera.next();
			ArrayList<String> listTemp = miData.getMapEstudiantes().get(doc);
			n1 = Double.parseDouble(listTemp.get(3));
			n2 = Double.parseDouble(listTemp.get(4));
			n3 = Double.parseDouble(listTemp.get(5));
			prom = (n1 + n2 + n3) / 3;
			calcularEstados(prom);
			suma += prom;
		}
		return suma / miData.getSizeMap();
	}

	public void calcularEstados(double promedio) {
		if (promedio >= 3.5) {
			cantGanan++;
		} else {
			if (promedio >= 2) {
				cantRecuperan++;
			} else {
				cantPierden++;

			}
		}
	}

	private void calcularPromedio(double nota1, double nota2, double nota3) {
		double promedio = (nota1 + nota2 + nota3) / 3;
		System.out.println("(" + nota1 + "+" + nota2 + "+" + nota3 + ")/3=" + promedio);
		if (promedio >= 3.5) {
			System.out.println("Gana la materia");
		} else {
			if (promedio >= 2) {
				System.out.println("Pierde, pero puede recuperar");
			} else {
				System.out.println("Pierde la materia");
			}
		}
		System.out.println();
	}
}