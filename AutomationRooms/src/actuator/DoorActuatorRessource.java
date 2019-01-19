package actuator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("doorActionner")
public class DoorActuatorRessource {
	
	@Path("getDoorState")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDoorState(){
		return DoorActuator.getEtatDeLaPorte();
	}
	
	
	@Path("/{newState}")
	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	public void setDoorState(@PathParam("newState") boolean newState){
		DoorActuator.setEtatDeLaPorte(newState);
	}
	


}