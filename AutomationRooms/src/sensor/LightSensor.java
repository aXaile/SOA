package sensor;


public class LightSensor {

	
	public double getLightSensorValue(){
		double valeurDuCapteur = Math.random() * 100;
		System.out.println("Valeur de la luminosit� : " + valeurDuCapteur);
		return valeurDuCapteur;	
	}	
}

