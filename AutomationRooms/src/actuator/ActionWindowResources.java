package actuator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("windowActionner")
public class ActionWindowResources {

	
		
	@Path("getWindowState")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getWindowState(){
		return ActionWindow.getWindowState();
	}
	
	@Path("/{state}")
	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	
	public void changeWindowState(@PathParam("state") boolean state){
		ActionWindow.setWindowState(state);
	}
}
