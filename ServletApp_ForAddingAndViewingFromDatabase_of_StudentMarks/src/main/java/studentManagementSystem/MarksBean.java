package studentManagementSystem;

public class MarksBean {
	private String roll;
	private int math;
	private int phy;
	private int chem;
	private int eng;
	private int bio;
	
	public MarksBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setRoll(String roll)
	{
		this.roll=roll;
	}
	public String getRoll() {
		return roll;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getPhy() {
		return phy;
	}
	public void setPhy(int phy) {
		this.phy = phy;
	}
	public int getChem() {
		return chem;
	}
	public void setChem(int chem) {
		this.chem = chem;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getBio() {
		return bio;
	}
	public void setBio(int bio) {
		this.bio = bio;
	}
	@Override
	public String toString() {
		return " Math=" + math + "<br>Physics=" + phy + "<br>Chemistry=" + chem + "<br>English=" + eng
				+ "<br>Biology" + bio + "";
	}
	
}
