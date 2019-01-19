package manager;

public class TemperatureComparison {
	
	private static double tempMin = 18.0;
	private static double tempMax =27.0;
	private static boolean tempExtBtwMinMax=false;
	private static boolean isGreaterThan= false;
	
	public boolean compareOutside(double temp){
		if(temp>=tempMin && temp<=tempMax){
			tempExtBtwMinMax=true;
		}else{
			tempExtBtwMinMax=false;
		}
		return tempExtBtwMinMax;
	}
	
	public boolean compareInOut(double temp1, double temp2){
		if (temp1>=temp2){
			isGreaterThan=true;
		}else{
			isGreaterThan=false;
		}
		return isGreaterThan;
	}
	

}
