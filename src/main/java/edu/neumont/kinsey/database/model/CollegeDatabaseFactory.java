package edu.neumont.kinsey.database.model;

public class CollegeDatabaseFactory implements SavableFactory{

	@Override
	public Savable createInstance() {
		return new CollegeDatabase();
	}
}
