

import javax.swing.JOptionPane;

	public class Mascota {

		

		modeloDatos midta;

		String identidad;
		String nombre;
		int edad;
		String especie;
		
		
		
		public Mascota() {
		
			midta=new modeloDatos();
			
		}
		
		public void iniciar() {
			
			String resp="";
			
			
			do {
				midta.ingresoDatos();
				
				//System.out.println("repet");
				resp = JOptionPane.showInputDialog("Desea seguir ingresando Ingrese si o no");
				
			} while (resp.equalsIgnoreCase("si"));
			
			midta.MostrarDatos();
			
		
			int opc;
				do {
					opc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion  \n"
							+"1. Registrar Mascota \n"
							+"2. Mostrar Sonido \n"
							+"3. Consultar mascotas \n "
							+"4. Movimientos \n"
							+"5 Comida que consume\n "
							+"6 Modificar Mascota \n"
							+ "7. Salir"));
					
					switch (opc) {
					case 1:
						midta.ingresoDatos();
						midta.MostrarDatos();
						break;	
					case 2:
						mostrarSonidos();
						break;	
					case 3:
						String con=JOptionPane.showInputDialog("ingrerse la identidad para consultar");
						midta.consulta(con);
						break;	
					case 4:
						movimientos();
						break;	
					case 5:
						comida();
						break;
					case 6:
						String idIdentidad=JOptionPane.showInputDialog("ingrerse la identidad para consultar");
						midta.modificar(idIdentidad);
						
						break;

					default: 
						break;
					}
				} while (opc!=7);
				
			
		}
		
		
		
		private void comida() {
			especie=JOptionPane.showInputDialog("Ingrese la especie de la mascota");
			if (especie.equalsIgnoreCase("Perro")) {
				JOptionPane.showMessageDialog(null, "1. Dog chow  \n"
						+"2. Pedigree \n"
						+"3. Master Dog \n"
						+"4. Petizoo \n");
			}else if(especie.equalsIgnoreCase("Gato")) {
				JOptionPane.showMessageDialog(null, "1. Whiskas \n"
						+"2. NutreCan \n"
						+"3. Royal Canin \n"
						+"4. VitalCan");
			}else if(especie.equalsIgnoreCase("Gallo")) {
				JOptionPane.showMessageDialog(null, "1. Purina \n"
						+"2. Red Force \n"
						+"3. Tornel \n"
						+"4. Bimap");
			}else {
				System.out.println("Pregunte a su Vetereniario mas cercano!");
			}
		}
			
		

		private void movimientos() {
			 especie=JOptionPane.showInputDialog("Ingrese la especie de la mascota");
				if (especie.equalsIgnoreCase("Perro")) {
					JOptionPane.showMessageDialog(null, " flexión, extensión, abducción, aducción, rotación interna, rotación externa y circunducción.");
				}else if(especie.equalsIgnoreCase("Gato")) {
					JOptionPane.showMessageDialog(null, "mueve la cola rápidamente es un signo de agresividad, se está preparando para un salto o un ataque.\n Movimientos lentos y suaves: \n cuando tu gato realiza estos movimientos es porque se encuentra tranquilo \n o puede estar concentrado en algo que está llamando su atención");
				}else if(especie.equalsIgnoreCase("Gallo")) {
					JOptionPane.showMessageDialog(null, "El aleteo rápido de las alas con la cabeza erguida, el pecho abombado hacia afuera y las plumas erizadas");
				}else {
					System.out.println("No tiene movimientos conocidos");
				}
			}
			
			
		private void mostrarSonidos() {
			 especie=JOptionPane.showInputDialog("Ingrese la especie de la mascota");
			if (especie.equalsIgnoreCase("Perro")) {
				JOptionPane.showMessageDialog(null, "¡Guau guau!");
			}else if(especie.equalsIgnoreCase("Gato")) {
				JOptionPane.showMessageDialog(null, "¡Miau miau!");
			}else if(especie.equalsIgnoreCase("Gallo")) {
				JOptionPane.showMessageDialog(null, "¡Kikiriki!!");
			}else {
				System.out.println("No tiene sonidos conocidos");
			}
		}
		
		
	
		}
				
			
		
			
			 
		
		
	


