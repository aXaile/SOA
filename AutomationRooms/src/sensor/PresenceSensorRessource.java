package sensor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("presence")
public class PresenceSensorRessource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public boolean getPresence(){
		return PresenceSensor.getPresenceInTheRoom();
	}

}
