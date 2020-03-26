/**
 * 
 * @author Diana Zaray Corado Loopez #191025
 * @version 26/03/2020
 *
 */
public class Paciente implements Comparable<Paciente>{

	String name;
	String symptom;
	String priority;
	
	public Paciente() {
		this.name = "";
		this.symptom = "";
		this.priority = "";		
	}
	
	public Paciente(String name, String symptom, String priority) {
		this.name = name;
		this.symptom = symptom;
		this.priority = priority;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the symptom
	 */
	public String getSymptom() {
		return symptom;
	}

	/**
	 * @param symptom the symptom to set
	 */
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	
	@Override
	public String toString() {
		return "Paciente [Nombre =" + name + ", Sintoma=" + symptom + ", Prioridad=" + priority + "]";
	}

	@Override
	public int compareTo(Paciente other) {
		// TODO Auto-generated method stub
		return this.getPriority().compareTo(other.getPriority());
	}

	
	


}
