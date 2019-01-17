package edu.neumont.kinsey.database.view;

import java.time.DateTimeException;
import java.time.LocalDate;

import lib.ConsoleIO;

public class UserInterface {

	public int databaseOptions() {
		ConsoleIO.displayMessage("What do you want to do?");
		return ConsoleIO.promptForMenuSelection(new String[] { "Add A Person", "Remove A Person", "Compare People",
				"Print Database", "Make Someone Speak" }, true);
	}

	public void printDatabase(String database) {
		ConsoleIO.displayMessage(database);
	}

	public int promptForRemoval(String[] personOptions) {
		ConsoleIO.displayMessage("Who do you want to remove from the database?");
		return ConsoleIO.promptForMenuSelection(personOptions, true);
	}

	public void notifyRemoval(String string) {
		ConsoleIO.displayMessage(string);
	}

	public int promptForType() {
		ConsoleIO.displayMessage("What type of person would you like to add to the database?");
		return ConsoleIO.promptForMenuSelection(new String[] { "Student", "Faculty", "Staff" }, false);
	}

	public String promptForFirstName() {
		return ConsoleIO.promptForInput("What is the person's first name?", false);
	}

	public String promptForLastName() {
		return ConsoleIO.promptForInput("What is the person's last name?", false);
	}

	public LocalDate promptForBirthDate() {
		LocalDate birthDate = null;
		boolean successful = false;
		do {
			int year = ConsoleIO.promptForInt("What year was the person born? (1900-2019)", 1900, 2019);
			int month = ConsoleIO.promptForInt("What month was the person born? (1-12)", 1, 12);
			int day = ConsoleIO.promptForInt("What day was the person born?", 1, 31);
			try {
				birthDate = LocalDate.of(year, month, day);
				successful = true;
			} catch (DateTimeException ex) {
				ConsoleIO.displayMessage("Must enter a valid date.");
			}
		} while (!successful);
		return birthDate;
	}

	public double promptForGPA() {
		return ConsoleIO.promptForDouble("What is the Student's GPA?", 0.0, 4.0);
	}

	public int promptForDegree(String[] degreeOptions) {
		ConsoleIO.displayMessage("What is the Faculty's Degree?");
		return ConsoleIO.promptForMenuSelection(degreeOptions, false);
	}

	public int promptForDepartment(String[] departmentOptions) {
		ConsoleIO.displayMessage("What is the Staff's Department?");
		return ConsoleIO.promptForMenuSelection(departmentOptions, false);
	}

	public int promptForCompare1(String[] people) {
		ConsoleIO.displayMessage("Which Person would you like to compare?");
		return ConsoleIO.promptForMenuSelection(people, false);
	}

	public int promptForCompare2(String[] peopleChoices) {
		ConsoleIO.displayMessage("Which Person do you want to compare them to?");
		return ConsoleIO.promptForMenuSelection(peopleChoices, false);
	}

	public void notifyCompareResult(String string) {
		ConsoleIO.displayMessage(string);
	}

	public int promptForSpeaker(String[] options) {
		ConsoleIO.displayMessage("Who do you want to speak?");
		return ConsoleIO.promptForMenuSelection(options, false);
	}
}
