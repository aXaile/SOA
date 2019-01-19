package manager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("alarmManager")
public class AlarmManagerRessource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String manageAlarmByTime(){
		AlarmManager alarmManager=new AlarmManager();
		alarmManager.manageAlarmByTime();
		return ("Ok!");
	}

}
