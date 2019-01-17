package edu.neumont.kinsey.database.model;

public class Student extends Person{
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
	public String toString() {
		return "Student\n" + super.toString() + "\nGPA: " + this.getGPA();
	}

	public boolean equals(Student o) {
		return this.getGPA() == o.getGPA();
	}
}
