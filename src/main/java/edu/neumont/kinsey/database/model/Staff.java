package edu.neumont.kinsey.database.model;

public class Staff extends Person{
	private Department department;
	
	public Staff() {}

	public Staff(String firstName, String lastName, int birthDate, Department department) {
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
}
