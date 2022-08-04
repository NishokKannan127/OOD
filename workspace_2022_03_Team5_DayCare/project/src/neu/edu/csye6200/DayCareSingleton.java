package neu.edu.csye6200;

public class DayCareSingleton {
	public static DayCare daycare;
	
	private DayCareSingleton() {
		daycare = new DayCare();
	}
	
	public static DayCare getInstance() {
		return DayCareSingleton.daycare;
	}
}
