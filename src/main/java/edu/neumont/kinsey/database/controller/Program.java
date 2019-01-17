package edu.neumont.kinsey.database.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.neumont.kinsey.database.model.Degree;
import edu.neumont.kinsey.database.model.Department;
import edu.neumont.kinsey.database.model.Faculty;
import edu.neumont.kinsey.database.model.Person;
import edu.neumont.kinsey.database.model.Staff;
import edu.neumont.kinsey.database.model.Student;
import edu.neumont.kinsey.database.view.UserInterface;

public class Program {
	UserInterface userInterface = new UserInterface();
	List<Person> database = new ArrayList<>();

	public void run() {
		init();
		Collections.sort(database);
		boolean quit = false;
		do {
			int selection = userInterface.databaseOptions();
			switch (selection) {
			case 0:
				quit = true;
				break;
			case 1:
				addPerson();
				break;
			case 2:
				if (removePerson()) {
					userInterface.notifyRemoval("Person successfully removed.");
				} else {
					userInterface.notifyRemoval("Nobody has been removed.");
				}
				break;
			case 3:
				compareDatabase();
				break;
			case 4:
				printDatabase();
				break;
			default:
				System.out.println("This shouldn't have happened.");
			}
			Collections.sort(database);
		} while (!quit);
	}

	private void compareDatabase() {
		int typeChoice = userInterface.promptForCompareType();
		if (typeChoice == 1) {
			List<Student> students = new ArrayList<>();
			for (Person person : database) {
				if (person instanceof Student) {
					students.add((Student) person);
				}
			}
			String[] studentChoices = new String[students.size()];
			for (int i = 0; i < studentChoices.length; i++) {
				studentChoices[i] = students.get(i).getFirstName() + " " + students.get(i).getLastName();
			}
			int selection1 = userInterface.promptForCompareStudent1(studentChoices) - 1;
			Student student1 = students.get(selection1);
			students.remove(selection1);
			studentChoices = new String[students.size()];
			for (int i = 0; i < studentChoices.length; i++) {
				studentChoices[i] = students.get(i).getFirstName() + " " + students.get(i).getLastName();
			}
			Student student2 = students.get(userInterface.promptForCompareStudent2(studentChoices) - 1);
			if (student1.equals(student2)) {
				userInterface.notifyCompareResult(student1.getFirstName() + " " + student1.getLastName()
						+ " has the same GPA as " + student2.getFirstName() + " " + student2.getLastName());
			} else {
				userInterface.notifyCompareResult(student1.getFirstName() + " " + student1.getLastName()
						+ " has a different GPA than " + student2.getFirstName() + " " + student2.getLastName());
			}
		} else {
			List<Person> people = new ArrayList<>();
			for (Person person : database) {
				if (person instanceof Faculty || person instanceof Staff) {
					people.add(person);
				}
			}
			String[] peopleChoices = new String[people.size()];
			for (int i = 0; i < peopleChoices.length; i++) {
				peopleChoices[i] = people.get(i).getFirstName() + " " + people.get(i).getLastName();
			}
			int selection1 = userInterface.promptForComparePerson1(peopleChoices) - 1;
			Person person1 = people.get(selection1);
			people.remove(selection1);
			peopleChoices = new String[people.size()];
			for (int i = 0; i < peopleChoices.length; i++) {
				peopleChoices[i] = people.get(i).getFirstName() + " " + people.get(i).getLastName();
			}
			Person person2 = people.get(userInterface.promptForComparePerson2(peopleChoices) - 1);
			if (person1.compareTo(person2) == 0) {
				userInterface.notifyCompareResult(person1.getFirstName() + " " + person1.getLastName() + " and "
						+ person2.getFirstName() + " " + person2.getLastName() + " have the same last name.");
			} else {
				userInterface.notifyCompareResult(person1.getFirstName() + " " + person1.getLastName() + " and "
						+ person2.getFirstName() + " " + person2.getLastName() + " have different last names.");
			}
		}
	}

	private void printDatabase() {
		StringBuilder sb = new StringBuilder();
		for (Person person : database) {
			sb.append(person.toString() + "\n\n");
		}
		userInterface.printDatabase(sb.toString());
	}

	private boolean removePerson() {
		boolean removed = false;
		List<String> names = new ArrayList<>();
		for (Person person : database) {
			names.add(person.getLastName() + ", " + person.getFirstName());
		}
		String[] personOptions = new String[names.size()];
		personOptions = names.toArray(personOptions);
		int selection = userInterface.promptForRemoval(personOptions) - 1;
		if (selection > -1) {
			database.remove(selection);
			removed = true;
		}
		return removed;
	}

	private void addPerson() {
		int type = userInterface.promptForType();
		String firstName = userInterface.promptForFirstName();
		String lastName = userInterface.promptForLastName();
		int birthDate = userInterface.promptForBirthDate();
		switch (type) {
		case 1:
			double GPA = userInterface.promptForGPA();
			database.add(new Student(firstName, lastName, birthDate, GPA));
			break;
		case 2:
			List<String> degrees = new ArrayList<>();
			for (Degree degree : Degree.values()) {
				degrees.add(degree.toString().replaceAll("_", " "));
			}
			String[] degreeOptions = new String[degrees.size()];
			degreeOptions = degrees.toArray(degreeOptions);
			Degree degreeChoice = Degree.values()[userInterface.promptForDegree(degreeOptions) - 1];
			database.add(new Faculty(firstName, lastName, birthDate, degreeChoice));
			break;
		case 3:
			List<String> departments = new ArrayList<>();
			for (Department department : Department.values()) {
				departments.add(department.toString().replaceAll("_", " "));
			}
			String[] departmentOptions = new String[departments.size()];
			departmentOptions = departments.toArray(departmentOptions);
			Department departmentChoice = Department.values()[userInterface.promptForDepartment(departmentOptions) - 1];
			database.add(new Staff(firstName, lastName, birthDate, departmentChoice));
			break;
		default:
			System.out.println("This shouldn't have happened.");
		}
	}

	private void init() {
		database.add(new Staff("Gerald", "Cox", 1984, Department.values()[0]));
		database.add(new Staff("Sam", "Crampus", 1964, Department.values()[1]));
		database.add(new Staff("Gaige", "Kinsey", 1976, Department.values()[2]));
		database.add(new Staff("Creed", "Vance", 1992, Department.values()[3]));
		database.add(new Faculty("Gian", "Tron", 1989, Degree.values()[0]));
		database.add(new Faculty("Derald", "Sinco", 1969, Degree.values()[1]));
		database.add(new Faculty("Colton", "Wes", 1972, Degree.values()[2]));
		database.add(new Faculty("John", "Wilcox", 1953, Degree.values()[3]));
		database.add(new Faculty("Prim", "Milton", 1981, Degree.values()[4]));
		database.add(new Student("Cory", "Goatslinger", 2001, 2.5));
		database.add(new Student("Caitlyn", "Jenkins", 1999, 3.5));
		database.add(new Student("Josh", "Samson", 2002, 4.0));
	}
}
