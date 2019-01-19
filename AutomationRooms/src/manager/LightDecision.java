package manager;




import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import common.Heure;


public class LightDecision {
	
	public static double LIGHT_SENSOR_TRHESHOLD = 50;
	
	

	
	public String turnOffTheLightWhenOutOfHours(){
		
		
		if(Heure.isOpenHours()){
			
			System.out.println(" Heure de cours");
			return("The lights are left in the same way");
		}else{
			System.out.println(" Pas heure de cours");

			Client client = ClientBuilder.newClient();
			Response response = client.target("http://localhost:8080/AutomationRooms/api/lightActionner/false").request().put(Entity.entity(false, MediaType.TEXT_PLAIN));
			System.out.println(response.readEntity(String.class));
			Response response2=client.target("http://localhost:8080/AutomationRooms/api/lightActionner").request().get();
			System.out.println(response2.readEntity(String.class));
			return("The lights have been turned off ");
		}


	}	 
	
	public String turnOnLightWhenToDark(){
		System.out.println("Cas d'usage : Allumer la lumière si il fait trop sombre ( valeur en dessous de 50 ) et que on est en heure ouvrée ( entre 7h et 22h)");
		
		Client client = ClientBuilder.newClient();
		Response responseLightSensorValue = client.target("http://localhost:8080/AutomationRooms/api/light").request().get();
		double lightSensorValue =  responseLightSensorValue.readEntity(double.class);
		
		Response responseLightState = client.target("http://localhost:8080/AutomationRooms/api/lightActionner").request().get();
		String stateLightAsString = responseLightState.readEntity(String.class);
		System.out.println(stateLightAsString);
		//un peu tordu, est ce que la lampe est eteinte
		boolean isLampTurnOff;
		isLampTurnOff = stateLightAsString.equals("On") ? false :  true ;
		System.out.println(isLampTurnOff);
		
				//si on est sous le seul de luminosité que la lampe est eteinte et heure ouverture
		if(lightSensorValue < LIGHT_SENSOR_TRHESHOLD && isLampTurnOff && Heure.isOpenHours()){
			System.out.println("La valeur de luminosité est inférieur à 50");

			//on allume
			Response responseSetLightOn = client.target("http://localhost:8080/AutomationRooms/api/lightActionner/true").request().put(Entity.entity(true, MediaType.TEXT_PLAIN));
			System.out.println(responseSetLightOn.readEntity(String.class));
			System.out.println("Nous avons allumé les lumières");
			return("Lights have been turned on because it was too dark.");
		}
		else{
			//si la lampe est eteinte bizarre de dire que cest parce quon est pas en heures ouverture
			if(isLampTurnOff){
				System.out.println("Nous ne sommes pas en heure ouvrée, rien a été modifié");
				
			}
			if(Heure.isOpenHours()){
				System.out.println("La lumière est déjà allumée, rien a été modifié");
			}
			return("We keep it that way !");
		}
	}
}
