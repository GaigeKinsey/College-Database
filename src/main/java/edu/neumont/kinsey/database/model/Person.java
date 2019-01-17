package edu.neumont.kinsey.database.model;

import java.time.LocalDate;

public abstract class Person implements Comparable<Person>, Speakable{
	private final String firstName;
	private final String lastName;
	private final LocalDate birthDate;
	
	public Person() {
		this.firstName = "Not";
		this.lastName = "Defined";
		this.birthDate = LocalDate.now();
	}
	
	public Person(String firstName, String lastName, LocalDate birthDate) {
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

	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public abstract void speak();
	
	@Override
	public String toString() {
		return this.getLastName() + ", " + this.getFirstName() + "\nBirth Date: " + birthDate;
	}

	public int compareTo(Person o) {
		return this.getLastName().compareTo(o.getLastName());
	}
}
