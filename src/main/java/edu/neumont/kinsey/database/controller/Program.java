package edu.neumont.kinsey.database.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.neumont.kinsey.database.model.CollegeDatabase;
import edu.neumont.kinsey.database.model.Degree;
import edu.neumont.kinsey.database.model.Department;
import edu.neumont.kinsey.database.model.Faculty;
import edu.neumont.kinsey.database.model.Person;
import edu.neumont.kinsey.database.model.Staff;
import edu.neumont.kinsey.database.model.Student;
import edu.neumont.kinsey.database.view.UserInterface;

public class Program {
	UserInterface userInterface = new UserInterface();
	CollegeDatabase database = new CollegeDatabase();

	public void run() {
		init();
		database.sort();
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
			case 5:
				speakPerson();
				break;
			default:
				System.out.println("This shouldn't have happened.");
			}
			database.sort();
		} while (!quit);
	}

	private void compareDatabase() {
		List<Person> people = new ArrayList<>();
		for (Person person : database) {
			people.add(person);
		}
		String[] peopleChoices = new String[people.size()];
		for (int i = 0; i < peopleChoices.length; i++) {
			peopleChoices[i] = people.get(i).getFirstName() + " " + people.get(i).getLastName();
		}
		int personChoice1 = userInterface.promptForCompare1(peopleChoices) - 1;
		Person person1 = people.get(personChoice1);
		people.remove(personChoice1);
		peopleChoices = new String[people.size()];
		for (int i = 0; i < peopleChoices.length; i++) {
			peopleChoices[i] = people.get(i).getFirstName() + " " + people.get(i).getLastName();
		}
		int personChoice2 = userInterface.promptForCompare2(peopleChoices) - 1;
		Person person2 = people.get(personChoice2);
		
		if (person1 instanceof Student && person2 instanceof Student) {
			if (person1.compareTo(person2) > 0) {
				userInterface.notifyCompareResult(person1.getFirstName() + " " + person1.getLastName()
						+ " has a higher GPA than " + person2.getFirstName() + " " + person2.getLastName());
			} else if (person1.compareTo(person2) < 0) {
				userInterface.notifyCompareResult(person1.getFirstName() + " " + person1.getLastName()
						+ " has a lower GPA than " + person2.getFirstName() + " " + person2.getLastName());
			} else {
				userInterface.notifyCompareResult(person1.getFirstName() + " " + person1.getLastName()
						+ " has the same GPA as " + person2.getFirstName() + " " + person2.getLastName());
			}
		} else {
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
		LocalDate birthDate = userInterface.promptForBirthDate();
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
	
	private void speakPerson() {
		List<String> names = new ArrayList<>();
		for (Person person : database) {
			names.add(person.getLastName() + ", " + person.getFirstName());
		}
		String[] personOptions = new String[names.size()];
		personOptions = names.toArray(personOptions);
		int speakerSelection = userInterface.promptForSpeaker(personOptions) - 1;
		database.get(speakerSelection).speak();
	}

	private void init() {
		database.add(new Staff("Gerald", "Cox", LocalDate.of(1980, 10, 25), Department.values()[0]));
		database.add(new Staff("Sam", "Crampus", LocalDate.of(1960, 8, 20), Department.values()[1]));
		database.add(new Staff("Gaige", "Kinsey", LocalDate.of(1970, 12, 15), Department.values()[2]));
		database.add(new Staff("Creed", "Vance", LocalDate.of(1989, 10, 29), Department.values()[3]));
		database.add(new Faculty("Gian", "Tron", LocalDate.of(1960, 2, 8), Degree.values()[0]));
		database.add(new Faculty("Derald", "Sinco", LocalDate.of(1999, 11, 1), Degree.values()[1]));
		database.add(new Faculty("Colton", "Wes", LocalDate.of(1990, 4, 6), Degree.values()[2]));
		database.add(new Faculty("John", "Wilcox", LocalDate.of(1992, 7, 7), Degree.values()[3]));
		database.add(new Faculty("Prim", "Milton", LocalDate.of(1984, 5, 12), Degree.values()[4]));
		database.add(new Student("Cory", "Goatslinger", LocalDate.of(1972, 10, 14), 2.5));
		database.add(new Student("Caitlyn", "Jenkins", LocalDate.of(1964, 4, 17), 3.5));
		database.add(new Student("Josh", "Samson", LocalDate.of(1995, 8, 14), 4.0));
	}
}
