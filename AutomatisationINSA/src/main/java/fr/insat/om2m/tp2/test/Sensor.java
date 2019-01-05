package fr.insat.om2m.tp2.test;

import java.io.IOException;
import java.util.Calendar;

import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.tp2.client.Client;
import fr.insat.om2m.tp2.client.Response;
import fr.insat.om2m.tp2.mapper.Mapper;
import fr.insat.om2m.tp2.mapper.MapperInterface;

public class Sensor {
	
	String originator ="admin:admin";
	
	Client cli = new Client();
	MapperInterface mapper = new Mapper();

	public String getLightValue() {
		String url="http://localhost:8080/~/in-cse/in-name/automatisation_insa/SENSOR_CTN/light_sensor";
		
		try {
			Response rep = cli.retrieve( url,  originator);
			String repr = rep.getRepresentation();
			ContentInstance cin_light_sensor = (ContentInstance) mapper.unmarshal(repr);
			return(cin_light_sensor.getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erreur";
	}
	
	public String getTempInsideValue() {
		String url="http://localhost:8080/~/in-cse/in-name/automatisation_insa/SENSOR_CTN/temperature_sensors_inside";
		
		try {
			Response rep = cli.retrieve( url,  originator);
			String repr = rep.getRepresentation();
			ContentInstance cin_temp_sensor_inside = (ContentInstance) mapper.unmarshal(repr);
			return(cin_temp_sensor_inside.getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erreur";
	}
	
	public String getTempOutsideValue() {
		String url="http://localhost:8080/~/in-cse/in-name/automatisation_insa/SENSOR_CTN/temperature_sensors_outside";
		
		try {
			Response rep = cli.retrieve( url,  originator);
			String repr = rep.getRepresentation();
			ContentInstance cin_temp_sensor_outside = (ContentInstance) mapper.unmarshal(repr);
			return(cin_temp_sensor_outside.getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erreur";
	}
	
	public String getPresenceValue() {
		String url="http://localhost:8080/~/in-cse/in-name/automatisation_insa/SENSOR_CTN/presence_sensor";
		
		try {
			Response rep = cli.retrieve( url,  originator);
			String repr = rep.getRepresentation();
			ContentInstance cin_presence = (ContentInstance) mapper.unmarshal(repr);
			return(cin_presence.getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erreur";
	}
	
	
	public String getTime() {
		Calendar cal = Calendar.getInstance();
		return(cal.get(Calendar.HOUR_OF_DAY)+"h "+cal.get(Calendar.MINUTE)+"m et "+cal.get(Calendar.SECOND)+"s");
		
	}

}
