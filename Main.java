import java.util.*;
public class Testmain {
    public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	Hospital obj=new Hospital();
   	boolean loop = true;
    	while (loop)
      	   {
		System.out.println("1. Add Patient \n2.Add illness \n3.Print patients \n4.Show All Fatal Illness Survivors\n5.Show AllFatal Illness Survivors By Gender\n6. Exit");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice){
	  		case 1:{
	     		        System.out.println ("Enter the patient Name:");
	     		        String name=sc.nextLine();
	     		        System.out.println ("Enter the gender:");
	     		        String gender=sc.nextLine();
	     			break;
	   		 }
	 		 case 2:{
	 		 	
	     			break;
	    		}

	  		case 3:{
	    
	      			break;
	    		}
	    		case 4:{
	      		
	      			break;
	    		}
	    		case 5:{
	    
	      			break;
	    		}
	  		case 6:{
	      			loop=false;
	 		 }
      	   }
       }
    }
}
