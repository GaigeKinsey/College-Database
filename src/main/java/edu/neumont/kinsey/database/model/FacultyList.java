package edu.neumont.kinsey.database.model;

import java.util.ArrayList;

public class FacultyList extends ArrayList<Faculty> implements Savable{

	private static final long serialVersionUID = 1L;

	@Override
	public String getFileName() {
		return "faculty.txt";
	}

	@Override
	public String toSaveFormat() {
		String result = "";
		for (Faculty faculty : this) {
			result += faculty.serialize() + "; ";
		}
		return result;
	}

	@Override
	public void fromLoadFormat(String s) {
		String[] pieces = s.trim().split(";");
		for (String piece : pieces) {
			Faculty faculty = new Faculty();
			faculty.deserialize(piece);
			this.add(faculty);
		}
	}
}
