package neu.edu.csye6200.models;

import java.util.HashMap;

public class Immunization {
	HashMap<String,Integer> vaccineMap;
	public void Immunization()
	{
		vaccineMap=new HashMap<>();
	}
	public HashMap<String, Integer> getVaccineMap() {
		return vaccineMap;
	}

	public void setVaccineMap(HashMap<String, Integer> vaccineMap) {
		this.vaccineMap = vaccineMap;
	}
	
	

}
