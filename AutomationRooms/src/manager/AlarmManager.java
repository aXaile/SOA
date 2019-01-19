package manager;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import common.Heure;

public class AlarmManager {
	public void manageAlarmByTime(){
		Client client =ClientBuilder.newClient();
		Response responseAlarmState = client.target("http://localhost:8080/AutomationRooms/api/alarmActionner/getAlarmState").request().get();
		System.out.println("The alarm is: "+responseAlarmState.readEntity(String.class));
		Response responsePresence=client.target("http://localhost:8080/AutomationRooms/api/presence").request().get();
		boolean presence=responsePresence.readEntity(Boolean.class);
		System.out.println("Double check Is someone in the room? "+presence);
		System.out.println("Il est "+Heure.getTime()+"h");
		if((Heure.isOpenHours()==false) && (presence==true)){
			Response response = client.target("http://localhost:8080/AutomationRooms/api/alarmActionner/true").request().put(Entity.entity(true, MediaType.TEXT_PLAIN));
			System.out.println(response.readEntity(String.class));
		}
		else if(Heure.isOpenHours()==false &&(presence==false)){
			Response response = client.target("http://localhost:8080/AutomationRooms/api/alarmActionner/false").request().put(Entity.entity(true, MediaType.TEXT_PLAIN));
			System.out.println(response.readEntity(String.class));
			
		}
		//double check status
		//Response responseAlarmStateAC = client.target("http://localhost:8080/AutomationRooms/api/alarmActionner/getAlarmState").request().get();
		//System.out.println("The alarm is now: "+responseAlarmStateAC.readEntity(String.class));
	}
}
