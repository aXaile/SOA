package fr.insat.om2m.tp2.test;

import java.io.IOException;

import org.eclipse.om2m.commons.resource.AE;
import org.eclipse.om2m.commons.resource.Container;
import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.tp2.client.Client;
import fr.insat.om2m.tp2.client.Response;
import fr.insat.om2m.tp2.mapper.Mapper;
import fr.insat.om2m.tp2.mapper.MapperInterface;
import fr.insat.om2m.tp2.util.RequestLoader;
import obix.Bool;
import obix.Obj;
import obix.Str;
import obix.io.ObixDecoder;
import obix.io.ObixEncoder;

public class Main {

	public static void main(String[] args) {
		

		
		
		String url = "http://localhost:8080/~/in-cse/in-name/";
		String originator ="admin:admin";
		
		Client cli = new Client();
		
		
		
		// Création de l'Application Entities Automatisation INSA
		String representation = RequestLoader.getRequestFromFile("create_ae_automatisation_insa.xml");

		try {
			Response rep1 = cli.create(url, representation, originator, "2");
			System.out.println(rep1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		url = "http://localhost:8080/~/in-cse/in-name/automatisation_insa";
		
		
		//Création des container SENSOR & ACTUATOR
		
		representation = RequestLoader.getRequestFromFile("create_cnt_sensor.xml");
		try {
			Response rep1 = cli.create(url, representation, originator, "3");
			System.out.println(rep1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		representation = RequestLoader.getRequestFromFile("create_cnt_actuator.xml");

		try {
			Response rep1 = cli.create(url, representation, originator, "3");
			System.out.println(rep1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		// Création des capteurs de température out et ext/presence/light
		url = "http://localhost:8080/~/in-cse/in-name/automatisation_insa/SENSOR_CTN";
		
		
		representation = RequestLoader.getRequestFromFile("create_cin_temperature_inside.xml");

		try {
			Response rep1 = cli.create(url, representation, originator, "4");
			System.out.println(rep1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		representation = RequestLoader.getRequestFromFile("create_cin_temperature_outside.xml");

		try {
			Response rep1 = cli.create(url, representation, originator, "4");
			System.out.println(rep1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		representation = RequestLoader.getRequestFromFile("create_cin_presence.xml");

		try {
			Response rep1 = cli.create(url, representation, originator, "4");
			System.out.println(rep1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		representation = RequestLoader.getRequestFromFile("create_cin_light.xml");

		try {
			Response rep1 = cli.create(url, representation, originator, "4");
			System.out.println(rep1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Création des actuateurs des portes, fenêtre, lumière et volet
		
		url = "http://localhost:8080/~/in-cse/in-name/automatisation_insa/ACTUATOR_CTN";
		
		
		representation = RequestLoader.getRequestFromFile("create_cin_blinds.xml");

		try {
			Response rep1 = cli.create(url, representation, originator, "4");
			System.out.println(rep1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		representation = RequestLoader.getRequestFromFile("create_cin_doors.xml");

		try {
			Response rep1 = cli.create(url, representation, originator, "4");
			System.out.println(rep1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		representation = RequestLoader.getRequestFromFile("create_cin_windows.xml");

		try {
			Response rep1 = cli.create(url, representation, originator, "4");
			System.out.println(rep1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		representation = RequestLoader.getRequestFromFile("create_cin_light_act.xml");

		try {
			Response rep1 = cli.create(url, representation, originator, "4");
			System.out.println(rep1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	
		
		
		
		
		


		

		
		
	}

}