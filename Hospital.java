import java.util.*;
class IllnessFactory{
	public static Illness getIllness(String illnessName) throws UnknownIllnessException {
		
	}
}

class Illness{
	boolean isFatal(){
		
	}	

	String getName(){
		
	}
}
enum Gender{
	Male,
	Female,
	Other
}	
class Patient{
	String name;
	Gender genter;
	Set<Illness> illness=new HashSet<>();
	boolean servived;

}
