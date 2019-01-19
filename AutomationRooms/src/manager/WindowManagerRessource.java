package manager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import common.Heure;

@Path("windowManager")
public class WindowManagerRessource {
	
	
	@Path("time")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String manageWindowByTime(){
		WindowManager windowManager=new WindowManager();
		windowManager.manageWindowByTime();
		return("Ok!");
	}
	
	@Path("temperature")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String manageWindowByTemp(){
		WindowManager windowManager=new WindowManager();
		windowManager.manageWindowByTemp();
		return("OK!");
	}
	
	@Path("time_temp")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String manageWindow(){
		WindowManager windowManager = new WindowManager();
		if(Heure.isOpenHours()){
		windowManager.manageWindowByTemp();
		}else{
		windowManager.manageWindowByTime();}
		return("ok!");
	}
}
	



