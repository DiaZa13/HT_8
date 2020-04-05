import java.io.BufferedReader;
import java.io.FileReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		FileReader fr = null;
		BufferedReader br = null;
		String paciente, name = null, symptom = null, priority = null;
		String[] pacientes = null;
		String menu;
		boolean tmenu;
		
		VectorHeap<Paciente> registroAtencion = new VectorHeap<Paciente>();
		//PriorityQueue<Paciente> registroAtencion = new PriorityQueue<Paciente>();
    
//---------------------------Read the file, that contains the patients
			try {
				fr = new FileReader ("pacientes.txt");
				br = new BufferedReader(fr);

				while((paciente = br.readLine())!=null) {
					pacientes = paciente.split(",");
					for (int i = 0; i < pacientes.length; i++) {
						if (i%3 == 0)
							name = pacientes[i].toUpperCase().trim();
						else if (i%3 == 1) 
							symptom = pacientes[i].toUpperCase().trim();
						else if(i%3 == 2)
							priority = pacientes[i].toUpperCase().trim(); 
					}
					registroAtencion.add(new Paciente(name,symptom,priority));
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if( null != fr ){
						fr.close();
					}
				}catch (Exception e){
					e.printStackTrace();
				}

			}

			
//---------------------------Menu
			do{
				System.out.println("------- HOSPITAL DE EMERGENCIAS ---------");
				System.out.println("MENU");
				System.out.println("1. Muestra el siguiente paciente en la lista");
				System.out.println("2. Muestra todos los pacientes en la lista ordenados por prioridad");
				System.out.println("3. Salir");
				System.out.print("Ingrese la opcion que desee: ");	
				menu = read.nextLine();
				System.out.println();
				tmenu = MenuInvalido(menu);
				while (tmenu != false) {
					System.out.print("Ingrese nuevamente el numero de la opcion que desee: ");	
					menu = read.nextLine();
					System.out.println();
					tmenu = MenuInvalido(menu);
				}
			
				switch (menu) {
				case "1":
					if(!registroAtencion.isEmpty()) {						
						System.out.println("-"+ registroAtencion.remove().toString());
					}else
						System.out.println("*Ya no hay pacientes restantes en la lista de espera :)");
					System.out.println();
						
					break;
				case "2":
					if(!registroAtencion.isEmpty()) {
						while(!registroAtencion.isEmpty()) {
							System.out.println("-"+ registroAtencion.remove().toString());
						}
					}else
						System.out.println("*Ya no hay pacientes restantes en la lista de espera :)");
					System.out.println();
					break;
				}
			}while(!menu.contentEquals("3"));
	}	
//---------------------------Defensive programming
	public static boolean MenuInvalido(String me) {
		 boolean incorrecto = false;
		 if (!me.equals("1") && !me.equals("2") && !me.contentEquals("3"))
			 incorrecto = true;
		else 
			incorrecto = false;
		 
		 return incorrecto;
	 }
}
