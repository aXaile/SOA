package sensor;

import java.util.ArrayList;


public class Room {
	


	
	private TemperatureSensor insideSensor;
	private TemperatureSensor outsideSensor;
	private ArrayList<TemperatureSensor> sensors= new ArrayList<TemperatureSensor>();
	
	public Room(){
		 insideSensor= new TemperatureSensor("outside");
		 outsideSensor = new TemperatureSensor("inside");
		sensors.add(insideSensor);
		sensors.add(outsideSensor);
	}
	
		
		public TemperatureSensor getOutsideSensor(){
			TemperatureSensor results=new TemperatureSensor();
			for(TemperatureSensor index:sensors){
				if (index.getLocation().equals("outside")){
					results=index;
				}
			}
		return results;
		}
		
		public TemperatureSensor getInsideSensor(){
			TemperatureSensor results=new TemperatureSensor();
			for (TemperatureSensor index:sensors){
				if(index.getLocation().equals("inside")){
					results=index;
				}
			}
			return results;
		}
	
	
	
	public double getTemperature(TemperatureSensor loc){
		return loc.getTemperature();
	
	}
}
