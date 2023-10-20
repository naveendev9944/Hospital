import java.util.*;
import java.io.*;


class IllnessFactory{
	static List<Illness> illobj=new ArrayList<>();
        public static Illness getIllness(byte illness) throws UnknownIllnessException{
        	if(illness <4)
			return illobj.get(illness-1);
		throw new UnknownIllnessException();
		
        }
	void printIllness(){
		int i=1;
		for(Illness ill : illobj){
			System.out.println(i+"."+ill.name);
			i++;
		}
	}
	public  void loadIllnessesFromFile() throws IOException {
        	BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
        	String line;
        	while ((line = reader.readLine()) != null) {
            	String[] parts = line.split(":");
            		if (parts.length == 2) {
                		String name = parts[0];
               			boolean isFatal = Boolean.parseBoolean(parts[1]);
                		Illness illness = new Illness(name, isFatal);
				illobj.add(illness);
           		}
        	}
        	reader.close();
    	}
    	class Illness{
		String name;
		boolean fatal;
		private Illness(String name,boolean fatal){
			this.name=name;
			this.fatal=fatal;
		}
		boolean isFatal(){
			return this.fatal;
		}	

		String getName(){
			return this.name;
		}
	}
	
}
class UnknownIllnessException extends Exception {
    	 UnknownIllnessException( ) {
        	System.out.println("Unknown illness: ");
    }
}
enum Gender{
	Male,
	Female
}	
class Patient{
	private String name;
	private Gender gender;
	private Set<IllnessFactory.Illness> illness;
	boolean survived;
	Patient(String name,byte g,boolean survived){
		this.name=name;
		this.gender=Gender.values()[g-1];
		this.illness=new HashSet<>();
		this.survived=survived;
	}
	Set<IllnessFactory.Illness> getSet(){
		return this.illness;
	}
	String getName(){
                return this.name;
        }
        Gender getGender(){
                return this.gender;
        }

	void addIllness(IllnessFactory.Illness ill){
		illness.add(ill);
	}

	void removeIllness(IllnessFactory.Illness ill){
                illness.remove(ill);
        }

/*	Illness hasIllness(String illness){
		return illness.getName().equals(illness);
	}*/

	boolean hasSurvived(){
                        return this.survived;
        }
	void printp(List<Patient> p1){
		for(Patient p:p1){
			System.out.println(p.name);
		}
	}

	boolean hasFatalIllness(){
                for (IllnessFactory.Illness ill : illness)
			if(ill.isFatal())
                        	return true;
        	return false;
	}
	public boolean equals(Object o) {
      		if (o==this) {	
        		return true;  
       		 }  

		if (o==null||this.getClass()== o.getClass()){ 
			return false;
		}
        	return this.name.equals(o);
  	 }  
	@Override
	public int hashCode() {
        	 return Objects.hash(name);
    }

}
public class Hospital{
	private List<Patient> patients=new ArrayList<>();
	Patient getPatient(String name){
		for(Patient p:patients){
			if(p.getName().equals(name))
				return p;
		}
	return null;
	}

	public void addPatient(Patient object){
		for(Patient p:patients)
			if(p.getName().equals(object.getName()))
				return ;
		patients.add(object);
	}

	public List<Patient> getPatientsBy(IllnessFactory.Illness illness){
	       	List<Patient> patientswithillness = new ArrayList<>();
        	for (Patient patient : patients) {
            		if (patient.getSet().contains(illness)){
                		patientswithillness.add(patient);
            		}
        	}
        	return patientswithillness;
	}
       
	public List<Patient> getAllFatalIllnessSurvivors(){
        	List<Patient> survivors = new ArrayList<>();
        	for (Patient patient : patients){
            		if(patient.hasSurvived() && patient.hasFatalIllness()){
                		survivors.add(patient);
            		}
        	}
        	return survivors;
    	}

    	public List<Patient> getAllFatalIllnessSurvivorsByGender(Gender gender){
        	List<Patient> survivorsbygender = new ArrayList<>();
        	for (Patient patient : patients){
            		if(patient.getGender()==gender && patient.hasSurvived() && patient.hasFatalIllness()){
                		survivorsbygender.add(patient);
            		}
        	}
        	return survivorsbygender;
    	}	
    	void showp(List<Patient> p){
    		patients.get(0).printp( p);
    	}
   
}

