import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String paciente, name = null, symptom = null, priority = null;
		String[] pacientes;
		VectorHeap<Paciente> registroAtencion = new VectorHeap<Paciente>();
    
//---------------------------Read the file, that contains the dictionary
			try {
				fr = new FileReader ("pacientes.txt");
				br = new BufferedReader(fr);

				while((paciente = br.readLine())!=null) {
					pacientes = paciente.split(",");
					for (int i = 0; i < pacientes.length; i++) {
						if (i%3 == 0)
							name = pacientes[i];
						else if (i%3 == 1) 
							symptom = pacientes[i];
						else if(i%3 == 2)
							priority = pacientes[i].toUpperCase(); 
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
	
	
	
	
	
	
}	
}
