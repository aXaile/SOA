package sensor;

public class PresenceSensor {

	
	public static boolean getPresenceInTheRoom(){
		boolean sensorState;
		String state;
		if (Math.random()<0.5){
			sensorState=false;
			state="no one";
		}else{
			sensorState=true;
			state="someone";
		}
		System.out.println(state+" is in the room");
		return sensorState;		
	}

}
