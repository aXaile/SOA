package manager;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import javax.ws.rs.client.Client;

public class ClientF {
	public static void main(String[] args) {
	Client client= ClientBuilder.newClient();
	Response temperature_inside=client.target("http://localhost:8080/TemperatureSensor/insaRessources/tempSensor/tempIn").request().get();
	Response temperature_outside = client.target("http://localhost:8080/TemperatureSensor/insaRessources/tempSensor/tempOut").request().get();
	

	
	//Comparaison time
	Response timeComparison = client.target("http://localhost:8080/TemperatureSensor/insaRessources/hourC/comparisonH").request().get();

	//conversion params en double
	String essai=temperature_inside.readEntity(String.class);
	
	double param1=Double.valueOf(essai);
	//System.out.println(param1);
	
	
	String essai2=temperature_outside.readEntity(String.class);
	double param2=Double.valueOf(essai2);
	//System.out.println(param2);
	
	boolean timeStatus= Boolean.valueOf(timeComparison.readEntity(String.class));
	
	
	//comparaison temp;
	Response temperatureComparison = client.target("http://localhost:8080/TemperatureSensor/insaRessources/temperatureC/finalTcompare").queryParam("temperature_inside", param1).queryParam("temperature_outside", essai2).request().get();
	boolean temperatureStatus = Boolean.valueOf(temperatureComparison.readEntity(String.class));
	
	
	System.out.println("Inside temperature: "+essai);
	System.out.println("Outside temperature: "+essai2);
	System.out.println("Are we during openning hours? "+timeStatus);
	System.out.println("Do we need to open the windows according to the temperature? "+temperatureStatus);
	
	//state window
	
	Response windowState = client.target("http://localhost:8080/TemperatureSensor/insaRessources/window/getState").request().get();

	boolean windowStatus= Boolean.valueOf(windowState.readEntity(String.class));
	if (windowStatus){System.out.println("window open");}else{System.out.println("window closed");}

	//orchestration des deux
	
	
	if(timeStatus && (windowStatus==false)){
		if(temperatureStatus){
			
			System.out.println("Open the windows");
			Response changeState=client.target("http://localhost:8080/TemperatureSensor/insaRessources/window/changewindow").request().put(Entity.entity(true,MediaType.APPLICATION_JSON));
			System.out.println(changeState.readEntity(String.class));
		}
		else{System.out.println("On ne change pas l'etat");}}
	
	else if (timeStatus && windowStatus){
		if(temperatureStatus){
			
			System.out.println("On ne change pas l'etat");}
		else{
			System.out.println("Close the window ");
			Response changeState=client.target("http://localhost:8080/TemperatureSensor/insaRessources/window/changewindow").request().put(Entity.entity(false,MediaType.APPLICATION_JSON));
			System.out.println(changeState.readEntity(String.class));
		}
	}
	else if (timeStatus==false && windowStatus){
		System.out.println("Close the window");
		Response changeState=client.target("http://localhost:8080/TemperatureSensor/insaRessources/window/changewindow").request().put(Entity.entity(false,MediaType.APPLICATION_JSON));
		System.out.println(changeState.readEntity(String.class));
	}
	else{
		System.out.println("On ne change pas l'etat");
	}
	
	}
}

