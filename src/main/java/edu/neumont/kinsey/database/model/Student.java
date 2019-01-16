package edu.neumont.kinsey.database.model;

public class Student extends Person {
	private double GPA;

	public Student() {}
	
	public Student(String firstName, String lastName, int birthDate, double GPA) {
		super(firstName, lastName, birthDate);
		this.setGPA(GPA);
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	@Override
	public void speak() {
		System.out.println("I need to sleep.");
	}

	@Override
	public int compareTo(Person o) {
		if (o instanceof Student) {
			Student other = (Student) o;
			return Double.compare(this.getGPA(), other.getGPA());
		} else {
			throw new IllegalArgumentException("Can only compare Students to other Students.");
		}
	}
}
