package studentManagementSystem;

public class StudentBean {
private String roll;
private String name;
private String branch;
private float percentage;
private int totalMarks;
private String result;

public StudentBean() {
	super();
	// TODO Auto-generated constructor stub
}
public String getRoll() {
	return roll;
}
public void setRoll(String roll) {
	this.roll = roll;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public float getPercentage() {
	return percentage;
}
public void setPercentage(float percentage) {
	this.percentage = percentage;
}
public int getTotalMarks() {
	return totalMarks;
}
public void setTotalMarks(int totalMarks) {
	this.totalMarks = totalMarks;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}

@Override
public String toString() {
	return "<br>RollNumber=" + roll + "<br> Name=" + name + "<br> Branch=" + branch + "<br> Percentage=" + percentage
			+ "<br> TotalMarks=" + totalMarks + "<br> Result=" + result + "<br>";
}

}
