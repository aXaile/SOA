package actuator;


public class LightActuator {
	public static boolean etatDeLaLumiere = true;
		
	public String getEtatDeLaLumiere(){
		if(etatDeLaLumiere){
			System.out.println("La lumi�re est allum�e");
			return "On";
		}else{
			System.out.println("La lumi�re est �teinte");
			return "Off";
		}
	}
	
	public void setEtatDeLaLumiere(boolean etat){
		LightActuator.etatDeLaLumiere = etat;
		System.out.println("Mise � jour jour de la lumi�re r�ussi : son �tat est maintenant "+this.getEtatDeLaLumiere());
	}
}
