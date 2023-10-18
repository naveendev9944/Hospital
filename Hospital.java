import java.util.*;

class Illness{
	private String name;
	private boolean fatal;
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
class IllnessFactory{
        public static Illness getIllness(String illnessName) throws UnknownIllnessException {

        }
}

enum Gender{
	Male,
	Female
}	
class Patient{
	String name;
	Gender genter;
	Set<Illness> illness=new HashSet<>();
	boolean servived;

	Patient(String name,byte g,boolean survived){
		this.name=name;
		this.gender=Gender.values()[g-1];
		this.survived=survived;
	}
	void addIllness(Illness ill){
		illness.add(ill);
	}

}
class Hospital{
	private List
	public List<Patient> getPatientsBy(Illness illness){
		
	}
	public List<Patient> getAllFatalIllnessSurvivors(){
	
	}
	public List<Patient> getAllFatalIllnessSurvivorsByGender(Gender g) {
		
	}
}
