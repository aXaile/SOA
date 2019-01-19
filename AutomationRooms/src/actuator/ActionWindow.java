package actuator;

public class ActionWindow {
	
 private static boolean windowstate; // true=open; false=closed
	
	public static String getWindowState(){
		if(windowstate){
			return("open");}
		else{
			return("closed");
		}
	}

	
	
	public static void setWindowState(boolean windowState ){
		ActionWindow.windowstate=windowState;
		System.out.println("The window is now "+ getWindowState());
	}
}
