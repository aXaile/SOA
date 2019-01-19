package actuator;

public class ActionAlarm {
	private static boolean alarmState;// false eteinte true allumee
	
	public static String getAlarmState(){
		if(alarmState){
			return "on";
		}else{
			return "off";
		}
	}
	
	public static void setAlarmState(boolean state){
		ActionAlarm.alarmState=state;
		System.out.println("The alarm is now "+ getAlarmState());
	}
}
