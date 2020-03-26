import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

	File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    String paciente, nombre, sintoma, prioridad;
    String[] pacientes;
    
	//---------------------------Read the file, that contains the dictionary
	try {
	fr = new FileReader ("pacientes.txt");
    br = new BufferedReader(fr);

    while((paciente = br.readLine())!=null) {
    	pacientes = paciente.split(",");
        for (int i = 0; i < pacientes.length; i++) {
        	if (i%2 == 0) {
        		nombre = pacientes[i].toLowerCase();
        	}else if (i%2 == 1) {
        		sintoma = pacientes[i].toLowerCase();
        	}
        }
        dictionary.add(key, value);
    }
}
	catch(Exception e){
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
