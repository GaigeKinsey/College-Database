package edu.neumont.kinsey.database.model;

import java.time.LocalDate;

public class Staff extends Person{
	private Department department;
	
	public Staff() {}

	public Staff(String firstName, String lastName, LocalDate birthDate, Department department) {
		super(firstName, lastName, birthDate);
		this.setDepartment(department);
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void speak() {
		System.out.println("Is it Friday yet?");
	}
	
	@Override
	public String toString() {
		return "Staff\n" + super.toString() + "\nSchool Department: " + getDepartment().toString().replaceAll("_", " ");
	}
	
	public String serialize() {
		return super.serialize().trim() + ", " + this.getDepartment();
	}
	
	public void deserialize(String piece) {
		String[] parts = piece.trim().split(", ");
		super.deserialize(new String[] {parts[0], parts[1], parts[2]});
		this.setDepartment(Department.valueOf(parts[3]));
	}
}
