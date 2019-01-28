package edu.neumont.kinsey.database.model;

import java.time.LocalDate;

public class Faculty extends Person{
	private Degree degree;
	
	public Faculty() {}
	
	public Faculty(String firstName, String lastName, LocalDate birthDate, Degree degree) {
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
	
	public String serialize() {
		return super.serialize().trim() + ", " + this.getDegree();
	}
	
	public void deserialize(String piece) {
		String[] parts = piece.trim().split(", ");
		super.deserialize(new String[] {parts[0], parts[1], parts[2]});
		this.setDegree(Degree.valueOf(parts[3]));
	}
}
