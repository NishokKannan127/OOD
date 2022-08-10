package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImmunizationRule {
	private int ageLower;
	private int ageHigher;
	private Map<String, Integer> vaccineLimit;

	public ImmunizationRule(String line, List<String> vaccines) {
		System.out.println("vaccc");
		this.vaccineLimit = new HashMap<>();
		String[] params = new String[2+vaccines.size()]; 
		params = line.split(",");
		this.ageLower = Integer.parseInt(params[0]);
		this.ageHigher = Integer.parseInt(params[1]);
		int count=2;
		for(String vaccine:vaccines) {
			vaccineLimit.put(vaccine, Integer.parseInt(params[count++]));
		}
		
	}

	public int getAgeLower() {
		return ageLower;
	}

	public void setAgeLower(int ageLower) {
		this.ageLower = ageLower;
	}

	public int getAgeHigher() {
		return ageHigher;
	}

	public void setAgeHigher(int ageHigher) {
		this.ageHigher = ageHigher;
	}

	public Map<String, Integer> getVaccineLimit() {
		return vaccineLimit;
	}

	public void setVaccineLimit(Map<String, Integer> vaccineLimit) {
		this.vaccineLimit = vaccineLimit;
	}

}

