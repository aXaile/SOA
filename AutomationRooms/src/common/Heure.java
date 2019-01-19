package common;

public class Heure {
	private static int heure = 23;
	public static boolean isOpenHours(){
		//int heure = (int) (Math.random() *24) ;
		
		//System.out.println("Il est "+heure+"h");
		if(7 < heure && heure < 22){
			return true;
		}
		else{
			return false;
		}
		
	}
		
		public static int getTime(){
			return heure;
		}

}
