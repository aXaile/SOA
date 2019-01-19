package manager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("doorManager")
public class DoorManagerService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String manageDoorByTime(){
		DoorManager doorManager = new DoorManager();
		doorManager.manageDoorByTime();
		return("Ok !");
		
	}

}
