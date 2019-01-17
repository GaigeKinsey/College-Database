package edu.neumont.kinsey.database.model;

import java.time.LocalDate;

public class Student extends Person implements Comparable<Person>{
	private double GPA;

	public Student() {}
	
	public Student(String firstName, String lastName, LocalDate birthDate, double GPA) {
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

	@Override
	public int compareTo(Person o) {
		if (o instanceof Student) {
			Student other = (Student) o;
			return Double.compare(this.getGPA(), other.getGPA());
		} else {
			return super.compareTo(o);
		}
	}
}
