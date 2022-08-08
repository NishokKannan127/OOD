package neu.edu.csye6200.models;

public class GroupRule {
	private int ageLower;
	private int ageHigher;
	private int size;
	private int max;
	
	public GroupRule(String line) {
		String[] params = new String[4]; 
		params = line.split(",");
		this.ageLower = Integer.parseInt(params[0]);
		this.ageHigher = Integer.parseInt(params[1]);
		this.size = Integer.parseInt(params[2]);
		this.max = Integer.parseInt(params[3]);
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	
}
