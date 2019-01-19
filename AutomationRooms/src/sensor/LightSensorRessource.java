package sensor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("light")
public class LightSensorRessource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public double getLightSensorValue(){
		LightSensor lightSensor = new LightSensor();	
		return lightSensor.getLightSensorValue();	
	}	
}

