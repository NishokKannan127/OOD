package neu.edu.csye6200.models;

import java.util.HashMap;

public class Immunization {
	private HashMap<String,Integer> vaccineMap;
	public Immunization()
	{
		vaccineMap=new HashMap<>();
	}
	public HashMap<String, Integer> getVaccineMap() {
		return vaccineMap;
	}

	public void setVaccineMap(HashMap<String, Integer> vaccineMap) {
		this.vaccineMap = vaccineMap;
	}
	
	public void addImmunizationRecord(String vaccine, int value) {
		this.vaccineMap.put(vaccine, value);
		
		System.out.println("Vaccine"+ vaccine);
	}

}
