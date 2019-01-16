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
	public int compareTo(Person o) {
		if (o instanceof Faculty || o instanceof Staff) {
			return this.getLastName().compareTo(o.getLastName());
		} else {
			throw new IllegalArgumentException("Can't compare Faculty or Staff to a Student.");
		}
	}
}
