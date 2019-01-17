package edu.neumont.kinsey.database.model;

public class Faculty extends Person{
	private Degree degree;
	
	public Faculty() {}
	
	public Faculty(String firstName, String lastName, int birthDate, Degree degree) {
		super(firstName, lastName, birthDate);
		this.setDegree(degree);
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public void speak() {
		System.out.println("I have another lab for you!");
	}
	
	@Override
	public String toString() {
		return "Faculty\n" + super.toString() + "\nDegree Program: " + getDegree().toString().replaceAll("_", " ");
	}
}
