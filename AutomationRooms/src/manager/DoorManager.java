package manager;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import common.Heure;

public class DoorManager {
	
	public void manageDoorByTime(){
		Client client = ClientBuilder.newClient();
		Response responseDoorState =client.target("http://localhost:8080/AutomationRooms/api/doorActionner/getDoorState").request().get();
		System.out.println("the doors are: "+responseDoorState.readEntity(String.class));
		//Response responsePresenceSensors = client.target("http://localhost:8080/AutomationRooms/api/presence").request().get();
		//System.out.println("Is someone there? " +responsePresenceSensors.readEntity(String.class));

		if(Heure.isOpenHours()){
			
			Response response = client.target("http://localhost:8080/AutomationRooms/api/doorActionner/true").request().put(Entity.entity(true, MediaType.TEXT_PLAIN));
			System.out.println(response.readEntity(String.class));
			System.out.println("les portes sont unlock");
		}
		else{
			
			
			Response response = client.target("http://localhost:8080/AutomationRooms/api/doorActionner/false").request().put(Entity.entity(true, MediaType.TEXT_PLAIN));
			System.out.println(response.readEntity(String.class));
			System.out.println("les portes sont lock");
		}
			
	}
	
}
		
	