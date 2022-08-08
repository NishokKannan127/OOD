package neu.edu.csye6200.models;

public class ImmunizationRule {
	private int ageLower;
	private int ageHigher;
	private int hib;
	private int tdap;
	private int polio;
	private int hepatitisB;
	private int MMR;
	private int varicella;
	
	public ImmunizationRule(String line) {
		String[] params = new String[4]; 
		params = line.split(",");
		this.ageLower = Integer.parseInt(params[0]);
		this.ageHigher = Integer.parseInt(params[1]);
		this.tdap = Integer.parseInt(params[2]);
		this.polio = Integer.parseInt(params[3]);
		this.hepatitisB = Integer.parseInt(params[4]);
		this.MMR = Integer.parseInt(params[5]);
		this.varicella= Integer.parseInt(params[6]);
		this.hib=Integer.parseInt(params[7]);
		
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

	public int getHib() {
		return hib;
	}

	public void setHib(int hib) {
		this.hib = hib;
	}

	public int getTdap() {
		return tdap;
	}

	public void setTdap(int tdap) {
		this.tdap = tdap;
	}

	public int getPolio() {
		return polio;
	}

	public void setPolio(int polio) {
		this.polio = polio;
	}

	public int getHepatitisB() {
		return hepatitisB;
	}

	public void setHepatitisB(int hepatitisB) {
		this.hepatitisB = hepatitisB;
	}

	public int getMMR() {
		return MMR;
	}

	public void setMMR(int mMR) {
		MMR = mMR;
	}

	public int getVaricella() {
		return varicella;
	}

	public void setVaricella(int varicella) {
		this.varicella = varicella;
	}
	
	
}

