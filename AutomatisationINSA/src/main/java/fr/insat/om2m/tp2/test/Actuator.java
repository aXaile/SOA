package fr.insat.om2m.tp2.test;

import java.io.IOException;

import org.eclipse.om2m.commons.resource.Container;
import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.tp2.client.Client;
import fr.insat.om2m.tp2.client.Response;
import fr.insat.om2m.tp2.mapper.Mapper;
import fr.insat.om2m.tp2.mapper.MapperInterface;

public class Actuator {
	
	
	String originator ="admin:admin";
	
	Client cli = new Client();
	MapperInterface mapper = new Mapper();

	
	public void openWindows() {
		String url = "http://localhost:8080/~/in-cse/in-name/automatisation_insa/ACTUATOR_CTN/windows_actuator";


		ContentInstance updateWindows = new ContentInstance();
		updateWindows.setContent("Ouvert");
		String update = mapper.marshal(updateWindows);
		
		try {
			Response rep2 = cli.update(url, update, originator);
			System.out.println(rep2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void closeWindows() {
		String url = "http://localhost:8080/~/in-cse/in-name/automatisation_insa/ACTUATOR_CTN/windows_actuator";


		ContentInstance updateWindows = new ContentInstance();
		updateWindows.setContent("Ferme");
		String update = mapper.marshal(updateWindows);
		
		try {
			Response rep2 = cli.update(url, update, originator);
			System.out.println(rep2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void openDoors() {
		String url = "http://localhost:8080/~/in-cse/in-name/automatisation_insa/ACTUATOR_CTN/doors_actuator";


		ContentInstance updateDoor = new ContentInstance();
		updateDoor.setContent("Ouvert");
		String update = mapper.marshal(updateDoor);
		
		try {
			Response rep2 = cli.update(url, update, originator);
			System.out.println(rep2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void closeDoors() {
		String url = "http://localhost:8080/~/in-cse/in-name/automatisation_insa/ACTUATOR_CTN/doors_actuator";


		ContentInstance updateDoor = new ContentInstance();
		updateDoor.setContent("Ferme");
		String update = mapper.marshal(updateDoor);
		
		try {
			Response rep2 = cli.update(url, update, originator);
			System.out.println(rep2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void openBlinds() {
		String url = "http://localhost:8080/~/in-cse/in-name/automatisation_insa/ACTUATOR_CTN/blinds_actuator";


		ContentInstance updateBlinds = new ContentInstance();
		updateBlinds.setContent("Ouvert");
		String update = mapper.marshal(updateBlinds);
		
		try {
			Response rep2 = cli.update(url, update, originator);
			System.out.println(rep2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void closeBlinds() {
		String url = "http://localhost:8080/~/in-cse/in-name/automatisation_insa/ACTUATOR_CTN/blinds_actuator";


		ContentInstance updateBlinds = new ContentInstance();
		updateBlinds.setContent("Ferme");
		String update = mapper.marshal(updateBlinds);
		
		try {
			Response rep2 = cli.update(url, update, originator);
			System.out.println(rep2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void turnOffLight() {
		String url = "http://localhost:8080/~/in-cse/in-name/automatisation_insa/ACTUATOR_CTN/light_actuator";


		ContentInstance updateLight = new ContentInstance();
		updateLight.setContent("Eteint");
		String update = mapper.marshal(updateLight);
		
		try {
			Response rep2 = cli.update(url, update, originator);
			System.out.println(rep2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void turnOnLights() {
		String url = "http://localhost:8080/~/in-cse/in-name/automatisation_insa/ACTUATOR_CTN/light_actuator";


		ContentInstance updateLight = new ContentInstance();
		updateLight.setContent("Allume");
		String update = mapper.marshal(updateLight);
		
		try {
			Response rep2 = cli.update(url, update, originator);
			System.out.println(rep2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
