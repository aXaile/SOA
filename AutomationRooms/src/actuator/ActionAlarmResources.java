package actuator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("alarmActionner")
public class ActionAlarmResources {
	
	@Path("getAlarmState")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAlarmState(){
		return ActionAlarm.getAlarmState();
	}
	
	@Path("/{newstate}")
	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	public void setAlarm(@PathParam("newstate") boolean state){
		ActionAlarm.setAlarmState(state);
	}
}
