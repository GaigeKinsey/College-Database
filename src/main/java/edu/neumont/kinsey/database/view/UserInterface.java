package edu.neumont.kinsey.database.view;

import lib.ConsoleIO;

public class UserInterface {

	public int databaseOptions() {
		ConsoleIO.displayMessage("What do you want to do?");
		return ConsoleIO.promptForMenuSelection(
				new String[] { "Add A Person", "Remove A Person", "Compare People", "Print Database" }, true);
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

	public int promptForBirthDate() {
		return ConsoleIO.promptForInt("What year was the person born?", 1900, 2019);
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

	public int promptForCompareType() {
		ConsoleIO.displayMessage("What would you like to compare?");
		return ConsoleIO.promptForMenuSelection(new String[] { "Student", "Faculty", "Staff" }, false);
	}

	public int promptForCompareStudent1(String[] studentChoices) {
		ConsoleIO.displayMessage("Which Student do you want to compare?");
		return ConsoleIO.promptForMenuSelection(studentChoices, false);
	}

	public int promptForCompareStudent2(String[] studentChoices) {
		ConsoleIO.displayMessage("Which Student do you want to compare them to?");
		return ConsoleIO.promptForMenuSelection(studentChoices, false);
	}

	public void notifyCompareResult(String string) {
		ConsoleIO.displayMessage(string);
	}

	public int promptForComparePerson1(String[] peopleChoices) {
		ConsoleIO.displayMessage("Which Faculty or Staff do you want to compare?");
		return ConsoleIO.promptForMenuSelection(peopleChoices, false);
	}

	public int promptForComparePerson2(String[] peopleChoices) {
		ConsoleIO.displayMessage("Which Faculty or Staff do you want to compare them to?");
		return ConsoleIO.promptForMenuSelection(peopleChoices, false);
	}
}
