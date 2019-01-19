package manager;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import common.Heure;

public class WindowManager {
	
	Client client= ClientBuilder.newClient();
	Response temperature_inside=client.target("http://localhost:8080/AutomationRooms/api/tempSensor/tempIn").request().get();
	Response temperature_outside = client.target("http://localhost:8080/AutomationRooms/api/tempSensor/tempOut").request().get();
	
	//conversion params en double
		String temp_in=temperature_inside.readEntity(String.class);
		double param1=Double.valueOf(temp_in);
		
		String temp_out=temperature_outside.readEntity(String.class);
		double param2=Double.valueOf(temp_out);

		Response temperatureComparison = client.target("http://localhost:8080/AutomationRooms/api/temperatureC/finalTcompare").queryParam("temperature_inside", param1).queryParam("temperature_outside", param2).request().get();
		boolean temperatureStatus = Boolean.valueOf(temperatureComparison.readEntity(String.class));
		
		//state window
		Response windowState = client.target("http://localhost:8080/AutomationRooms/api/windowActionner/getWindowState").request().get();
		boolean windowStatus= Boolean.valueOf(windowState.readEntity(String.class));
		
		
		public void manageWindowByTime(){
			if(Heure.isOpenHours()==false){
				System.out.println("Hour outside of opening hours");
				Response changeStateW=client.target("http://localhost:8080/AutomationRooms/api/windowActionner/false").request().put(Entity.entity(false, MediaType.TEXT_PLAIN));
				//check if it worked
				Response newState=client.target("http://localhost:8080/AutomationRooms/api/windowActionner/getWindowState").request().get();
				System.out.println("double check: windows are now "+newState.readEntity(String.class));
			}
		}
		
		public void manageWindowByTemp(){
			if(temperatureStatus){
				Response changeStateW=client.target("http://localhost:8080/AutomationRooms/api/windowActionner/true").request().put(Entity.entity(true, MediaType.TEXT_PLAIN));
				//check if it worked
				Response newState=client.target("http://localhost:8080/AutomationRooms/api/windowActionner/getWindowState").request().get();
				System.out.println("windows are now "+newState.readEntity(String.class));
			}
			
		}
}
