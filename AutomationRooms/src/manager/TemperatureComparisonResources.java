package manager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("temperatureC")
public class TemperatureComparisonResources {
	private final static double  TEMP_MIN=-10;
	private final static double TEMP_MAX= 50;

	@GET
	@Path("comparisonT")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean getComparateT(){
		TemperatureComparison tc =new TemperatureComparison();
		double temp1= TEMP_MIN+(Math.random()*(TEMP_MAX-TEMP_MIN));
		System.out.println(temp1);
		double temp2= TEMP_MIN+(Math.random()*(TEMP_MAX-TEMP_MIN));
		System.out.println(temp2);
		return tc.compareInOut(temp1, temp2);
	}
	
	@GET
	@Path("comparisonTo")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean getComparateTo(){
		TemperatureComparison tco = new TemperatureComparison();
		double temp= TEMP_MIN+(Math.random()*(TEMP_MAX-TEMP_MIN));
		System.out.println(temp);
		return tco.compareOutside(temp);
	}
	
	@GET
	@Path("finalTcompare")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean IsOkforWindowOpen(@QueryParam("temperature_inside") double temp1, @QueryParam("temperature_outside") double temp2){
		TemperatureComparison tcf= new TemperatureComparison();
		//double temp1= TEMP_MIN+(Math.random()*(TEMP_MAX-TEMP_MIN));
		System.out.println("inside temperature: "+temp1);
		//double temp2= TEMP_MIN+(Math.random()*(TEMP_MAX-TEMP_MIN));
		System.out.println("outside temperature: "+temp2);
		System.out.println("Windows need to be opened due to temperatures? "+ (tcf.compareOutside(temp2) && tcf.compareInOut(temp1, temp2)));
		return tcf.compareOutside(temp2) && tcf.compareInOut(temp1, temp2);
				
	}

}
