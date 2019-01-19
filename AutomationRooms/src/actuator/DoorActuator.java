package actuator;

public class DoorActuator {
	
	private static boolean doorState= true; // True pour dévérouillée
	
	public static String getEtatDeLaPorte(){
		if(doorState){
			return("Unlock");
		}
		else{
			return("Lock");
		}		
	}
	
	public static void setEtatDeLaPorte(boolean newState){
		DoorActuator.doorState = newState;
		System.out.println("The door is now "+ getEtatDeLaPorte());
	}

}
