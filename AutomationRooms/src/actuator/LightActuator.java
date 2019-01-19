package actuator;


public class LightActuator {
	public static boolean etatDeLaLumiere = true;
		
	public String getEtatDeLaLumiere(){
		if(etatDeLaLumiere){
			System.out.println("La lumière est allumée");
			return "On";
		}else{
			System.out.println("La lumière est éteinte");
			return "Off";
		}
	}
	
	public void setEtatDeLaLumiere(boolean etat){
		LightActuator.etatDeLaLumiere = etat;
		System.out.println("Mise à jour jour de la lumière réussi : son état est maintenant "+this.getEtatDeLaLumiere());
	}
}
