package sensor;

public class TemperatureSensor {
	

	private String location;

	private final static double  TEMP_MIN=-10;
	private final static double TEMP_MAX= 50;
	
	public TemperatureSensor(String location){
			this.location=location;
	}
	public TemperatureSensor(){
		
	}
	public String getLocation(){
		return this.location;
	}
	
	public void setLocation(){
		if(Math.random()<0.5){
			 location="outside";
			}else{
				location="inside";
			}
	}
	

	public double getTemperature(){
	double temp= TEMP_MIN+(Math.random()*(TEMP_MAX-TEMP_MIN));
		return temp;
	}
}
