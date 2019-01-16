package edu.neumont.kinsey.database.controller;

import java.util.ArrayList;
import java.util.List;

import edu.neumont.kinsey.database.model.Degree;
import edu.neumont.kinsey.database.model.Department;
import edu.neumont.kinsey.database.model.Faculty;
import edu.neumont.kinsey.database.model.Person;
import edu.neumont.kinsey.database.model.Staff;
import edu.neumont.kinsey.database.model.Student;

public class Program {
	List<Person> people = new ArrayList<>();
	
	public void run() {
		init();
		people.get(1).speak();
		
	}

	private void init() {
		people.add(new Staff("Gaige", "Kinsey", 1976, Department.values()[2]));
		people.add(new Staff("Sam", "Crampus", 1964, Department.values()[1]));
		people.add(new Staff("Gerald", "Cox", 1984, Department.values()[0]));
		people.add(new Staff("Creed", "Vance", 1992, Department.values()[3]));
		people.add(new Faculty("Prim", "Milton", 1981, Degree.values()[4]));
		people.add(new Faculty("John", "Wilcox", 1953, Degree.values()[3]));
		people.add(new Faculty("Colton", "Wes", 1972, Degree.values()[2]));
		people.add(new Faculty("Derald", "Sinco", 1969, Degree.values()[1]));
		people.add(new Faculty("Gian", "Tron", 1989, Degree.values()[0]));
		people.add(new Student("Cory", "Goatslinger", 2001, 2.5));
		people.add(new Student("Caitlyn", "Jenkins", 1999, 3.5));
		people.add(new Student("Josh", "Samson", 2002, 4.0));
	}
}
