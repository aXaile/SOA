package actuator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("lightActionner")
public class LightActuatorRessource {
			
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getEtatDeLaLumiere(){
		LightActuator lightActuator = new LightActuator();
		return lightActuator.getEtatDeLaLumiere();
	}
	
	@PUT
	@Path("/{etatDeLaLampe}")
	@Consumes(MediaType.TEXT_PLAIN)
	public void setEtatDeLaLumiere(@PathParam("etatDeLaLampe") boolean etat){
		LightActuator lightActuator = new LightActuator();
		lightActuator.setEtatDeLaLumiere(etat);
		
	}
}
