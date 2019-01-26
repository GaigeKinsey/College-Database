package edu.neumont.kinsey.database.model;

public interface Savable {
	String getFileName();
	
	String toSaveFormat();
	
	void fromLoadFormat(String s);
}
