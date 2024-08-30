package test;

import java.io.Serializable;

public class QuizBean implements Serializable {
	private String Name, RollNumber;
	private int marks;

	public QuizBean() {
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRollNumber() {
		return RollNumber;

	}

	public void setRollNumber(String rollNumber) {
		RollNumber = rollNumber;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
}
