package edu.neumont.kinsey.database.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person implements Comparable<Person>{
	private String firstName;
	private String lastName;
	private LocalDate birthDate;

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
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthDate(LocalDate birthDate) {
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
	
	public String serialize() {
		return this.getFirstName() + ", " + this.getLastName() + ", " + this.getBirthDate();
	}
	
	public void deserialize(String[] strings) {
		this.setFirstName(strings[0]);
		this.setLastName(strings[1]);
		this.setBirthDate(LocalDate.parse(strings[2], DateTimeFormatter.ISO_DATE));
	}
}
