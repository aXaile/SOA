package manager;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("lightDecision")
public class LightDecisionService {
	
	@Path("time")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String turnOffTheLightWhenOutOfHours(){
		
		LightDecision lightDecision = new LightDecision();
		
		return lightDecision.turnOffTheLightWhenOutOfHours();
		
	}
	
	@Path("brightness")	 
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String turnOnTheLightWhenTooDark(){
		LightDecision lightDecision = new LightDecision();
		
		return lightDecision.turnOnLightWhenToDark();
	}
	
	

}
