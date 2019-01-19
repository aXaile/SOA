package sensor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("tempSensor")
public class TemperatureSensorresources{
	
	private static Room temperatureSensor=new Room();
	
	@Path("tempOut")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public double getTemperatureOutside(){
		 TemperatureSensor tso = new TemperatureSensor();
		 tso =temperatureSensor.getOutsideSensor();
		 double tempOutside=temperatureSensor.getTemperature(tso);
		 System.out.println("the temperature "+ tso.getLocation()+" is of "+tempOutside+"°C.");
		return tempOutside;
	}
	
	@Path("tempIn")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public double getTemperatureInside(){
		TemperatureSensor tsi = temperatureSensor.getInsideSensor();
		double tempInside=temperatureSensor.getTemperature(tsi);
		System.out.println("the temperature "+tsi.getLocation()+" is of "+tempInside+"°C.");
		return tempInside;
	}

}
