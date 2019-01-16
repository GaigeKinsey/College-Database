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
	public int compareTo(Person o) {
		if (o instanceof Faculty || o instanceof Staff) {
			int result = 0;
			if (this.getLastName().equals(o.getLastName())) {
				result = 1;
			} else {
				result = -1;
			}
			return result;
		} else {
			throw new IllegalArgumentException("Can't compare Faculty or Staff to a Student.");
		}
	}
}
