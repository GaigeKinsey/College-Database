package edu.neumont.kinsey.database.model;

public abstract class Person implements Comparable<Person>{
	private final String firstName;
	private final String lastName;
	private final int birthDate;
	
	public Person() {
		this.firstName = "Not";
		this.lastName = "Defined";
		this.birthDate = 0;
	}
	
	public Person(String firstName, String lastName, int birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getBirthDate() {
		return birthDate;
	}
	
	public abstract void speak();

	public abstract int compareTo(Person o);
}
