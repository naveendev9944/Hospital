import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner (System.in);
        Hospital obj=new Hospital();
	IllnessFactory  factory=new IllnessFactory();
        boolean loop = true;
        factory.loadIllnessesFromFile();
        while (loop)
           {
                System.out.println("\n\n1.Add Patient \n2.Add illness \n3.Print patients by illness \n4.Show All Fatal Illness Survivors\n5.Show AllFatal Illness Survivors By Gender\n6. Exit\n");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice){
                        case 1:{
                                System.out.println ("Enter the patient Name:");
                                String name=sc.nextLine();
                                System.out.println ("Enter the gender:\n1.Male\n2.Female");
                                byte gender=sc.nextByte();
				System.out.println("Survived by the illness\t1.Yes\t 0.No");
				byte survive=sc.nextByte();
				System.out.println("Enter the illness to be add");
				factory.printIllness();
				byte ill=sc.nextByte();
                                sc.nextLine();
				Patient pat=new Patient(name,gender,survive==1?true:false);
				try{
				pat.addIllness(factory.getIllness(ill));
				}catch (UnknownIllnessException e) {
            				System.err.println(e.getMessage());
        			}
				obj.addPatient(pat);
                                break;
                         }
                         case 2:{
                                System.out.println ("Enter the patient Name:");
                                String name=sc.nextLine();
                                Patient p=obj.getPatient(name);
                                if(p==null){
                                        System.out.println("Patient not found");
                                        break;
                                }
                                System.out.println("Enter the illness to be add");
                                factory.printIllness();
                                byte ill=sc.nextByte();
                                sc.nextLine();
                                try{
				p.addIllness(factory.getIllness(ill));
				}catch (UnknownIllnessException e) {
            				System.err.println(e.getMessage());
        			}
                                break;
                        }

                        case 3:{
				System.out.println("Enter the illness");
                                factory.printIllness();
                                byte ill=sc.nextByte();
                                sc.nextLine();
                                try{
                                List<Patient> patients=obj.getPatientsBy((factory.getIllness(ill)));
                                System.out.println("\nPatients by illness\n");
                                obj.showp(patients);                                				
				}catch (UnknownIllnessException e) {
            				System.err.println(e.getMessage());
        			}
                                
                                break;
                        }
                        case 4:{
                                List<Patient> patients=obj.getAllFatalIllnessSurvivors();
                                System.out.println("\nAll Fatal Illness Survivors\n");
                                obj.showp(patients);
                                break;
                        }
                        case 5:{
				System.out.println ("Enter the gender:\n1.Male\n2.Female");
                                byte g=sc.nextByte();
                                List<Patient> patients=obj.getAllFatalIllnessSurvivorsByGender(Gender.values()[g-1]);
                                System.out.println("\nAll Fatal Illness Survivors  By Gender\n");
                                obj.showp(patients);
                                break;
                        }
                        case 6:{
                                loop=false;
                        }
           }
       }
    }
}

